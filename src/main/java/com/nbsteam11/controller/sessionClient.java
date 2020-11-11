package com.nbsteam11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/*******
 * <p>
 * Title: sessionClient Class.
 * </p>
 * 
 * <p>
 * Description: A controller class which handles the session for chat during
 * session from Client.
 * </p>
 *
 * @author Sukrut Patil, Vaibhav, Dolly
 * 
 * @version 1.00 2019-11-05
 * 
 */

@Controller
@SessionAttributes("name")
public class sessionClient {

	@RequestMapping(value = "/sessionClient", method = RequestMethod.GET)
	public String showCreateBrainstormingPage(ModelMap model) {
		return "sessionClient";
	}

}
