package ua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping ("/")
	public String getHomePage () {
		return "home";
	}
	
	@GetMapping ("/leaders")
	public String showLeadersPage() {
		return "leadersView";
	}
	
	@GetMapping ("/admins")
	public String showAdminsPage() {
		return "adminsView";
	}
}
