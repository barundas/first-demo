package com.cts.fsd.firstdemo.controllers.main;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	private final static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	@Value("${spring.application.name}")
	private String APP_NAME;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String welcome() {
		String msg = "Welcome to the new " + APP_NAME + " 2017.";
		logger.info(msg);
		return msg;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String home() {
		String msg = "Welcome to the new " + APP_NAME + " 2017 Home.";
		logger.info(msg);
		return msg;
	}
}
