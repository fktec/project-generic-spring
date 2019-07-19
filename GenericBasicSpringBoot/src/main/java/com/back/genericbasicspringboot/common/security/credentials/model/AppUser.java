package com.back.genericbasicspringboot.common.security.credentials.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "app_user")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Column(name="username")
	private String username;
	
	@NonNull
	@Column(name="email")
	private String email;
	
	@NonNull
	@Column(name="password")
	private String password;
	
	@NonNull
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id_app_user"), inverseJoinColumns = @JoinColumn(name = "id_app_client"))
	private List<Role> roles;
}
