package hwagae.Nonamed.common.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import hwagae.Nonamed.common.model.UserDetail;
import hwagae.Nonamed.user.model.User;
import hwagae.Nonamed.user.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.Optional;

@Slf4j
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {
    @Value("${jwt.header}")
    private String header;

    @Value("${jwt.secret.key}")
    private String key;

    private final UserRepository userRepository;
    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
        super(authenticationManager);
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("인증 시작");
        String jwtToken = request.getHeader(header);

        if(jwtToken.isEmpty() || jwtToken.isBlank()) {
            throw new RuntimeException(); // @TODO 적당한 예외를 만들어주세요.
        }

        String username = JWT.require(Algorithm.HMAC512(key)).build().verify(jwtToken).toString();

        if(username.isEmpty() || username.isBlank()) {
            Optional<User> optionalUser =
                    userRepository.findByUsername(username);

            if(optionalUser.isEmpty())
                throw new RuntimeException();

            UserDetail userDetail = new UserDetail(optionalUser.get());
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        chain.doFilter(request, response);
    }
}
