package com.korit.crud.controller;

import com.korit.crud.dto.user.DeleteSignInUserRequestDto;
import com.korit.crud.dto.user.PatchSignInUserRequestDto;

public interface UserController {
	
	void getSignInUser();
	void patchSigbInUser(PatchSignInUserRequestDto patchRequestDto);
	void deleteSignInUser(DeleteSignInUserRequestDto deleteRequestDto);
	
}
