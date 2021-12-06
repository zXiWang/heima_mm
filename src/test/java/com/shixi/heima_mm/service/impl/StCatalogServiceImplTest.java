package com.shixi.heima_mm.service.impl;

import com.shixi.heima_mm.pojo.StCatalog;
import com.shixi.heima_mm.service.IStCatalogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StCatalogServiceImplTest {

    @Autowired
    private IStCatalogService iStCatalogService;
    @Test
    void findByCourseId() {
        iStCatalogService.findByCourseId(1).forEach(e-> System.out.println(e));
    }

    @Test
    void update() {
        StCatalog stCatalog = new StCatalog();
        stCatalog.setId(15);
        stCatalog.setName("111111");
        stCatalog.setState("222");

        iStCatalogService.update(stCatalog);
    }

    @Test
    void save() {
        StCatalog stCatalog=new StCatalog();
        stCatalog.setName("11111");

        iStCatalogService.insert(stCatalog);
    }

    @Test
    void delById() {
        iStCatalogService.delById(15);
    }
}