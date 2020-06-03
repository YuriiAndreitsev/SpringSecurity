package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/myLoginPage")
	public String getLoginPage () {
		return "fancy-login";
	}
	
	@GetMapping("/restricted")
	public String showRestrictedPage () {
		return "accessRestrictedView";
	}
}
