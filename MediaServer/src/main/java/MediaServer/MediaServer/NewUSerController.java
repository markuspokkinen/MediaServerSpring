package MediaServer.MediaServer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class NewUSerController {
	
	@GetMapping("/NewUser")
	public String returnpage() {
		return "newuser";
	}
	@PostMapping
	public RedirectView addnewUser() {
		return new RedirectView("/Login");
	}
}
