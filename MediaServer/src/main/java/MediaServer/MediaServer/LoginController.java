package MediaServer.MediaServer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@PostMapping("/login")
	public String logingin(@RequestParam(value="User[Email]")String email,@RequestParam(value="User[Password]")String password) {
		
		System.out.println(email);
		System.out.println(password);
		// loppu hibernatea
		
		return "Profiles";
	}
}
