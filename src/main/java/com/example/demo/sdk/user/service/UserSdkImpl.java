package com.example.demo.sdk.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.response.Response;
import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserUpdateDto;
import com.example.demo.sdk.user.provider.UserUrlProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserSdkImpl implements UserSdk {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UserUrlProvider userUrlProvider;

	public List<UserDto> findAll() {
		List<UserDto> users = null;
		System.out.println("find alllll");
		// Url
		final String userUrl = userUrlProvider.getUserUrl();
		System.out.println(userUrl);
		// headers
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		// Request con headers
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		// execute GET
		ResponseEntity<String> result = restTemplate.exchange(userUrl, HttpMethod.GET, requestEntity, String.class);

		System.out.println("result.getStatusCodeValue(): " + result.getStatusCodeValue());
		System.out.println("result.getBody(): " + result.getBody());

		if (result.getStatusCodeValue() != 200) {
			throw new HttpClientErrorException(result.getStatusCode());
		}

		try {
			Response response = objectMapper.readValue(result.getBody(), new TypeReference<Response>() {
			});
			// response.setPayload(objectMapper.convertValue(response.getPayload(), new
			// TypeReference<List<UserGetDto>>() {}));
			users = objectMapper.convertValue(response.getPayload(), new TypeReference<List<UserDto>>() {
			});
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}

	public UserDto get(String id) {
		UserDto user = null;
		// Url
		final String userUrl = userUrlProvider.getUserUrl().concat("/").concat(id);
		System.out.println(userUrl);
		// headers
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		// Request con headers
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		// execute GET
		ResponseEntity<String> result = restTemplate.exchange(userUrl, HttpMethod.GET, requestEntity, String.class);

		System.out.println("result.getStatusCodeValue(): " + result.getStatusCodeValue());
		System.out.println("result.getBody(): " + result.getBody());

		if (result.getStatusCodeValue() != 200) {
			throw new HttpClientErrorException(result.getStatusCode());
		}

		try {
			Response response = objectMapper.readValue(result.getBody(), new TypeReference<Response>() {
			});
		
			user = objectMapper.convertValue(response.getPayload(), new TypeReference<UserDto>() {
			});
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}
	
	public UserDto add(UserCreateDto userCreateDto) {
		UserDto userCreated = null;
		// Url
		final String userUrl = userUrlProvider.getUserUrl();
		System.out.println(userUrl);

		// headers
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		// body
		String body = null;
		try {
			body = objectMapper.writeValueAsString(userCreateDto);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Request con body + headers
		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

		// execute POST
		ResponseEntity<String> result = restTemplate.exchange(userUrl, HttpMethod.POST, requestEntity, String.class);

		System.out.println("result.getStatusCodeValue(): " + result.getStatusCodeValue());
		System.out.println("result.getBody(): " + result.getBody());

		if (result.getStatusCodeValue() != 201) {
			throw new HttpClientErrorException(result.getStatusCode());
		}

		try {
			Response response = objectMapper.readValue(result.getBody(), new TypeReference<Response>() {
			});
			// response.setPayload(objectMapper.convertValue(response.getPayload(), new TypeReference<UserDto>() {}));
			userCreated = objectMapper.convertValue(response.getPayload(), new TypeReference<UserDto>() {
			});
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userCreated;
	}

	public void delete(String id) {
		// Url
		final String userUrl = userUrlProvider.getUserUrl().concat("/").concat(id);
		System.out.println(userUrl);
		// headers
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
		// Request con headers
		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		// execute DELETE
		ResponseEntity<String> result = restTemplate.exchange(userUrl, HttpMethod.DELETE, requestEntity, String.class);
		System.out.println("result.getStatusCodeValue(): " + result.getStatusCodeValue());
		System.out.println("result.getBody(): " + result.getBody());
		if (result.getStatusCodeValue() != 204) {
			throw new HttpClientErrorException(result.getStatusCode());
		}
	}

	@Override
	public UserDto update(String id, UserUpdateDto userUpdateDto) {
		UserDto userUpdated = null;
		// Url
		final String userUrl = userUrlProvider.getUserUrl().concat("/").concat(id);
		System.out.println(userUrl);
		// headers
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, "application/json");

		// body
		String body = null;
		try {
			body = objectMapper.writeValueAsString(userUpdateDto);
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Request con body + headers
		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);

		// execute PUT
		ResponseEntity<String> result = restTemplate.exchange(userUrl, HttpMethod.PUT, requestEntity, String.class);

		System.out.println("result.getStatusCodeValue(): " + result.getStatusCodeValue());
		System.out.println("result.getBody(): " + result.getBody());

		if (result.getStatusCodeValue() != 200) {
			throw new HttpClientErrorException(result.getStatusCode());
		}

		try {
			Response response = objectMapper.readValue(result.getBody(), new TypeReference<Response>() {
			});
			// response.setPayload(objectMapper.convertValue(response.getPayload(), new TypeReference<UserDto>() {}));
			userUpdated = objectMapper.convertValue(response.getPayload(), new TypeReference<UserDto>() {
			});
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userUpdated;
	}
}
