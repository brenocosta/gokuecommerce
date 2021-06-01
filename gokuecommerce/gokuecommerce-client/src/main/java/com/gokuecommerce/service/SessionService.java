package com.gokuecommerce.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gokuecommerce.exception.LoginRequestException;
import com.gokuecommerce.facade.SessionUserFacade;
import com.gokuecommerce.model.dto.LoginDTO;

@Service
public class SessionService {
	
	@Autowired
	private SessionUserFacade sessionUserFacade;
	
	public String loginUsuario(LoginDTO login) {
		try {
			return sessionUserFacade.login(login).getBody();
		} catch (Exception e) {
			throw new LoginRequestException(e.getMessage());
		}
	}
	
}

