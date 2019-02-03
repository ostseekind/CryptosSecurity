package demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CryptosApplController {
	
	 @GetMapping("/")
	    public String index() {
	       return "home";
	    }
	 
	 
	 @GetMapping("/hello")
	 public String hello() {
		 return "hello";
	 }
	 
	 @RequestMapping( value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	    public String login(HttpServletRequest req, RedirectAttributes attr) {
		 return "login";
		 //return "redirect:/secure
	 }
	 
	 @GetMapping("/resetPassword")
	 public String resetPassword() {
		 return "resetPassword";
	 }
	 




}
