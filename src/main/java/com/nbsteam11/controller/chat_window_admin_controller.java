package com.nbsteam11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/*******
 * <p>
 * Title: chat_window_admin_controller Class.
 * </p>
 * 
 * <p>
 * Description: A controller class which handles the chat window for
 * brainstorming session.
 * </p>
 *
 * @author Sukrut Patil, Vaibhav, Dolly
 * 
 * @version 1.00 2019-11-05
 * 
 */

@Controller
@SessionAttributes("name")
public class chat_window_admin_controller {

	@RequestMapping(value = "/chat_window_admin", method = RequestMethod.GET)
	public String showCreateBrainstormingPage(ModelMap model) {
		return "chat_window_admin";
	}
}
