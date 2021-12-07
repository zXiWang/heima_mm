package com.shixi.heima_mm.service.impl;

import com.shixi.heima_mm.pojo.StQuestionItem;
import com.shixi.heima_mm.repository.StQuestionItemDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StQuestionItemServiceImplTest {
    @Autowired
    private StQuestionItemServiceImpl stQuestionItemService;

    @Test
    void findByQuestionId() {
        stQuestionItemService.findByQuestionId(3).forEach(e-> System.out.println(e));
    }

    @Test
    void update() {
        StQuestionItem stQuestionItem=new StQuestionItem();
        stQuestionItem.setId(700);

    }

    @Test
    void insert() {
    }

    @Test
    void delById() {
    }

    @Test
    void findById() {
        System.out.println(stQuestionItemService.findById(1));
    }

}