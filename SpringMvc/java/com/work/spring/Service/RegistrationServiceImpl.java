package com.work.spring.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.work.spring.DAO.RegistrationDAO;
import com.work.spring.DTO.RegistrationDto;
import com.work.spring.Entity.RegistrationEntity;
import com.work.spring.UserException.UserCustomException;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private Logger logger;
	@Autowired
	private RegistrationDAO dao;

	public RegistrationServiceImpl() {

		// TODO Auto-generated constructor stub
		logger = Logger.getLogger(getClass());
	}

	public String validateAndSave(RegistrationDto dto) {
		logger.info("inside {} ");
		RegistrationEntity entity = new RegistrationEntity();
		try {

			RegistrationEntity edEntity = dao.getByEmailId(dto.getEmailId());
			logger.info("user dta from DB " + edEntity);
			if (edEntity == null) {

				BeanUtils.copyProperties(dto, entity);

				entity.setRegisteredBy("ali");

				LocalDateTime ldate = LocalDateTime.now();

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");

				String date = formatter.format(ldate);

				entity.setRegisteredDate(date);

				int affectedRows = dao.save(entity);
				logger.info("affectedRows " + affectedRows);

				if (affectedRows > 0) {
					logger.info("user successfully registered");
					return "User Successfully Registered";
				} else {
					logger.info("9090909ajskajsljaklsjlajsklajskajklsjaklsjklasjklajslkajskal");
					logger.info("user not registered");
					return "user not registered";
				}

			} else {
				logger.info("user already exist");
				return new UserCustomException().getMessage();

				// return "user already exist";
			}
		} catch (Exception e) {
			logger.error("you have an Exception in {} " + e.getMessage(), e);
		}
		return "";
	}

	@Override
	public String checkUserIsExistOrNot(String fullName, String password) {
		System.out.println("inside {} ");
		RegistrationEntity entity = new RegistrationEntity();

		try {
			RegistrationEntity edEntity = dao.checkUserIsExistOrNot(fullName);
			System.out.println("user dta from DB " + edEntity);
			if (edEntity != null) {
				System.out.print("data exist");

				String fullNameFromDB = edEntity.getFullName();
				String passwordFromDB = edEntity.getPassword();

				//if (fullName == fullNameFromDB && password == passwordFromDB) {
					if (fullName.equalsIgnoreCase(fullNameFromDB)
							&& password.equalsIgnoreCase(passwordFromDB)) {
					System.out.println("Login successull..");
					
					return "success";
				} else {
					System.out.println("Boss, Entered userName and password is wrong ");
					
					// return error msg
					return new UserCustomException().errorFound();
				}
			} else {
				System.out.println("data not exist");
				return new UserCustomException().dataNotExist();
				// return exception as data not exist 
			}
		} catch (Exception e) {
			//System.out.print("Exception caused while getting user details ", e);
		}
		return "";
	}

}
