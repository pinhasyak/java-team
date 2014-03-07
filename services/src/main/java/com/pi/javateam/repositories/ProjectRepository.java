package com.pi.javateam.repositories;

import com.pi.javateam.domain.Customer;
import com.pi.javateam.domain.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import java.util.List;

/**
 * Created by pi on 2/12/14.
 */
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
    Page<Project> findByTeamId(@Param("teamId") Long teamId, Pageable pageable);
    List<Project> findByTeamId(@Param("teamId") Long teamId);
    @Query("select c from Project c where  c.team.id = :teamId and (LOWER(c.name) LIKE :q   )")
    List<Project> search(@Param("teamId") Long teamId,  @Param("q") String query);
}
