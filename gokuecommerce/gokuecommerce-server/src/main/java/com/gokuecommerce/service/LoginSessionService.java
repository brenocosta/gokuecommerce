package com.gokuecommerce.service;

import static com.gokuecommerce.security.JWTUtil.createJwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gokuecommerce.model.User;
import com.gokuecommerce.security.HashUtil;

import lombok.SneakyThrows;

@Service
public class LoginSessionService {

	@Autowired
	private UserService userService;

	@SneakyThrows
	public String loginUser(String username, String password) {
		String encryptedPassword = HashUtil.encryptPassword(password);
		User user = userService.checkUserLogin(username, encryptedPassword);
		return createJwt(user.getUsername());
	}
}
