package MediaServer.MediaServer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import hibernate.HibernateConn;

@Controller
public class NewUserController {
	
	@GetMapping("/NewUser")
	public String returnpage() {
		return "newuser";
	}
	
	@PostMapping("/NewUser")
	public RedirectView addnewUser(@RequestParam(value = "User[Email]") String email,
			@RequestParam(value = "User[Password]") String password) {
		
		HibernateConn hc = new HibernateConn();
		hc.createUser(email, password);
		
		return new RedirectView("/Login");
	}
}
