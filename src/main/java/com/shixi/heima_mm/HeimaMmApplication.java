package com.shixi.heima_mm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.shixi.heima_mm.mapper")
public class HeimaMmApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeimaMmApplication.class, args);

    }

}
