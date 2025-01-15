package com.korit.crud.service;

import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;

public interface UserService {

	void getSignInUser(String id);
	void patchSignInUser(PatchSignInUserRequestDto patchRequestDto, String id);
	void deleteSignInUser(DeleteSignInUserRequestDto deleteRequestsDto, String id);
}
