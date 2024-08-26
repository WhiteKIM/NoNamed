package hwagae.Nonamed.common.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import hwagae.Nonamed.common.model.UserDetail;
import hwagae.Nonamed.user.dto.request.LoginUserDto;
import hwagae.Nonamed.user.model.User;
import hwagae.Nonamed.user.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Date;

@RequiredArgsConstructor
@Slf4j
public class JwtAuthorizationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    @Value("${jwt.secret.key}")
    private String key;

    @Value("${jwt.header}")
    private String header;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            ObjectMapper om = new ObjectMapper();
            LoginUserDto loginUserDto = om.readValue(request.getInputStream(), LoginUserDto.class);

            User user = userService.login(loginUserDto);

            if(user == null) {
                throw new RuntimeException();
            }

            UsernamePasswordAuthenticationToken authenticationToken
                    = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            log.info("로그인 정보 : {}", authentication.getPrincipal());

            return authentication;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserDetail loginInfo = (UserDetail) authResult.getPrincipal();

        String jwtToken = JWT.create()
                .withSubject(loginInfo.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + (1000 * 60 * 60)))
                .withClaim("username", loginInfo.getUsername())
                .sign(Algorithm.HMAC512(key));

        response.addHeader(header, jwtToken);
    }
}
