package spittr.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class HomeControllerTest {
    
    @Test
    public void testHomePage() throws Exception {
        
        HomeController controller = new HomeController();
        
        // 搭建MockMvc
        MockMvc mockMvc = standaloneSetup(controller).build();
        
        // 对“/”执行GET请求，预期得到“home”视图
        mockMvc.perform(get("/")).andExpect(view().name("home"));
        
    }
}
