package hwagae.Nonamed.member.service.impl;

import hwagae.Nonamed.member.model.Member;
import hwagae.Nonamed.member.repository.MemberRepository;
import hwagae.Nonamed.member.service.MemberService;
import hwagae.Nonamed.team.model.Team;
import hwagae.Nonamed.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    /**
     * 사용자를 팀에 등록시킨다.
     * @param user - 팀에 등록할 사용자
     * @param team - 소속될 팀
     * @return
     */
    @Override
    public Member createMember(User user, Team team) {
        Member member = Member
                .builder()
                .user(user)
                .team(team)
                .build();

        memberRepository.save(member);
        team.registerMember(member);
        return member;
    }

    /**
     * 사용자가 팀에서 탈퇴하는 기능
     * @param id - 해당 사용자의 UUID
     */
    @Override
    public void deleteTeam(String id) {
        memberRepository.deleteById(id);
    }
}
