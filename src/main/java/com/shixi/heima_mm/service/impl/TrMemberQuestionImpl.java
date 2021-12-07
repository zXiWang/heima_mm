package com.shixi.heima_mm.service.impl;

import com.shixi.heima_mm.pojo.TrMemberQuestion;
import com.shixi.heima_mm.repository.TrMemberQuestionDao;
import com.shixi.heima_mm.service.ITrMemberQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrMemberQuestionImpl implements ITrMemberQuestionService {
   @Autowired
    private TrMemberQuestionDao trMemberQuestionDao;

    @Override
    public List<TrMemberQuestion> loadAll() {
        return trMemberQuestionDao.findAll();
    }

    @Override
    public TrMemberQuestion insert(TrMemberQuestion trMemberQuestion) {
        return trMemberQuestionDao.save(trMemberQuestion);
    }

    @Override
    public TrMemberQuestion update(TrMemberQuestion trMemberQuestion) {
        return trMemberQuestionDao.save(trMemberQuestion);
    }

    @Override
    public void delById(Integer id) {
        trMemberQuestionDao.deleteById(id);
    }

}
