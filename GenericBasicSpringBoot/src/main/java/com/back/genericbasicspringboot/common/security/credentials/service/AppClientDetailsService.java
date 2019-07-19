package com.back.genericbasicspringboot.common.security.credentials.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import com.back.genericbasicspringboot.common.security.credentials.model.AppClient;
import com.back.genericbasicspringboot.common.security.credentials.repository.AppClientDetailsRepository;

@Service
public class AppClientDetailsService implements ClientDetailsService {

	@Autowired
	private AppClientDetailsRepository repository;
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		Optional<AppClient> appClientOptional = repository.findByClientId(clientId);
		AppClient appClient = appClientOptional.get();
		
		BaseClientDetails clientDetails = new BaseClientDetails();
		clientDetails.setClientId(appClient.getClientId());
		clientDetails.setClientSecret(appClient.getSecret());
		clientDetails.setScope(Arrays.asList(appClient.getScope().split(",")));
		clientDetails.setAuthorizedGrantTypes(Arrays.asList(appClient.getGrantTypes().split(",")));
		clientDetails.setAccessTokenValiditySeconds(appClient.getAccessTokenValidity());
		
		return clientDetails;
	}

}
