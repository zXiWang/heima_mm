package com.shixi.heima_mm.laji;

import com.shixi.heima_mm.laji.SsDept;

public interface ISsDeptService {

    SsDept findByDeptId(Integer DeptId);

    int save(SsDept ssDept);

    int delByDeptId(Integer deptId);

    int update(SsDept ssDept);
}
