package com.gokuecommerce.facade;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.gokuecommerce.model.dto.LoginDTO;

public class SessionUserFacade extends FacadeBase {
	private static final String URL_LOGIN = "login";

	public ResponseEntity<String> login(LoginDTO login){
		String url = String.format(URL_LOGIN, urlSession);
		return restTemplate.exchange(url, HttpMethod.GET, null, String.class);
	}
	
}
