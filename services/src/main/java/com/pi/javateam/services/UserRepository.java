package com.pi.javateam.services;

import com.pi.javateam.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 * Base services for persisting {@link com.pi.javateam.domain.User} users
 *
 */
//@RestResource (path = "users", rel = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	User findByUsername(@Param("username") String username);

	List<User> findUsersByFirstNameOrLastNameOrUsername(
			@Param("firstName") String firstName,
            @Param("lastName") String lastName,
			@Param("username") String username);

}
