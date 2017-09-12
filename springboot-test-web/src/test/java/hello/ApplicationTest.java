package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Janloong
 * @create 2017-09-11 16:50
 **/
@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest
@AutoConfigureMockMvc//等同于 RunWith  +  SpringBootTest
public class ApplicationTest {
    //
    //@LocalServerPort
    //private int port;
    //@Autowired
    //private HomeController homeController;
    //@Autowired
    //private GreetingController greetingController;

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GreetingService greetingService;

    //@Autowired
    //private TestRestTemplate template;
    @Test
    public void contextLoads() throws Exception {
        //System.out.println("janLoong , test");
        //assertThat(homeController).isNotNull();
        //String greeting = homeController.greeting();
        //System.out.println(greeting);
        //System.out.println("-------------");
        //System.out.println(port);
        //System.out.println("-------------");
        //assertThat(this.template.getForObject("http://localhost:" + port + "/",
        //        String.class)).contains("Hello World");
        //this.mockMvc.perform(get("/greeting",1,2)).andDo(print()).andExpect(status().isOk())
        //        .andExpect(content().string(containsString("Hello World")));

        when(greetingService.greet()).thenReturn("Hello Mock");

        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Mock")));
    }
}
