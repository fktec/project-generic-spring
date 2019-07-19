package com.back.genericbasicspringboot.common.security.credentials.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.back.genericbasicspringboot.common.security.credentials.model.AppUser;

public interface AppUserDetailsRepository extends JpaRepository<AppUser, Long> {

	Optional<AppUser> findByEmail(String email);
}
