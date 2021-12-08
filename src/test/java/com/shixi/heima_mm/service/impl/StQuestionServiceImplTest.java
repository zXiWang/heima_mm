package com.shixi.heima_mm.service.impl;

import com.shixi.heima_mm.service.IStQuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StQuestionServiceImplTest {

    @Autowired
    private StQuestionServiceImpl stQuestionService;

    @Test
    void delById() {
        stQuestionService.delById(1002);
    }
}