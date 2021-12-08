package com.shixi.heima_mm.controller;

import com.shixi.heima_mm.pojo.*;
import com.shixi.heima_mm.service.IStCatalogService;
import com.shixi.heima_mm.service.IStCourseService;
import com.shixi.heima_mm.service.IStQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("question")
public class StQuestionController {
    @Autowired
    private IStQuestionService stQuestionService;

    @Autowired
    private IStCatalogService stCatalogService;

    @Autowired
    private IStCourseService stCourseService;

    @PostMapping("/add")
    public Result add(String catalogName,String subject,String type,String difficulty,String analysis){
        StQuestion stQuestion=new StQuestion();
        StCatalog stCatalog=stCatalogService.findByName(catalogName);

        stQuestion.setCatalogName(catalogName);
        stQuestion.setCatalogId(stCatalog.getId());
        stQuestion.setCourseName(stCatalog.getCourseName());
        stQuestion.setCourseId(stCatalog.getCourseId());
        stQuestion.setSubject(subject);
        stQuestion.setType(type);
        stQuestion.setDifficulty(difficulty);
        stQuestion.setAnalysis(analysis);
        stQuestion.setState("0");
        stQuestion.setReviewStatus("0");
        Integer id = stQuestionService.insert(stQuestion).getId();
        if(id==null)
            return new Result("500","获取id失败",null);
        stQuestion.setNumber(id.toString());
        stQuestionService.update(stQuestion);
        return new Result("200","创建试题成功!",null);
    }
    @PostMapping("/change")
    public Result change(Integer id,String catalogName,String courseName,String subject){
        StQuestion stQuestion=new StQuestion();

        stQuestion.setCatalogName(catalogName);
        stQuestion.setCatalogId(stCatalogService.findByName(catalogName).getId());
        stQuestion.setCourseName(courseName);
        stQuestion.setCourseId(stCourseService.findByName(courseName).getId());
        stQuestion.setSubject(subject);
        stQuestion.setId(id);
        stQuestionService.update(stQuestion);
        if(stQuestionService.findBySubject(subject)!=null)
            return new Result("500","更新失败!",null);
        return new Result("200","更新成功",null);
    }

    @PostMapping("/del")
    public Result del(Integer id){
        stQuestionService.delById(id);
        if (stQuestionService.findById(id)!=null)
            return new Result("500","删除失败!",null);
        return new Result("200","删除成功!",null);
    }

}
