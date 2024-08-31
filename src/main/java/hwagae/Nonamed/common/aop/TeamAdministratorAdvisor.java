package hwagae.Nonamed.common.aop;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import hwagae.Nonamed.member.model.Member;
import hwagae.Nonamed.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Aspect
@Order(1)
@Slf4j
@Component
@RequiredArgsConstructor
public class TeamAdministratorAdvisor {

    @Value("${jwt.header}")
    private String header;

    @Value("${jwt.secret.key}")
    private String key;

    private final MemberService memberService;

    /**
     * 어노테이션 기반 AOP
     * 팀 관련 기능에서 사용
     * 접속한 사용자가 관리자인지 아닌지 판별
     */
    @Before("@annotation(hwagae.Nonamed.common.annotation.TeamAdministration)")
    public void validIsTeamAdminister(JoinPoint joinPoint) {
        Object[] argument = joinPoint.getArgs();
        HttpServletRequest request = null;

        for(Object arg : argument) {
            if(arg instanceof HttpServletRequest) {
                request = (HttpServletRequest) arg;
            }
        }

        if(request == null) {
            throw new RuntimeException();
        }

        String authToken = request.getHeader(header);
        String teamId = request.getParameter("teamId");

        if(authToken.isBlank() || authToken.isEmpty())
            throw new RuntimeException();

        if(!isAdminister(authToken, Long.valueOf(teamId))) {
            throw new RuntimeException();//넌 관리자가 아니야
        }
    }

    private boolean isAdminister(String token, Long teamId) {
        String username = JWT.require(Algorithm.HMAC512(key)).build().verify(token).toString();

        Optional<Member> tagetMember = memberService.findByUsername(username, teamId);

        if(tagetMember.isEmpty())
            return false;

        Member member = tagetMember.get();

        return member.getGrade().getName().equals("ADMIN");
    }
}
