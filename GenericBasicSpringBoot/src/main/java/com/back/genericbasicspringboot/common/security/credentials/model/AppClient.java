package com.back.genericbasicspringboot.common.security.credentials.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="app_client")
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
public class AppClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Column(name="client_id")
	private String clientId;
	
	@NonNull
	@JsonIgnore
	@Column(name="client_secret")
	private String secret;
	
	@NonNull
	@Column(name="scope")
	private String scope;
	
	@NonNull
	@Column(name="authorized_grant_types")
	private String grantTypes;
	
	@NonNull
	@Column(name="access_token_validity")
	private Integer accessTokenValidity;	
}
