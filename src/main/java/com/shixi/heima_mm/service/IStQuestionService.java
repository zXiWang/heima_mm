package com.shixi.heima_mm.service;


import com.shixi.heima_mm.pojo.StQuestion;
import com.sun.org.apache.xml.internal.resolver.Catalog;

import java.util.List;

public interface IStQuestionService {
    List<StQuestion> findByCatalogId(int catalogId);

    StQuestion insert(StQuestion stQuestion);

    StQuestion update(StQuestion stQuestion);

    void delById(int id);

}
