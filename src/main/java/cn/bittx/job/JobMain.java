package cn.bittx.job;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class JobMain {

    public static void main(String[] args) {
        SpringApplication.run(JobMain.class, args);
    }

}
