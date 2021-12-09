package com.shixi.heima_mm.controller;

import com.google.gson.Gson;
import com.shixi.heima_mm.pojo.Result;
import com.shixi.heima_mm.pojo.StCatalog;
import com.shixi.heima_mm.pojo.StCourse;
import com.shixi.heima_mm.pojo.StCourse;
import com.shixi.heima_mm.service.IStCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
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
    @ResponseBody
    public Result del(Integer id){
        stCourseService.delById(id);
        if (stCourseService.findById(id))
            return new Result("500","删除失败!",null);
        return new Result("200","删除成功!",null);
    }

    @PostMapping("/add")
    @ResponseBody
    public Result add(String name,String remark,String state){

        StCourse stCourse=new StCourse();
        if (stCourseService.findByName(name)!=null)
            return new Result("404","已有同名学科!",null);
        stCourse.setName(name);
        stCourse.setRemark(remark);
        stCourse.setState(state);
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

    @RequestMapping("/show")
    @ResponseBody
    public String show(String context, Integer currentPage, Integer pageSize, String sort, Boolean asc) {
        List<Object> stCourses = new ArrayList<>();
        Pageable pageable;

        if (!"".equals(sort)) {
            Sort.Order order = new Sort.Order((asc ? Sort.Direction.ASC : Sort.Direction.DESC), sort);
            Sort s = Sort.by(order);
            pageable = PageRequest.of(currentPage, pageSize, s);
        } else {
            pageable = PageRequest.of(currentPage, pageSize);
        }
        Page<StCourse> stCoursePage = this.stCourseService.show(pageable, context);
        if (stCoursePage.getContent().size() == 0) {
            return String.valueOf(new Result("500", "失败!", null));
        }

        stCourses.add(stCoursePage.getTotalElements());
        stCourses.add(stCoursePage.getTotalPages());
        stCourses.add(stCoursePage.getContent());

        Result res = new Result("200", "成功", new Gson().toJson(stCourses));
        System.out.println(res);

        return new Gson().toJson(res);

    }
}
