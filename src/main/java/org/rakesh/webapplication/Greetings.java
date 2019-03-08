package org.rakesh.webapplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@Controller
public class Greetings {
	
	@RequestMapping(value = "/greetings")
	public String form() {
		return "greetings";
	}

}
