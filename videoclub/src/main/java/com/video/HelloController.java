package com.video;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class HelloController {
 
	private static Logger log = Logger.getLogger(HelloController.class); 
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("message", "Spring Security Hello World");
		log.info("Llamando a welcome");
		return "hello";
	}
	
	@RequestMapping(value="/login")
	public String login(ModelMap model) {
		log.info("Accediendo a login");
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String logout(ModelMap model) {
		log.info("Logout del usuario");
		return "login";
	}
	
	@RequestMapping(value="/loginFailed", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		log.info("Login failed del usuario");
		return "login";
 
	}
	
 
}