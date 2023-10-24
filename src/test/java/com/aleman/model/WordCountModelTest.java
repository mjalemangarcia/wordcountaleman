package com.aleman.model;

import com.aleman.util.DsaUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountModelTest {

    @MockBean
    WordCountModel wordCountModel;
    @Test
    public void WordCountModelCreateTest() {

        // Input values
        String URL = "example.com";
        int wordcount = 100;
        double averageWordLength = 5.2;
        
        ConcurrentHashMap<Integer,Integer> listNumberWordEach = DsaUtils.listNumberWordEach();
        ConcurrentHashMap<Integer,Integer> mostFrequentWord = DsaUtils.mostFreqWord();
        // Create an instance of WordCountModel
        WordCountModel wordCountModel = new WordCountModel(URL, wordcount, averageWordLength, mostFrequentWord, listNumberWordEach);
        // Check if the fields are correctly initialized
        assertEquals(URL, wordCountModel.getURL());
        assertEquals(wordcount, wordCountModel.getWordcount());
        assertEquals(averageWordLength, wordCountModel.getAverageWordLength());
        assertEquals(mostFrequentWord, wordCountModel.getMostFrequentWord());
        assertEquals(listNumberWordEach, wordCountModel.getListNumberWordEach());

    }
}
