package com.shixi.heima_mm.controller;

import com.google.gson.Gson;
import com.shixi.heima_mm.pojo.Result;
import com.shixi.heima_mm.pojo.StCatalog;
import com.shixi.heima_mm.pojo.StQuestion;
import com.shixi.heima_mm.service.impl.StCatalogServiceImpl;
import com.shixi.heima_mm.service.impl.StCourseServiceImpl;
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
    public Result add(String name, String remark, String courseName) {
        StCatalog stCatalog = new StCatalog();
        stCatalog.setName(name);
        stCatalog.setRemark(remark);
        stCatalog.setCourseName(courseName);
        stCatalog.setCourseId(stCourseService.findByName(courseName).getId());
        stCatalogService.insert(stCatalog);
        if (stCatalogService.findByName(name) == null)
            return new Result("500", "添加失败!", null);
        return new Result("200", "添加成功", null);
    }

    @PostMapping("/del")
    public Result del(Integer id) {
        stCatalogService.delById(id);
        if (stCatalogService.findById(id) != null)
            return new Result("500", "删除失败!", null);
        return new Result("200", "删除成功!", null);
    }

    @PostMapping("/change")
    public Result change(Integer id, String name, String remark, String courseName) {
        StCatalog stCatalog = new StCatalog();
        stCatalog.setName(name);
        stCatalog.setRemark(remark);
        stCatalog.setCourseName(courseName);
        stCatalog.setId(id);
        stCatalogService.update(stCatalog);
        if (stCatalogService.findByName(name) == null)
            return new Result("500", "更新失败!", null);
        return new Result("200", "更新成功", null);
    }

    @RequestMapping("/show")
    @ResponseBody
    public String show(String context, Integer currentPage, Integer pageSize, String sort, Boolean asc) {
        List<Object> stCatalogs = new ArrayList<>();
        Pageable pageable;

        if (!"".equals(sort)) {
            Sort.Order order = new Sort.Order((asc ? Sort.Direction.ASC : Sort.Direction.DESC), sort);
            Sort s = Sort.by(order);
            pageable = PageRequest.of(currentPage, pageSize, s);
        } else {
            pageable = PageRequest.of(currentPage, pageSize);
        }
        Page<StCatalog> stCatalogPage = this.stCatalogService.show(pageable, context);
        if (stCatalogPage.getContent().size() == 0) {
            return String.valueOf(new Result("500", "失败!", null));
        }

        stCatalogs.add(stCatalogPage.getTotalElements());
        stCatalogs.add(stCatalogPage.getTotalPages());
        stCatalogs.add(stCatalogPage.getContent());

        Result res = new Result("200", "成功", new Gson().toJson(stCatalogs));
        System.out.println(res);

        return new Gson().toJson(res);

    }

}
