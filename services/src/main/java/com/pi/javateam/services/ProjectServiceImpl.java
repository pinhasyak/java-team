package com.pi.javateam.services;

import com.pi.javateam.domain.Customer;
import com.pi.javateam.domain.Project;
import com.pi.javateam.domain.Team;
import com.pi.javateam.repositories.ProjectRepository;
import org.springframework.data.domain.Page;
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
public class ProjectServiceImpl implements ProjectService {
    @Inject
    ProjectRepository projectRepository;

    @Override
    public Project findById(Long teamId) {
        return projectRepository.findOne(teamId);
    }

    @Override
    public Page<Project> findByTeamId(Long teamId, Pageable pageable) {
        return projectRepository.findByTeamId(teamId, pageable);
    }

    @Override
    public List<Project> findByTeamId(Long teamId) {
        return projectRepository.findByTeamId(teamId);
    }

    @Override
    public List<Project> searchByTeamIdAndName(Long teamId, String name) {
        return projectRepository.search(teamId,name);
    }

}
