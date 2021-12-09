package com.shixi.heima_mm.service;


import com.shixi.heima_mm.pojo.StCatalog;
import com.shixi.heima_mm.pojo.StQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStCatalogService {

    List<StCatalog> findByCourseId(int courseId);

    StCatalog update(StCatalog stCatalog);

    StCatalog insert(StCatalog stCatalog);

    void delById(int id);

    StCatalog findById(int id);

    Page<StCatalog> show(Pageable pageable, String context);

    StCatalog findByName(String name);
}
