package com.work.spring.Controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.work.spring.DTO.RegistrationDto;
import com.work.spring.Entity.RegistrationEntity;
import com.work.spring.Service.RegistrationService;

@Controller
@RequestMapping("/log")
public class LoginContoller {
	@Autowired
	RegistrationService registrationService;

	private static Logger logger;

	public LoginContoller() {
		// TODO Auto-generated constructor stub
		logger = Logger.getLogger(getClass());

	}

	@PostMapping("/login.do")
	public ModelAndView loginForm(RegistrationDto entity) {
		System.out.println("FE data " + entity.getFullName() + " " + entity.getPassword());

		String data = registrationService.checkUserIsExistOrNot(entity.getFullName(), entity.getPassword());
		System.out.println("data " + data);
		ModelAndView modelAndView = new ModelAndView("welcome");
		ModelAndView modelAndView1 = new ModelAndView("Error");

		if (data == "success") {
			// return welcome jsp
			modelAndView.addObject("print", "LOGINED SUCCESSFULLY  " + entity.getFullName());
			return modelAndView;
		} else {
			// return msg inside modelview
			modelAndView1.addObject("print1", data);
			return modelAndView1;
		}
	}

}
