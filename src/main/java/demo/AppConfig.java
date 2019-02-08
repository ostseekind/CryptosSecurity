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
	public String getPassword() {
		return env.getProperty("app.password");
	}
	
	@Bean
	public String getUsername() {
		return env.getProperty("app.username");
	}
	
	@Bean
	public String getQuestion1() {
		return env.getProperty("app.question1");
	}
	
	@Bean
	public String getQuestion2() {
		return env.getProperty("app.question2");
	}
	
	@Bean
	public String getFlag() {
		return env.getProperty("app.flag");
	}
}
