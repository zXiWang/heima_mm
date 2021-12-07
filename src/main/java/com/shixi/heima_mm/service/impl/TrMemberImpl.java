package com.shixi.heima_mm.service.impl;


import com.shixi.heima_mm.pojo.TrMember;
import com.shixi.heima_mm.repository.TrExaminationPaperDao;
import com.shixi.heima_mm.repository.TrMemberDao;
import com.shixi.heima_mm.service.ITrMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrMemberImpl implements ITrMemberService {
    @Autowired
    private TrMemberDao trMemberDao;


    @Override
    public List<TrMember> loadAll() {
        return trMemberDao.findAll();
    }

    @Override
    public TrMember insert(TrMember trMember) {
        return trMemberDao.save(trMember);
    }

    @Override
    public TrMember update(TrMember trMember) {
        return trMemberDao.save(trMember);
    }

    @Override
    public void delById(Integer id) {
        trMemberDao.deleteById(id);
    }
}
