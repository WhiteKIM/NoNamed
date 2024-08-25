package hwagae.Nonamed.member.service.impl;

import hwagae.Nonamed.member.model.Member;
import hwagae.Nonamed.member.repository.MemberRepository;
import hwagae.Nonamed.member.service.MemberService;
import hwagae.Nonamed.team.model.Team;
import hwagae.Nonamed.team.repository.TeamRepository;
import hwagae.Nonamed.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    /**
     * 사용자를 팀에 등록시킨다.
     * @param user - 팀에 등록할 사용자
     * @param teamId - 소속될 팀 아이디
     * @return
     */
    @Override
    public Member createMember(User user, Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow();

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
        Optional<Member> deleteMember = memberRepository.findById(id);

        if(deleteMember.isEmpty())
            throw new RuntimeException();//@TODO 추후 적절한 예외로 변경

        Member member = deleteMember.get();
        List<Member> teamMemberList = member.getTeam().getTeamMemberList();
        teamMemberList.remove(member);//해당 멤버를 팀에서 제거한다.
        memberRepository.deleteById(id);//팀에서 탈퇴를 완료하면 필요없는 사용자 정보는 제거
    }
}
