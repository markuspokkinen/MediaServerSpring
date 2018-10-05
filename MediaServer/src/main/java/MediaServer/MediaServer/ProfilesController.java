package MediaServer.MediaServer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ProfilesController {

	
	@GetMapping("/Profiles")
	public String profiles() {
		return "profiles";
	}
	@PostMapping("/Profiles")
	public RedirectView prof() {
		return new RedirectView("/Profiles");
	}
	
}
