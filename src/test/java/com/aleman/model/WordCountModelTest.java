package com.aleman.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountModelTest {

    @Test
    private void WordCountModelCreateTest() {

        // Input values
        String URL = "example.com";
        String totalNumberWord = "100";
        String averageWordLength = "5.2";
        String mostFrequentWord = "hello";
        String listNumberWordEach = "10,20,30";

        // Create an instance of WordCountModel
        WordCountModel wordCountModel = new WordCountModel(URL, totalNumberWord, averageWordLength, mostFrequentWord, listNumberWordEach);

        // Check if the fields are correctly initialized
        assertEquals(URL, wordCountModel.getURL());
        assertEquals(totalNumberWord, wordCountModel.getTotalNumberWord());
        assertEquals(averageWordLength, wordCountModel.getAverageWordLength());
        assertEquals(mostFrequentWord, wordCountModel.getMostFrequentWord());
        assertEquals(listNumberWordEach, wordCountModel.getListNumberWordEach());

    }
}
