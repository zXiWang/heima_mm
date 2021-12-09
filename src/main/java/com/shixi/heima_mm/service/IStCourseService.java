package com.shixi.heima_mm.service;


import com.shixi.heima_mm.pojo.StCatalog;
import com.shixi.heima_mm.pojo.StCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStCourseService {
    List<StCourse> loadAll();

    StCourse insert(StCourse stCourse);

    StCourse update(StCourse stCourse);

    void delById(Integer id);


    boolean findById(Integer id);

    StCourse findByName(String name);

    Page<StCourse> show(Pageable pageable, String context);
}
