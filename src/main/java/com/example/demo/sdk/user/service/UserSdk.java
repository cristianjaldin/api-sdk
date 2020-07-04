package com.example.demo.sdk.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserSdk {
	
	//@Autowired
	//private ModelMapper modelMapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
}
