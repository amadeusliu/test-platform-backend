package cn.edu.tju;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@MapperScan("cn.edu.tju.mapper")
@EnableScheduling
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }
}
