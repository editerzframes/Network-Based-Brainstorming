package com.nbsteam11.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nbsteam11.service.CreatedTopics;

/*******
 * <p>
 * Title: updateBrainstormingController Class.
 * </p>
 * 
 * <p>
 * Description: A controller class which handles the request for updation of
 * topic from client page.
 * </p>
 *
 * @author Keshav Sharma and Puneet Garg
 * 
 * @version 1.00 2019-11-05
 * 
 */

@Controller
@SessionAttributes("name")
public class updateBrainstormingController {

	@Autowired
	CreatedTopics updateNew;

	@RequestMapping(value = "/updateBrainstorming", method = RequestMethod.GET)
	public String showCreateBrainstormingPage(ModelMap model) {
		return "updateBrainstorming";
	}

	@RequestMapping(value = "/updateBrainstorming", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String var, @RequestParam String topic,
			@RequestParam String description) throws NumberFormatException, ClassNotFoundException, SQLException {

		updateNew.updateTopic(Integer.parseInt(var), topic, description);

		return "client";

	}

}
