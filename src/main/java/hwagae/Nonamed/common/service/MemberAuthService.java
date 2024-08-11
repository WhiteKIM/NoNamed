package hwagae.Nonamed.common.service;

import hwagae.Nonamed.member.model.Member;
import hwagae.Nonamed.member.repository.MemberRepository;
import hwagae.Nonamed.member.service.MemberService;
import hwagae.Nonamed.team.model.Team;
import hwagae.Nonamed.team.repository.TeamRepository;
import hwagae.Nonamed.user.model.User;
import hwagae.Nonamed.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberAuthService {

    private final MemberRepository memberRepository;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    /**
     * 로그인 사용자 정보와 접근하는 팀 ID를 기본으로 해당 멤버 정보를 가져온다.
     * @param user - 로그인 사용자
     * @param teamName - 팀 이름
     * @return - 멤버 정보
     */
    public Optional<Member> getMemberByTeamAndUserInfo(User user, String teamName) {
        Optional<Team> optionalTeam = teamRepository.findByTeamName(teamName);
        if(optionalTeam.isEmpty())
            throw new RuntimeException(); /* @TODO 적절한 예외 반환하기 */

        return memberRepository.findByUserAndTeam(user, optionalTeam.get());
    }
}
