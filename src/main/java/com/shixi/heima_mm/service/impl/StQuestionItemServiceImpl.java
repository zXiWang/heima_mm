package com.shixi.heima_mm.service.impl;


import com.shixi.heima_mm.pojo.StQuestionItem;
import com.shixi.heima_mm.repository.StQuestionItemDao;
import com.shixi.heima_mm.service.IStQuestionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StQuestionItemServiceImpl implements IStQuestionItemService {

    @Autowired
    private StQuestionItemDao stQuestionItemDao;

    @Override
    public List<StQuestionItem> findByQuestionId(int questionId) {
        List<StQuestionItem> stQuestionItems=stQuestionItemDao.findAll(
                (root, cq, cb) -> cb.equal(root.get("questionId"),questionId)
        );
        return stQuestionItems;
    }

    @Override
    public StQuestionItem update(StQuestionItem stQuestionItem) {
        return stQuestionItemDao.save(stQuestionItem);
    }

    @Override
    public StQuestionItem insert(StQuestionItem stQuestionItem) {
        return stQuestionItemDao.save(stQuestionItem);
    }

    @Override
    public void delById(int id) {

    }
}
