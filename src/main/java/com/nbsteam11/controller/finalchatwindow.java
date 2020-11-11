package com.nbsteam11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nbsteam11.service.CreatedTopics;

/*******
 * <p>
 * Title: finalchatwindow Class.
 * </p>
 * 
 * <p>
 * Description: A controller class which handles the chat window requests.
 * </p>
 *
 * @author Sukrut Patil, Vaibhav, Dolly
 * 
 * @version 1.00 2019-11-05
 * 
 */

@Controller
@SessionAttributes("name")
public class finalchatwindow {

	@Autowired
	CreatedTopics createNew;

	@RequestMapping(value = "/finalchatwindow", method = RequestMethod.GET)
	public String showCreateBrainstormingPage(ModelMap model) {
		return "finalchatwindow";
	}

}
