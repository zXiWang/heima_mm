package com.shixi.heima_mm.controller;

import com.shixi.heima_mm.pojo.Result;
import com.shixi.heima_mm.pojo.StCourse;
import com.shixi.heima_mm.pojo.StCourse;
import com.shixi.heima_mm.service.IStCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course")
public class StCourseController {
    @Autowired
    private IStCourseService stCourseService;

    @GetMapping("/show")
    public List<StCourse> show(){
        return stCourseService.loadAll();
    }

    @PostMapping("/del")
    public Result del(Integer id){
        stCourseService.delById(id);
        if (stCourseService.findById(id))
            return new Result("500","删除失败!",null);
        return new Result("200","删除成功!",null);
    }

    @PostMapping("/add")
    public Result add(String name,String remark){
        StCourse stCourse=new StCourse();
        stCourse.setName(name);
        stCourse.setRemark(remark);
        stCourseService.insert(stCourse);
        if(stCourseService.findByName(name)==null)
            return new Result("500","添加失败!",null);
        return new Result("200","添加成功",null);
    }

    @PostMapping("/change")
    public Result change(Integer id,String name,String remark){
        StCourse stCourse=new StCourse();
        stCourse.setName(name);
        stCourse.setRemark(remark);
        stCourse.setId(id);
        stCourseService.update(stCourse);
        if(stCourseService.findByName(name)==null)
            return new Result("500","更新失败!",null);
        return new Result("200","更新成功",null);
    }
}
