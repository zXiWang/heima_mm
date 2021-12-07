package com.shixi.heima_mm.controller;

import com.shixi.heima_mm.pojo.Result;
import com.shixi.heima_mm.pojo.StCatalog;
import com.shixi.heima_mm.pojo.StQuestion;
import com.shixi.heima_mm.pojo.StQuestionItem;
import com.shixi.heima_mm.service.IStCatalogService;
import com.shixi.heima_mm.service.IStQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("question")
public class StQuestionController {
    @Autowired
    private IStQuestionService iStQuestionService;

    @Autowired
    private IStCatalogService iStCatalogService;

    @PostMapping("/add")
    public Result add(Integer catalogId,String subject,String type,String difficulty,String analysis){
        StQuestion stQuestion=new StQuestion();
        StCatalog stCatalog=iStCatalogService.findById(catalogId);

        stQuestion.setCatalogName(stCatalog.getName());
        stQuestion.setCatalogId(catalogId);
        stQuestion.setCourseName(stCatalog.getCourseName());
        stQuestion.setCourseId(stCatalog.getCourseId());
        stQuestion.setSubject(subject);
        stQuestion.setType(type);
        stQuestion.setDifficulty(difficulty);
        stQuestion.setAnalysis(analysis);
        stQuestion.setState("0");
        stQuestion.setReviewStatus("0");
        Integer id = iStQuestionService.insert(stQuestion).getId();
        if(id==null)
            return new Result("500","获取id失败",null);
        stQuestion.setNumber(id.toString());
        iStQuestionService.update(stQuestion);
        return new Result("200","创建试题成功!",null);
    }

}
