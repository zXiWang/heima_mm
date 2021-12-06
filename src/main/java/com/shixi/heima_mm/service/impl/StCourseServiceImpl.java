package com.shixi.heima_mm.service.impl;


import com.shixi.heima_mm.pojo.StCourse;
import com.shixi.heima_mm.repository.StCourseDao;
import com.shixi.heima_mm.service.IStCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StCourseServiceImpl implements IStCourseService {

    @Autowired
    private StCourseDao stCourseDao;

    @Override
    public List<StCourse> loadAll() {
        return stCourseDao.findAll();
    }

    @Override
    public StCourse insert(StCourse stCourse) {
        return stCourseDao.save(stCourse);
    }

    @Override
    public StCourse update(StCourse stCourse) {
        return stCourseDao.save(stCourse);
    }

    @Override
    public void delById(Integer id) {
        stCourseDao.deleteById(id);
    }
}
