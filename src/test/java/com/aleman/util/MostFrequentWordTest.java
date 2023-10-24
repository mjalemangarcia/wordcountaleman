package com.aleman.util;

import com.aleman.model.WordCountModel;
import com.aleman.service.ReadFromUrlImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MostFrequentWordTest {

    @Mock
    private WordCountModel wordCountModel;

    @MockBean
    private MostFrequentWord mostFrequentWord;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    /**
     * We need to capture the Print console for the Util classes as they don't return any type (void) and just only print in console
     */
    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outputStreamCaptor));
        ReadFromUrlImpl readFromUrlService = new ReadFromUrlImpl(wordCountModel);
    }

    @Test
    public void getMostFrequentWordTest() {
        MostFrequentWord mostFrequentWord1 = new MostFrequentWord();
        ConcurrentHashMap <Integer,Integer>  listNumberWordEach = new ConcurrentHashMap<>();
        listNumberWordEach.put(1,1);
        listNumberWordEach.put(2,2);
        listNumberWordEach.put(3,2);
        mostFrequentWord1.printMostFrequentWord(listNumberWordEach);

        String expectedOutput = "The most frequently occuring word length is  2" +
                System.lineSeparator() +
                ", for word lengths of  2" +
                System.lineSeparator() +
                ", for word lengths of  3" +
                System.lineSeparator() +
                "Number of words of length 1 is 1" +
                System.lineSeparator() +
                "Number of words of length 2 is 2" +
                System.lineSeparator() +
                "Number of words of length 3 is 2" +
                System.lineSeparator();;


        assertEquals(expectedOutput, outputStreamCaptor.toString());

    }
}
