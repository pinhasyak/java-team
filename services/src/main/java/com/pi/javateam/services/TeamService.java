package com.pi.javateam.services;

import com.pi.javateam.domain.Project;
import com.pi.javateam.domain.Team;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by pi on 2/12/14.
 */
@Service
@Transactional
public interface TeamService {
    List<Team> findAll();
    List<Team> findAll(Pageable pageable);
    List<Team> findTeamsByName(String teamName);
    List<Team> findTeamsByCompany(String companyName);
    Team findById(Long id);
    Team createTeam(String teamName, String companyName, Set<Project> projects);
    Team save(Team team);
}
