package com.shixi.heima_mm.laji;

import com.shixi.heima_mm.laji.SsDept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SsDeptMapper {

    @Select("select * from ss_dept")
    List<SsDept> findAll();

    @Insert("insert into ss_dept values(#{deptId},#{deptName},#{parentId},#{state})")
    int insert(SsDept ssDept);

    @Delete("delete from ss_dept where dept_id=#{deptId}")
    int delByDeptId(Integer deptId);

    @Update("update ss_dept set " +
            "dept_name=#{deptName}," +
            "parent_id=#{parentId}" +
            "status=#{state}" +
            "where dept_id=#{deptId}")
    int update(SsDept ssDept);
}
