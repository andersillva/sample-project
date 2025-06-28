package br.com.andersillva.sample_project;

import br.com.andersillva.sample_project.controller.MyController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MyController.class)
class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deve retornar 'Hello, world!' com status 200 para GET /api/v1/sample/hello")
    void testHello() throws Exception {
        mockMvc.perform(get("/api/v1/sample/hello"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("Hello, world!"));
    }

    @Test
    @DisplayName("Deve retornar status 200 e corpo vazio para GET /api/v1/sample/health-check")
    void testHealthCheck() throws Exception {
        mockMvc.perform(get("/api/v1/sample/health-check"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

}
