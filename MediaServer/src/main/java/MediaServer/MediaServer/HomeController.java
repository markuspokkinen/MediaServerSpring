package MediaServer.MediaServer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

	@GetMapping("/Home")
	public String returnPage() {
		return "home";
	}
	
	@PostMapping("/Home")
	public RedirectView home() {
		
		//Sessioon profileID
		return new RedirectView("/Home");
	}
}
