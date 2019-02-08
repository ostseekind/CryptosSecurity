package demo;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.queryParam;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CryptoLoginTest {

	@Autowired
    private WebApplicationContext context;
	
 
    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
          .webAppContextSetup(context)
          .apply(springSecurity())
          .build();
    }
 
    @WithMockUser("spring")
    @Test
    public void login_shouldContainFlag() throws Exception {
        mvc.perform(get("/hello").contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(model().attributeExists("flag"));
        
        mvc.perform(get("/hello").contentType(MediaType.APPLICATION_JSON))
        .andExpect(model().attributeExists("flag"));
    }
    
      

}
