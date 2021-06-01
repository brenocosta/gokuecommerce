package com.gokuecommerce.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class FacadeBase {
	
	@Value("$endpoint.sessio.user")
	protected String urlSession;
	
	@Autowired
	protected RestTemplate restTemplate;

}
