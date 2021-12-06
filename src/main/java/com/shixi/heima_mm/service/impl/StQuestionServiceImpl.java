package com.shixi.heima_mm.service.impl;


import com.shixi.heima_mm.pojo.StCatalog;
import com.shixi.heima_mm.pojo.StQuestion;
import com.shixi.heima_mm.repository.StQuestionDao;
import com.shixi.heima_mm.service.IStQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StQuestionServiceImpl implements IStQuestionService {

    @Autowired
    private StQuestionDao stQuestionDao;

    @Override
    public List<StQuestion> findByCatalogId(int catalogId) {
        List<StQuestion> stQuestions = stQuestionDao.findAll(
                (root, cq, cb) -> cb.equal(root.get("catalogId"), catalogId)
        );
        return stQuestions;
    }

    @Override
    public StQuestion insert(StQuestion stQuestion) {
        return stQuestionDao.save(stQuestion);
    }

    @Override
    public StQuestion update(StQuestion stQuestion) {
        return stQuestionDao.save(stQuestion);
    }

    @Override
    public void delById(int id) {
        stQuestionDao.deleteById(id);
    }
}
