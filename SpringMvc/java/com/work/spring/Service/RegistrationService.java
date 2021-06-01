package com.work.spring.Service;

import com.work.spring.DTO.RegistrationDto;
import com.work.spring.Entity.RegistrationEntity;

public interface RegistrationService {
	
	public String validateAndSave(RegistrationDto dto);
	
	public String checkUserIsExistOrNot(String fullName, String password);

}
