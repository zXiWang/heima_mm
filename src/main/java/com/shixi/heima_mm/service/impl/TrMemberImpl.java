package com.shixi.heima_mm.service.impl;


import com.shixi.heima_mm.pojo.TrMember;
import com.shixi.heima_mm.repository.TrMemberDao;
import com.shixi.heima_mm.service.ITrMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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


    @Override
    public TrMember findByName(String name) {
        return trMemberDao.findByNickName(name);
    }

    @Override
    public TrMember findByEmail(String email) {
        return trMemberDao.findByEmail(email);
    }

    @Override
    public Boolean findById(Integer id) {
        boolean flag = false;
        if (trMemberDao.findById(id).isPresent())
            flag = true;
        return flag;
    }

    @Override
    public Page<TrMember> show(Pageable pageable, String context) {
        return trMemberDao.findAll(pageable);
    }

//    @Override
//    public TrMember findAllById(Integer id, Integer currentPage, Integer pageSize) {
//        Pageable pageable = PageRequest.of(currentPage, pageSize);
//
//
//        return ResultUtil.unitedResult(ResultEnum.SUCCESS, trMemberDao.findAllById(id, pageable));
//    }
}
