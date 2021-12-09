package com.shixi.heima_mm.service.impl;


import com.shixi.heima_mm.pojo.StCatalog;
import com.shixi.heima_mm.pojo.StQuestion;
import com.shixi.heima_mm.repository.StCatalogDao;
import com.shixi.heima_mm.service.IStCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StCatalogServiceImpl implements IStCatalogService {

    @Autowired
    private StCatalogDao stCatalogDao;

    @Override
    public List<StCatalog> findByCourseId(int courseId) {

        List<StCatalog> stCatalogs = stCatalogDao.findAll(
                (root, cq, cb) -> cb.equal(root.get("courseId"), courseId)
        );
        return stCatalogs;
    }

    @Override
    public StCatalog update(StCatalog stCatalog){
        return stCatalogDao.save(stCatalog);
    }

    @Override
    public StCatalog insert(StCatalog stCatalog) {
        return stCatalogDao.save(stCatalog);
    }

    @Override
    public void delById(int id) {
        stCatalogDao.deleteById(id);
    }

    @Override
    public StCatalog findById(int id) {
        Optional<StCatalog> op = stCatalogDao.findById(1);
        if(op.isPresent()) {
            return op.get();
        } else  {
            return null;
        }
    }

    @Override
    public StCatalog findByName(String name) {

        return stCatalogDao.findByName(name);
    }

    public List<StCatalog> loadAll() {

        return stCatalogDao.findAll();
    }

    public Page<StCatalog> show(Pageable pageable, String context) {
        return stCatalogDao.findAll(pageable);
    }

}
