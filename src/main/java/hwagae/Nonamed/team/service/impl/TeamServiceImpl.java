package hwagae.Nonamed.team.service.impl;

import hwagae.Nonamed.team.dto.request.CreateTeamDto;
import hwagae.Nonamed.team.repository.TeamRepository;
import hwagae.Nonamed.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;


    @Override
    public void createTeam(CreateTeamDto teamDto) {
        teamRepository.save(teamDto.toEntity());
    }
}
