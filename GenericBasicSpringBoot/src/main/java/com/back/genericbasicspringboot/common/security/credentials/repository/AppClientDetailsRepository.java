package com.back.genericbasicspringboot.common.security.credentials.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.back.genericbasicspringboot.common.security.credentials.model.AppClient;

public interface AppClientDetailsRepository extends JpaRepository<AppClient, Long> {

	@Query("SELECT distinct(c) FROM AppClient c WHERE c.client_id= :clientId")
	Optional<AppClient> findByClientId(@Param("clientId") String clientId);
}
