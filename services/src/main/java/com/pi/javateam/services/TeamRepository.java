package com.pi.javateam.services;

import com.pi.javateam.domain.Team;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by pi on 2/12/14.
 */
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {
}
