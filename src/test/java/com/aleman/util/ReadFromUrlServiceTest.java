package com.aleman.util;

import com.aleman.model.WordCountModel;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadFromUrlServiceTest {

    @Mock
    private WordCountModel wordCountModel;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    /**
     * We need to capture the Print console for the Util classes as they don't return any type (void) and just only print in console
     */
    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
        ReadFromUrlService readFromUrlService = new ReadFromUrlService(wordCountModel);
    }

    private void getReadFromUrlTest() {
        String testUrl = "http://test.com";
        String testContent = "hello";

        int wordcount = 100;
        double averageWordLength = 5.2;


        String expectedOutput = "===PRINT" +
                System.lineSeparator() +
                "Count word =100" +
                System.lineSeparator() +
                "Number of words of length 3 is 2" +
                System.lineSeparator();

        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

}
