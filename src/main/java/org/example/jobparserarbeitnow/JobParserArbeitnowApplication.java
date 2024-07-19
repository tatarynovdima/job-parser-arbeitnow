package org.example.jobparserarbeitnow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JobParserArbeitnowApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobParserArbeitnowApplication.class, args);
    }

}
