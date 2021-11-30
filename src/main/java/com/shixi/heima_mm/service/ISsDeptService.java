package com.shixi.heima_mm.service;

import com.shixi.heima_mm.model.SsDept;


import java.util.List;

public interface ISsDeptService {

    List<SsDept> findAll();


    int save(SsDept ssDept);

    int delByDeptId(Integer deptId);

    int update(SsDept ssDept);
}
