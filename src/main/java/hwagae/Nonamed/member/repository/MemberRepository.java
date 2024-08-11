package hwagae.Nonamed.member.repository;

import hwagae.Nonamed.member.model.Member;
import hwagae.Nonamed.team.model.Team;
import hwagae.Nonamed.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    /**
     * 사용자 정보와 팀 정보로 해당하는 멤버 정보를 가져온다.
     * @param user - 사용자
     * @param team - 접근할 팀
     * @return Member 정보
     */
    Optional<Member> findByUserAndTeam(User user, Team team);
}
