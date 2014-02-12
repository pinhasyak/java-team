package com.pi.javateam.repository;

import com.pi.javateam.domain.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by pi on 2/12/14.
 */
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
}
