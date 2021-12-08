package com.shixi.heima_mm.service;


import com.shixi.heima_mm.pojo.StQuestion;

import java.util.List;

public interface IStQuestionService {
    List<StQuestion> findByCatalogId(int catalogId);

    StQuestion insert(StQuestion stQuestion);

    StQuestion update(StQuestion stQuestion);

    void delById(int id);

    StQuestion findById(Integer questionId);

    StQuestion findBySubject(String subject);
}
