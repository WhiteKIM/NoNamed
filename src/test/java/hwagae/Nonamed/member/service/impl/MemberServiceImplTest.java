package hwagae.Nonamed.member.service.impl;

import hwagae.Nonamed.member.model.Member;
import hwagae.Nonamed.member.service.MemberService;
import hwagae.Nonamed.team.model.Team;
import hwagae.Nonamed.team.repository.TeamRepository;
import hwagae.Nonamed.user.model.User;
import hwagae.Nonamed.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceImplTest {

    @Autowired
    MemberService memberService;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    UserRepository userRepository;

    /**
     * 해당 팀에 잘 소속되는지 확인
     */
    @Test
    void createMember() {
        Team testTeam = Team.builder()
                .description("test")
                .purpose("test")
                .teamName("test")
                .build();

        User testUser = User.builder()
                .username("test")
                .password("test")
                .nickname("test")
                .build();

        userRepository.save(testUser);
        teamRepository.save(testTeam);
        Member member = memberService.createMember(testUser, testTeam);

        Assertions.assertThat(member.getUser().getUsername()).isEqualTo("test");
        Assertions.assertThat(member.getTeam().getTeamName()).isEqualTo("test");
        Assertions.assertThat(testTeam.getTeamMemberList().get(0).getId()).isEqualTo(member.getId());
    }

    @Test
    void deleteTeam() {
        Team testTeam = Team.builder()
                .description("test")
                .purpose("test")
                .teamName("test")
                .build();

        User testUser = User.builder()
                .username("test")
                .password("test")
                .nickname("test")
                .build();

        userRepository.save(testUser);
        teamRepository.save(testTeam);
        Member member = memberService.createMember(testUser, testTeam);

        Assertions.assertThat(testTeam.getTeamMemberList()).contains(member);

        memberService.deleteTeam(member.getId());
        Assertions.assertThat(testTeam.getTeamMemberList()).isNotIn(member);
    }
}