package com.pi.javateam.services;

import com.pi.javateam.domain.Project;
import com.pi.javateam.domain.Team;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Set;

/**
 * Created by pi on 2/12/14.
 */
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    ProjectRepository projectRepository;

    @Inject
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project findById(Long projectId) {
        return projectRepository.findOne(projectId);
    }

    @Override
    public Team findTeamByProjectId(Long projectId) {
        return null;
    }

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Set<Project> findByName() {
        return null;
    }
}
