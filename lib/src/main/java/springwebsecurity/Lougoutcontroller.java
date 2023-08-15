package springwebsecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Lougoutcontroller {
	
	@RequestMapping("/logout.html")
	public String logout() {
		return "logout";
	}

}
