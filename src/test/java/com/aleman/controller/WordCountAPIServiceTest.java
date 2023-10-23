package com.aleman.controller;

import com.aleman.model.WordCountModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@WebMvcTest
public class WordCountAPIServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    WordCountModel wordCountModel;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);  // Initialize the mocks before each test
    }
    @Test
    public void testGetAlemanwordcount() throws Exception {
        String url = "example.com";
        int wordcountReturn =100;
        double averageWordLengthReturn = 5.2;
        when(wordCountModel.getWordcount()).thenReturn(wordcountReturn);
        when(wordCountModel.getAverageWordLength()).thenReturn(averageWordLengthReturn);

        mockMvc.perform(MockMvcRequestBuilders.get("/")
                        .param("url", url))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.URL", is(url) ))
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalNumberWord", is(wordcountReturn)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageWordLength", is(averageWordLengthReturn)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.mostFrequentWord", is("getMostFrequentWord")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.listNumberWordEach", is("getListNumberWordEach")));
    }
}
