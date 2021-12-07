package com.shixi.heima_mm.service;


import com.shixi.heima_mm.pojo.TrExaminationPaper;

import java.util.List;

public interface ITrExaminationPaperService {
    List<TrExaminationPaper> loadAll();

    TrExaminationPaper insert(TrExaminationPaper trExaminationPaper);

    TrExaminationPaper update(TrExaminationPaper trExaminationPaper);

    void delById(Integer id);
}
