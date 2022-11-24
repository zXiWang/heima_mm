package com.shixi.heima_mm.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StQuestionControllerTest {
    @Autowired
    StQuestionController stQuestionController;

    @Test
    void add() {

    }

    @Test
    void show() {
        System.out.println(stQuestionController.show("", 2, 10, "", true, 1));
    }
}