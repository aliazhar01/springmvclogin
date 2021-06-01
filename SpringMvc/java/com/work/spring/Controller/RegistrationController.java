package com.work.spring.Controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.work.spring.DTO.RegistrationDto;
import com.work.spring.Service.RegistrationServiceImpl;
import com.work.spring.UserException.UserCustomException;

@Controller
@RequestMapping("/")
public class RegistrationController {

	private static Logger logger;

	@Autowired
	private RegistrationServiceImpl registrationService;

	public RegistrationController() {
		logger = Logger.getLogger(getClass());

	}

	// @RequestMapping("/registration.do")
	@PostMapping("/registration.do")
	public ModelAndView register(RegistrationDto registrationDTO) {
		logger.info("invoking register()");
		ModelAndView modelAndView = new ModelAndView("index");
		try {
			String msg = registrationService.validateAndSave(registrationDTO);
			modelAndView.addObject("msg", msg + " " + registrationDTO.getFullName());
		} catch (Exception e) {		  
			throw new RuntimeException();
		}
		return modelAndView;
	}
}