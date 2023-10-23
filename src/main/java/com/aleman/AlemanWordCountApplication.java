package com.aleman;

import com.aleman.model.WordCountModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class AlemanWordCountApplication {

	public static void main(String[] args) {

		SpringApplication.run(AlemanWordCountApplication.class, args);
	}

}
