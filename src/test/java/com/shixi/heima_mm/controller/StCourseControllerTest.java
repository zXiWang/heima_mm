package com.shixi.heima_mm.controller;

import com.shixi.heima_mm.pojo.StCourse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StCourseControllerTest {
    @Autowired
    private StCourseController stCourseController;

    @Test
    void del() {

    }

    @Test
    void add() {
        stCourseController.add("1","2","3");
    }
}