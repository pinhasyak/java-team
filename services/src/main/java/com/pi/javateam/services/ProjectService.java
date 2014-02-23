package com.pi.javateam.services;


import com.pi.javateam.domain.Project;
import com.pi.javateam.domain.Team;

/**
 * Created by pi on 2/12/14.
 */
public interface ProjectService {
    Project findById(Long projectId);
    Team findTeamByProjectId(Long projectId);
    Iterable<Project> findAll();
    Iterable<Project> findByName();
}
