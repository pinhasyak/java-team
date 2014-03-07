package com.pi.javateam.repositories;

import com.pi.javateam.domain.Team;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by pi on 2/12/14.
 */
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {
    List<Team> findTeamByName(String name);
    List<Team> findByCompany(@Param("company")String companyName);
    Team findTeamById(Long id);

}
