package com.pi.javateam.repositories;

/**
 * Created by pi on 2/24/14.
 */

import com.pi.javateam.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * Base services for persisting {@link com.pi.javateam.domain.User} users
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    User findByUsername(@Param("username") String username);

    List<User> findUsersByFirstNameOrLastNameOrUsername(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("username") String username);

}