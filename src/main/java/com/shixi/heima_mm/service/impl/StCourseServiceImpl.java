package com.shixi.heima_mm.service.impl;


import com.shixi.heima_mm.pojo.StCatalog;
import com.shixi.heima_mm.pojo.StCourse;
import com.shixi.heima_mm.repository.StCatalogDao;
import com.shixi.heima_mm.repository.StCourseDao;
import com.shixi.heima_mm.service.IStCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StCourseServiceImpl implements IStCourseService {

    @Autowired
    private StCourseDao stCourseDao;
    @Autowired
    private StCatalogDao stCatalogDao;

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
        List<StCatalog> stCatalogs = stCatalogDao.findAll(
                (root, cq, cb) -> cb.equal(root.get("courseId"), id)
        );
        for (int i = 0; i < stCatalogs.size(); i++) {
            stCatalogDao.deleteById(stCatalogs.get(i).getId());
        }
        stCourseDao.deleteById(id);
    }

    @Override
    public boolean findById(Integer id) {
        boolean flag=false;
        if(stCourseDao.findById(id).isPresent())
            flag=true;
        return flag;
    }
}
