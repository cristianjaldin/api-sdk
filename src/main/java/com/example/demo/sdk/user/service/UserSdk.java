package com.example.demo.sdk.user.service;

import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.user.UserGetDto;

@Service
public class UserSdk {

	// @Autowired
	// private ModelMapper modelMapper;
    //
    //	@Autowired
    //	private RestTemplate restTemplate;

	public List<UserGetDto> findAll() {
		System.out.println("find alllll");
		// Url
		final String baseUrl = "http://dummy.restapiexample.com/api/v1/employees";
		// headers
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		// Request con headers
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		// restTemplate
		RestTemplate restTemplate = new RestTemplate();
		// execute GET
		ResponseEntity<String> result = restTemplate.exchange(baseUrl, HttpMethod.GET, requestEntity, String.class);
		System.out.println("result.getStatusCodeValue(): " + result.getStatusCodeValue());
		System.out.println("result.getBody(): " + result.getBody());
		return null;
	}

}
