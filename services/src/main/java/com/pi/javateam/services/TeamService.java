package com.pi.javateam.services;

import com.pi.javateam.domain.Team;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by pi on 2/12/14.
 */
@Service
@Transactional
public interface TeamService {
    Iterable<Team> findAll();
    Iterable<Team> findByName(String teamName);
    Team findById(Long id);
}
