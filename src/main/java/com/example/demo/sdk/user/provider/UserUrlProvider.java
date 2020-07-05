package com.example.demo.sdk.user.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class UserUrlProvider {
	
	@Value("${sdk.user.service.scheme.url}")
	private String schemeUrl;

	@Value("${sdk.user.service.base.url}")
	private String baseUrl;

	@Value("${sdk.user.service.path}")
	private String path;
		
	public String getUserUrl() {
		return UriComponentsBuilder.newInstance().scheme(schemeUrl).host(baseUrl).path(path).build().toUriString();
	}
	
}
