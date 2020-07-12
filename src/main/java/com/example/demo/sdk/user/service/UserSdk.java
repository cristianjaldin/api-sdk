package com.example.demo.sdk.user.service;

import java.util.List;

import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserDto;

public interface UserSdk {
	List<UserDto> findAll();
	UserDto get(String id);
	UserDto add(UserCreateDto userCreateDto);
	void delete(String id);
}
