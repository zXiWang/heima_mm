package com.shixi.heima_mm.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StCatalogDaoTest {
    @Autowired
    StCatalogDao stCatalogDao;

    @Test
    public void zhubuz(){
        stCatalogDao.findAll().forEach(System.out::println);
    }

}