package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/config/app.properties")
public class AppConfig {
	
	@Autowired
	Environment env;
	
	@Bean
	public String Password() {
		return env.getProperty("app.password");
	}
	
	@Bean
	public String Username() {
		return env.getProperty("app.username");
	}
	
	@Bean
	public String Question1() {
		return env.getProperty("app.question1");
	}
	
	@Bean
	public String Question2() {
		return env.getProperty("app.question2");
	}
	
	@Bean
	public String Flag() {
		return env.getProperty("app.flag");
	}
}
