package com.aleman.service;
import com.aleman.model.WordModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.concurrent.ConcurrentHashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReadFromUrlServiceTest {

    @Mock
    private ReadFileService readFileService;

    @Test
    public void getReadFromUrlTest() {
        String testUrl = "http://example.com";

        ConcurrentHashMap<String, WordModel> mockResult = new ConcurrentHashMap<>();
        mockResult.put("Hello", new WordModel(5,1));
        mockResult.put("world", new WordModel(5,1));
        mockResult.put("&", new WordModel(1,1));
        mockResult.put("good", new WordModel(5,1));
        mockResult.put("morning", new WordModel(7,1));
        mockResult.put("The", new WordModel(3,1));
        mockResult.put("is", new WordModel(2,1));
        mockResult.put("18/05/2016", new WordModel(10,1));

        when(readFileService.getReadFile(testUrl)).thenReturn(mockResult);

        ConcurrentHashMap<String, WordModel> result = readFileService.getReadFile(testUrl);

        assertNotNull(result);
        assertEquals(5, result.get("Hello").getLength());
        assertEquals(1, result.get("Hello").getCount());
        assertEquals(1, result.get("&").getLength());
        assertEquals(1, result.get("&").getCount());
        assertEquals(5, result.get("world").getLength());
        assertEquals(1, result.get("world").getCount());
        assertEquals(7, result.get("morning").getLength());
        assertEquals(1, result.get("morning").getCount());
        assertEquals(3, result.get("The").getLength());
        assertEquals(1, result.get("The").getCount());
        assertEquals(2, result.get("is").getLength());
        assertEquals(1, result.get("is").getCount());
        assertEquals(10, result.get("18/05/2016").getLength());
        assertEquals(1, result.get("18/05/2016").getCount());

    }


}
