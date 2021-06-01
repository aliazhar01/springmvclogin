package com.work.spring.UserException;

public class UserCustomException extends RuntimeException {

	@Override
	public String getMessage() {
		return "User Already Exsisted !---";
	}

	public String dataNotExist() {
		return "Data not found";

	}
	
	public String errorFound() {
		return "User Name and password is wrong";
		
	}

}
