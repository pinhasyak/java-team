package com.pi.javateam.services;

import com.pi.javateam.domain.Project;
import com.pi.javateam.domain.Team;
import com.pi.javateam.repositories.TeamRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;

/**
 * Created by pi on 2/12/14.
 */
@Service
@Transactional
public class TeamServiceImpl implements TeamService {
    @Inject
    private TeamRepository teamRepository;

    @Override
    public Team findById(Long id) {
        return teamRepository.findOne(id);
    }

    @Override
    public Team createTeam(String teamName, String companyName, Set<Project> projects) {
        Team team = new Team(teamName,"company_name",projects);
        teamRepository.save(team);
        return team;
    }

    @Override
    public Team save(Team team) {
        teamRepository.save(team);
        return team;
    }

    @Override
    public List<Team> findAll() {
        return (List)teamRepository.findAll();
    }

    @Override
    public List<Team> findAll(Pageable pageable) {
        return (List)teamRepository.findAll(pageable);
    }

    @Override
    public List<Team> findTeamsByName(String teamName) {
        return teamRepository.findTeamByName(teamName);
    }

    @Override
    public List<Team> findTeamsByCompany(String companyName) {
        return teamRepository.findByCompany(companyName);
    }
}
