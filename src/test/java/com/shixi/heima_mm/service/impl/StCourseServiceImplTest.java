package com.shixi.heima_mm.service.impl;

import com.shixi.heima_mm.repository.StCourseDao;
import com.shixi.heima_mm.service.IStCourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StCourseServiceImplTest {

    @Autowired
    private IStCourseService stCourseService;

    @Test
    void loadAll() {
        stCourseService.loadAll().forEach(e -> System.out.println(e));
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void delById() {
        stCourseService.delById(7);
    }


}