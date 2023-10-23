package com.aleman;

import com.aleman.model.WordCountModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
@ComponentScan("com.aleman")
public class WordCountConfig {

    protected Logger logger;

    public WordCountConfig() {
        logger = Logger.getLogger(getClass().getName());
    }

    @Bean
    public WordCountModel wordCountModel() {
       return new WordCountModel("",0,0.0,"","","");
    }
}
