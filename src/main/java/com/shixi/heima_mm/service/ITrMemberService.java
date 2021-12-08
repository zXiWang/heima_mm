package com.shixi.heima_mm.service;


import com.shixi.heima_mm.pojo.TrMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITrMemberService {
    List<TrMember> loadAll();

    TrMember insert(TrMember trExaminationPaper);

    TrMember update(TrMember trExaminationPaper);

    void delById(Integer id);

    TrMember findByName(String name);

    TrMember findByEmail(String email);

//    Page<TrMember> findAllById(Pageable pageable);
}
