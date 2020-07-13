package com.example.demo.sdk.user.service;

import java.util.List;

import com.example.demo.dto.user.UserCreateDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.dto.user.UserUpdateDto;

public interface UserSdk {
	UserDto get(String id);
	UserDto add(UserCreateDto userCreateDto);
	UserDto update(String id, UserUpdateDto userUpdateDto);
	void delete(String id);
	List<UserDto> getAll();
}
