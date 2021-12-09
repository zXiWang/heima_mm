package com.shixi.heima_mm.service;


import com.shixi.heima_mm.pojo.StQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStQuestionService {
    List<StQuestion> findByCatalogId(int catalogId);

    Page<StQuestion> show(Pageable pageable, String context, Integer catalogId);

    StQuestion insert(StQuestion stQuestion);

    StQuestion update(StQuestion stQuestion);

    void delById(int id);

    StQuestion findById(Integer questionId);

    StQuestion findBySubject(String subject);
}
