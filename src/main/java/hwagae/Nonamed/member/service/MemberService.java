package hwagae.Nonamed.member.service;

import hwagae.Nonamed.member.model.Member;
import hwagae.Nonamed.team.model.Team;
import hwagae.Nonamed.user.model.User;

/**
 * Team에 소속된 사용자 관련 기능
 * @Notice : 모든 Member는 항상 팀에 소속되어야 한다.
 * @author WhiteKIM
 * @date 2024.08.03
 */
public interface MemberService {
    Member createMember(User user, Team team);
    void deleteTeam(String id);
}
