package com.shixi.heima_mm.controller;

import com.shixi.heima_mm.pojo.StCourse;
import com.shixi.heima_mm.service.IStCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course")
public class StCourseController {
    @Autowired
    private IStCourseService stCourseService;

    @PostMapping("/index")
    public List<StCourse> index(){
        return stCourseService.loadAll();
    }
}
