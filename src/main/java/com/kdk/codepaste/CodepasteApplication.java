package com.kdk.codepaste;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kdk.codepaste.mapper")
public class CodepasteApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodepasteApplication.class, args);
    }

}
