package hwagae.Nonamed.team.controller;

import hwagae.Nonamed.common.model.CommonRespEntity;
import hwagae.Nonamed.team.dto.request.CreateTeamDto;
import hwagae.Nonamed.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {
    private final TeamService teamService;

    @PostMapping("/create")
    public CommonRespEntity<String> createTeam(CreateTeamDto createTeam) {
        teamService.createTeam(createTeam);

        return new CommonRespEntity<>(200, "success", null);
    }
}
