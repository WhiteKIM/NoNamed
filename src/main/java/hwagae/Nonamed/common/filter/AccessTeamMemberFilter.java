package hwagae.Nonamed.common.filter;

import hwagae.Nonamed.common.model.UserDetail;
import hwagae.Nonamed.common.service.MemberAuthService;
import hwagae.Nonamed.member.model.Member;
import hwagae.Nonamed.user.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class AccessTeamMemberFilter implements Filter {

    private final MemberAuthService memberAuthService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String[] path = httpServletRequest.getRequestURI().split("/");
        
        if(!path[1].equals("team")) {
            log.info("해당 접근은 멤버 처리 필요없음");
            chain.doFilter(request, response); // 가세요라
        }
        
        log.info("멤버 정보 검증");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetail userPrincipal = (UserDetail) authentication.getPrincipal();

        if(userPrincipal == null)
            throw new RuntimeException(); /* @TODO 적절한 예제 */

        

        // /api/team/{teamId or teamName}/쿼리 파라미터 등등
        String teamName = path[2];
        User loginUser = userPrincipal.getUser();

        // 사용자 정보를 가져오자
        Optional<Member> memberInfo =
                memberAuthService.getMemberByTeamAndUserInfo(loginUser, teamName);

        if(memberInfo.isEmpty())
            throw new RuntimeException(); /* @TODO 접근 예외 */

        chain.doFilter(request, response);
    }
}
