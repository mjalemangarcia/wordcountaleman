package com.aleman.controller;

import com.aleman.model.WordCountModel;
import com.aleman.model.WordModel;
import com.aleman.service.ReadFileService;
import com.aleman.util.DsaUtils;
import com.aleman.util.MostFrequentWord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.concurrent.ConcurrentHashMap;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest
public class WordCountAPIServiceTest {

    @InjectMocks
    private WordCountAPIService wordCountAPIService;

    @MockBean
    WordCountModel wordCountModel;

    @MockBean
    MostFrequentWord mostFrequentWord;

    @MockBean
    ReadFileService readFileService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);  // Initialize the mocks before each test
    }
    @Test
    public void testGetAlemanwordcount() throws Exception {
        String url = "test.com";
        double averageWordLengthReturn = 5.2;
        ConcurrentHashMap<Integer,Integer> listNumberWordEach = DsaUtils.listNumberWordEach();
        ConcurrentHashMap<String, WordModel> wordModelConcurrentHashMap = DsaUtils.wordModelConcurrentHashMap();
        ConcurrentHashMap<Integer,Integer> mostFreqWord = DsaUtils.mostFreqWord();

        when(readFileService.getReadFile(url)).thenReturn(wordModelConcurrentHashMap);
        when(mostFrequentWord.printMostFrequentWord(listNumberWordEach)).thenReturn(mostFreqWord);
        when(wordCountModel.getWordcount()).thenReturn(wordModelConcurrentHashMap.size());
        when(wordCountModel.getAverageWordLength()).thenReturn(averageWordLengthReturn);
        when(wordCountModel.getMostFrequentWord()).thenReturn(mostFreqWord);
        when(wordCountModel.getListNumberWordEach()).thenReturn(listNumberWordEach);

        WordCountModel result = wordCountAPIService.getAlemanwordcount(url);

        // Then
        assertEquals(url, result.getURL().toString());
        assertEquals(8, result.getWordcount());
        assertEquals(5.2, result.getAverageWordLength());
        assertEquals(listNumberWordEach, result.getListNumberWordEach());

    }
}
