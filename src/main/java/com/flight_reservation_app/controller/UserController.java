package com.flight_reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app.entity.User;
import com.flight_reservation_app.repository.UserRepository;
import com.flight_reservation_app.service.SecurityService;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private SecurityService securityServcie;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@RequestMapping("/showDirectLoginPage")
	public String showLoginPage() {
		return "Login/login";
	}

	@RequestMapping("/showReg")
	public String showReg() {

		return "Login/showReg";
	}

	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepo.save(user);
		return "Login/login";
	}

	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("email") String emailId, @RequestParam("password") String password,
			ModelMap modelmap) {
		try {
			boolean loginResponse = securityServcie.login(emailId, password);
			if (loginResponse) {
				return "Login/findFlights";
			} else {
				modelmap.addAttribute("error", "Enter valid username");
				return "Login/login";
			}
		} catch (Exception e) {
			modelmap.addAttribute("msg", "Inavlid UserName/password");
			return "Login/login";
		}

//		User user = userRepo.findByEmail(emailId);
//		if (user != null) {
//			if (user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
//				return "Login/findFlights";
//			} else {
//				modelmap.addAttribute("error", "invalid Username/password");
//				return "Login/login";
//			}
//		} else {
//			modelmap.addAttribute("error", "Enter valid username");
//			return "Login/login";
//		}
//	try {
//		if(user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
//			return "Login/findFlights";
//		}else {
//			modelmap.addAttribute("error","invalid Username/password");
//			return "Login/login";
//		}
//	}catch(Exception e){
//		modelmap.addAttribute("error","invalid Username/password");
//		return "Login/login";
//	}
		
	}

	@PostMapping("admin/showAddFlight")
	public String showAddFlight() {
		return "addFlight";
	}
}
