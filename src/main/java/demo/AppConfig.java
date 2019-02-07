package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:/demo/app.properties")
public class AppConfig {
	
	@Autowired
	Environment env;
	
	@Bean
	public String Answer() {
		return env.getProperty("answer");
	}
	
}
