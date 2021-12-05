package com.shixi.heima_mm.service;


import com.shixi.heima_mm.pojo.StCourse;

import java.util.List;

public interface IStCourseService {
    List<StCourse> loadAll(String id);

    StCourse save(StCourse stCourse);

    StCourse update(StCourse stCourse);

    void delById(String id);



}
