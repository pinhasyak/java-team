package com.pi.javateam.services;

import com.pi.javateam.domain.Team;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by pi on 2/12/14.
 */
@Service
@Transactional
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;

    @Inject
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team findById(Long id) {
        return teamRepository.findOne(id);
    }

    @Override
    public Iterable<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Iterable<Team> findByName(String teamName) {
        return null;
    }
}
