package com.shixi.heima_mm.service;


import com.shixi.heima_mm.pojo.TrMember;

import java.util.List;

public interface ITrMemberService {
    List<TrMember> loadAll();

    TrMember insert(TrMember trExaminationPaper);

    TrMember update(TrMember trExaminationPaper);

    void delById(Integer id);

    TrMember login(String email);
}
