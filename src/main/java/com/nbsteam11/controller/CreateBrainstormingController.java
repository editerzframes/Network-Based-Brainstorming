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
 * Title: CreateBrainstormingController Class.
 * </p>
 * 
 * <p>
 * Description: A controller class which handles the creation of the topic for
 * brainstorming.
 * </p>
 *
 * @author Keshav Sharma and Puneet Garg
 * 
 * @version 1.00 2019-11-05
 * 
 */

@Controller
@SessionAttributes("name")
public class CreateBrainstormingController {

	@Autowired
	CreatedTopics createNew;

	@RequestMapping(value = "/createBrainstorming", method = RequestMethod.GET)
	public String showCreateBrainstormingPage(ModelMap model) {
		return "createBrainstorming";
	}

	@RequestMapping(value = "/createBrainstorming", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String client, @RequestParam String topic,
			@RequestParam String description) {

		try {
			createNew.createTopic(client, topic, description);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.put("topic", topic);
		model.put("description", description);
		model.put("client", client);

		return "client";

	}

}
