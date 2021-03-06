package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import spittr.data.SpitterRepository;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class SpitterControllerTest {

    @Test
    public void shouldShowRegistration() throws Exception {

        SpitterRepository mockRepository = mock(SpitterRepository.class);

        SpitterController controller = new SpitterController(mockRepository);

        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
    }

}
