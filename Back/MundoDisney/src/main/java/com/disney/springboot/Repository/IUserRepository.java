package com.disney.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.disney.springboot.Model.User;

public interface IUserRepository  extends JpaRepository<User,Long> {
	
	@Query("FROM User WHERE email=:email")
	User findByEmail(@Param("email") String email);

}
