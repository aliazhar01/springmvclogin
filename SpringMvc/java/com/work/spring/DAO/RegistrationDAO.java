package com.work.spring.DAO;

import com.work.spring.Entity.RegistrationEntity;

public interface RegistrationDAO {
	
	public Integer save(RegistrationEntity entity);
	
	public RegistrationEntity getByEmailId(String emailId);
	
	public RegistrationEntity checkUserIsExistOrNot(String fullName);

}
