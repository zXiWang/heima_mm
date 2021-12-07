package com.shixi.heima_mm.service;


import com.shixi.heima_mm.pojo.TrMemberQuestion;

import java.util.List;

public interface ITrMemberQuestionService {
    List<TrMemberQuestion> loadAll();

    TrMemberQuestion insert(TrMemberQuestion trExaminationPaper);

    TrMemberQuestion update(TrMemberQuestion trExaminationPaper);

    void delById(Integer id);


}
