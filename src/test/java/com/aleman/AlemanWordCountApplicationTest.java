package com.aleman;

import com.aleman.model.WordCountModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = AlemanWordCountApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AlemanWordCountApplicationTest {
    @LocalServerPort
    private int port;

    @MockBean
    WordCountModel wordCountModel;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        // Verify that the Spring Boot application context loads ok
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("http://localhost:" + port + "/", String.class);

        // Assert that the response entity is not null
        assertNotNull(responseEntity);
    }
}
