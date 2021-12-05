package com.shixi.heima_mm.service;


import com.shixi.heima_mm.pojo.StCatalog;

import java.util.List;

public interface IStCatalogService {

    List<StCatalog> findByCourseId(String courseId);


}
