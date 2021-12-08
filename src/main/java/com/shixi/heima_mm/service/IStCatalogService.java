package com.shixi.heima_mm.service;


import com.shixi.heima_mm.pojo.StCatalog;

import java.util.List;

public interface IStCatalogService {

    List<StCatalog> findByCourseId(int courseId);

    StCatalog update(StCatalog stCatalog);

    StCatalog insert(StCatalog stCatalog);

    void delById(int id);

    StCatalog findById(int id);


    StCatalog findByName(String name);
}
