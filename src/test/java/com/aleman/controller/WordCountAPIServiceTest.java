package com.aleman.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.is;

@WebMvcTest
public class WordCountAPIServiceTest {

    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testGetAlemanwordcount() throws Exception {
        String url = "example.com";

        mockMvc.perform(MockMvcRequestBuilders.get("/")
                        .param("url", url))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.URL", is(url) ))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalNumberWord", is("getTotalNumberWord")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageWordLength", is("getAverageWordLength")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mostFrequentWord", is("getMostFrequentWord")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.listNumberWordEach", is("getListNumberWordEach")));
    }
}
