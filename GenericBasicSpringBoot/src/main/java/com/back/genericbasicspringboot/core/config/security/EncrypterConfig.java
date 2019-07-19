package com.back.genericbasicspringboot.core.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class EncrypterConfig {

	@Bean
	public BCryptPasswordEncoder bcrypt() {
		return new BCryptPasswordEncoder();
	}
	
	public static void main (String[] args) {
		System.out.println(new EncrypterConfig().bcrypt().encode("1234"));
	}
}
