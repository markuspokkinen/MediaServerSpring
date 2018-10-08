package MediaServer.MediaServer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import hibernate.HibernateConn;

@Controller
public class LoginController {

	@GetMapping("/Login")
	public String login() {
		return "login";
	}

	@PostMapping("/Login")
	public RedirectView logingin(@RequestParam(value = "User[Email]") String email,
			@RequestParam(value = "User[Password]") String password) {

		System.out.println(email);
		System.out.println(password);

		// loppu hibernatea
		HibernateConn hc = new HibernateConn();
		hc.findUser(email);

		return new RedirectView("/Profiles");
	}
}
