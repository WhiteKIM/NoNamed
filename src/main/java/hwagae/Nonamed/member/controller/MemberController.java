package hwagae.Nonamed.member.controller;

import hwagae.Nonamed.common.model.CommonRespEntity;
import hwagae.Nonamed.member.model.Member;
import hwagae.Nonamed.user.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @GetMapping
    public CommonRespEntity<Member> getMembers() {
        return new CommonRespEntity<>(200, "OK", null);
    }
}
