package demo;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CryptoAppHttpRequestTest {

	 	@LocalServerPort
	    private int port;

	    @Autowired
	    private TestRestTemplate restTemplate;

	    @Test
	    public void homeShouldReturnWelcomeMessage() throws Exception {
	        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
	                String.class)).contains("<h1>Welcome!</h1>");
	    }
	    
	    @Test
	    public void homeShouldReturnLinkToLogin() throws Exception {
	        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
	                String.class)).contains("Click <a href=\"/hello\">here</a> to login.");
	    }
	    
	    @Test
	    public void loginShouldShowForm() throws Exception {
	        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/login",
	                String.class)).contains(">Sign In<");
	    }
	    
	    @Test
	    public void loginShouldShowLinkToResetPwd() throws Exception {
	        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/login",
	                String.class)).contains("href=\"/resetPassword\">Forgot Password?</a>");
	    }
	    
	    @Test
	    public void resetPWDShouldShowForm() throws Exception {
	        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/resetPassword",
	                String.class)).contains("type=\"submit\">Reset Password");
	    }
}
