package com.shixi.heima_mm.service.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shixi.heima_mm.pojo.TrExaminationPaper;
import com.shixi.heima_mm.repository.TrExaminationPaperDao;
import com.shixi.heima_mm.service.ITrExaminationPaperService;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Service
public class TrExaminationPaperImpl implements ITrExaminationPaperService {

    @Autowired
    private TrExaminationPaperDao trExaminationPaperDao;

    @Override
    public List<TrExaminationPaper> loadAll() {
        return trExaminationPaperDao.findAll();
    }

    @Override
    public TrExaminationPaper insert(TrExaminationPaper trExaminationPaper) {
        return trExaminationPaperDao.save(trExaminationPaper);
    }

    @Override
    public TrExaminationPaper update(TrExaminationPaper trExaminationPaper) {
        return trExaminationPaperDao.save(trExaminationPaper);
    }

    @Override
    public void delById(Integer id) {
        trExaminationPaperDao.deleteById(id);
    }
}
