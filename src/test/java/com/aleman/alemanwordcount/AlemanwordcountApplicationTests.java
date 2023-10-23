package com.aleman.alemanwordcount;

import com.aleman.model.WordCountModel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class AlemanwordcountApplicationTests {

	@MockBean
	WordCountModel wordCountModel;
	@Test
	void contextLoads() {
	}

}
