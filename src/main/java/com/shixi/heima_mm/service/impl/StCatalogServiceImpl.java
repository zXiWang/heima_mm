package com.shixi.heima_mm.service.impl;


import com.shixi.heima_mm.pojo.StCatalog;
import com.shixi.heima_mm.repository.StCatalogDao;
import com.shixi.heima_mm.service.IStCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StCatalogServiceImpl implements IStCatalogService {

    @Autowired
    private StCatalogDao stCatalogDao;

    //    @Override
//    public List<StCatalog> loadAll(String courseId) {
//        return stCatalogDao.findByCourseId(courseId);
//    }
    @Override
    public List<StCatalog> findByCourseId(String courseId) {

        List<StCatalog> stCatalogs = stCatalogDao.findAll(
                (root, cq, cb) -> cb.equal(root.get("courseId"), courseId)
        );
        return stCatalogs;
    }

}
