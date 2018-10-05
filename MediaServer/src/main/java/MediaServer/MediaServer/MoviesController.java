package MediaServer.MediaServer;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import exrternalAPI.API;

@Controller
public class MoviesController {

	@GetMapping("/Home/Movies")
	@ResponseBody
	public String getAllMovies(@RequestParam(value="movID",defaultValue="0" )String ID) {
		return "Data from DataBase";
	}
	
	@GetMapping("Home/Movies/query/{param}")
	@ResponseBody
	public Object APISearch(@PathVariable(value="param")String param) {
		System.out.println("par: "+param);
		String res = "";
		return res;
	}
	
}
