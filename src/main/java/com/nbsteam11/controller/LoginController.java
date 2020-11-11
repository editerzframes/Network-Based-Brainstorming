package com.nbsteam11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nbsteam11.service.LoginService;

/*******
 * <p>
 * Title: LoginController Class.
 * </p>
 * 
 * <p>
 * Description: A controller class which handles the login credentials approval.
 * </p>
 *
 * @author Keshav Sharma and Puneet Garg
 * 
 * @version 1.00 2019-11-05
 * 
 */

@Controller
@SessionAttributes("name")
public class LoginController {

	@Autowired
	LoginService service;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {

		int isValidUser = service.validateUser(name, password);

		if (isValidUser == 3) {
			model.put("errorMessage", "Invalid Credentials");
			return "index";
		}

		model.put("name", name);
		model.put("password", password);

		if (isValidUser == 1) {
			return "client";
		} else {
			return "welcome";
		}
	}

}
