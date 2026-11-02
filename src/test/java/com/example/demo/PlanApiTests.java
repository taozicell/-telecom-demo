package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc

public class PlanApiTests {

    @Autowired
    private MockMvc mockMvc;



    @Test
    void shouldReturn400whenpageISzero() throws Exception{
        mockMvc.perform(
                get("/api/plans")
                        .param("page","0")
                        .param("pageSize","2")
        ).andExpect(status().isBadRequest());
    }


    @Test
    void shouldReturn400whenpageIsNegative() throws Exception {
        mockMvc.perform(
                get("/api/plans")
                    .param("page", "-1")
                    .param("pageSize","2")
           ).andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400whenpageSizeIsZero() throws Exception {
        mockMvc.perform(
                get("/api/plans")
                        .param("page","1").param("pageSize","0")

        ).andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400whenpageSizeIsNegative() throws Exception {
        mockMvc.perform(
                get("/api/plans")
                .param("page", "1").param("pageSize","-1")

        ).andExpect(status().isBadRequest());
    }
}

