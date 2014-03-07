package com.pi.javateam.services;


import com.pi.javateam.domain.Customer;
import com.pi.javateam.domain.Project;
import com.pi.javateam.domain.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by pi on 2/12/14.
 */
public interface ProjectService {
    Project findById(Long teamId);
    Page<Project> findByTeamId(Long teamId, Pageable pageable);
    List<Project> findByTeamId(Long teamId);
    List<Project> searchByTeamIdAndName(Long teamId, String name);
}
