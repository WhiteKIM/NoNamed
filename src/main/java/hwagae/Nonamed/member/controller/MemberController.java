package hwagae.Nonamed.member.controller;

import hwagae.Nonamed.common.model.CommonRespEntity;
import hwagae.Nonamed.common.model.UserDetail;
import hwagae.Nonamed.member.model.Member;
import hwagae.Nonamed.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public CommonRespEntity<Member> getMembers() {
        return new CommonRespEntity<>(200, "OK", null);
    }

    @PostMapping("/join")
    public CommonRespEntity<String> joinTeam(@AuthenticationPrincipal UserDetail userDetail, @RequestParam Long teamId) {
        memberService.createMember(userDetail.getUser(), teamId);

        return new CommonRespEntity<>(200, "Join Success", "Join Success");
    }
}
