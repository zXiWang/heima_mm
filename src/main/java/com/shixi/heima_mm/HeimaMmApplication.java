package com.shixi.heima_mm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HeimaMmApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeimaMmApplication.class, args);

    }

}
