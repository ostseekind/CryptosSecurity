package demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CryptosApplController {
	 private AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	
	 @GetMapping("/")
	    public String index() {
	       return "home";
	    }
	 
	 
	 @RequestMapping( value = "/hello", method = {RequestMethod.GET, RequestMethod.POST})
	 	public String hello(HttpServletRequest req, RedirectAttributes attr, Model model) {
		 model.addAttribute("flag", (String) ctx.getBean("Flag"));
		 return "hello";
	 }
	 
	 @RequestMapping( value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	    public String login(HttpServletRequest req, RedirectAttributes attr) {
		 return "login";
		 //return "redirect:/secure
	 }
	 
	
	 @RequestMapping( value = "/resetPassword", method = {RequestMethod.GET, RequestMethod.POST})
	 	public String resetPassword(HttpServletRequest req, RedirectAttributes attr, Model model) {
		 String animal = req.getParameter("animal");
		 String IBAN = req.getParameter("IBAN");
		 String user = req.getParameter("username");
		 	 
		 if(user!=null && animal !=null && IBAN !=null) {
			 if(user.equals((String) ctx.getBean("Username")) && animal.equals((String) ctx.getBean("Question2")) && IBAN.replaceAll("\\s+","").equals((String) ctx.getBean("Question1"))) {
				
				 model.addAttribute("password", (String) ctx.getBean("Password"));
				 
			}
		 }
		 
		 return "resetPassword";
	 }
	 




}
