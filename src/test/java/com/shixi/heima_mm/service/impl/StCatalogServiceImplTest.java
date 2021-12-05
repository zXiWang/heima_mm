package com.shixi.heima_mm.service.impl;

import com.shixi.heima_mm.service.IStCatalogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StCatalogServiceImplTest {

    @Autowired
    private IStCatalogService iStCatalogService;
    @Test
    void findByCourseId() {
        iStCatalogService.findByCourseId("1").forEach(e-> System.out.println(e));
    }
}