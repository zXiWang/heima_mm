package com.shixi.heima_mm.controller;

import com.shixi.heima_mm.pojo.Result;
import com.shixi.heima_mm.pojo.StCatalog;
import com.shixi.heima_mm.service.impl.StCatalogServiceImpl;
import com.shixi.heima_mm.service.impl.StCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class StCatalogController {
    @Autowired
    private StCatalogServiceImpl stCatalogService;

    @Autowired
    private StCourseServiceImpl stCourseService;

    @GetMapping("/show")
    public List<StCatalog> show() {
        return stCatalogService.loadAll();
    }

    @PostMapping("/add")
    public Result add(String name,String remark,String courseName){
            StCatalog stCatalog=new StCatalog();
            stCatalog.setName(name);
            stCatalog.setRemark(remark);
            stCatalog.setCourseName(courseName);
            stCatalog.setCourseId(stCourseService.findByName(courseName).getId());
            stCatalogService.insert(stCatalog);
            if(stCatalogService.findByName(name)==null)
                return new Result("500","添加失败!",null);
            return new Result("200","添加成功",null);
    }

    @PostMapping("/del")
    public Result del(Integer id){
        stCatalogService.delById(id);
        if (stCatalogService.findById(id)!=null)
            return new Result("500","删除失败!",null);
        return new Result("200","删除成功!",null);
    }

    @PostMapping("/change")
    public Result change(Integer id,String name,String remark,String courseName){
        StCatalog stCatalog=new StCatalog();
        stCatalog.setName(name);
        stCatalog.setRemark(remark);
        stCatalog.setCourseName(courseName);
        stCatalog.setId(id);
        stCatalogService.update(stCatalog);
        if(stCatalogService.findByName(name)==null)
            return new Result("500","更新失败!",null);
        return new Result("200","更新成功",null);
    }

}
