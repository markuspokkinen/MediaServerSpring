package MediaServer.MediaServer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import hibernate.HibernateConn;

@Controller()
public class ProfilesController {

	
	@GetMapping("/Profiles")
	public String profiles() {
		
		return "profiles";
	}
	@GetMapping("Profiles/all")
	public Object getAllProfiles() {
		HibernateConn hc = new HibernateConn();
		hc.getProfiles(0);
		return null;
	}
	@PostMapping("/Profiles")
	public RedirectView prof() {
		
		return new RedirectView("/Profiles");
	}
	
}
