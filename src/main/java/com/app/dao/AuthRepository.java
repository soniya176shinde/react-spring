package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.Login;
import java.util.Optional;

public interface AuthRepository extends JpaRepository<Login,String> {

	@Query("select u from Login u where u.email=:em and u.password=:pass")
	Optional<Login> validateUser(@Param("em")String email,@Param("pass") String pwd);

}
