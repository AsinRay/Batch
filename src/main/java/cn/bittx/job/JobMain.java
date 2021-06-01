package cn.bittx.job;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@SpringBootApplication
@EnableBatchProcessing
public class JobMain {

    public static void main(String[] args) throws FileNotFoundException {
        String p0 = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        String p1 = ResourceUtils.getURL("classpath:").getPath();
        System.out.println("RRRRRRRRRRRRRRRRRRRRRRR");
        System.out.println(p0);
        System.out.println(p1);
        SpringApplication.run(JobMain.class, args);
    }

}
