package com.shixi.heima_mm.laji;

import com.shixi.heima_mm.laji.SsModule;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SsModuleMapper {

    @Select("select * from ss_module")
    List<SsModule> findAll();

    @Insert("insert into ss_module values(#{moduleId},#{parentId},#{parentName},#{name},#{isLeaf},#{ico},#{cpermission},#{curl}," +
            "#{ctype},#{state},#{belong},#{remark})")
    int insert(SsModule ssModule);

    @Delete("delete from ss_module where module_id=#{moduleId}")
    int delByModuleId(Integer moduleId);

    @Update("update ss_module set " +
            "parent_id=#{parentId}," +
            "parent_name=#{parentName}" +
            "name=#{name}" +
            "is_leaf=#{isLeaf}" +
            "ico=#{ico}" +
            "cpermission=#{cpermission}" +
            "curl=#{curl}" +
            "ctype=#{ctype}" +
            "state=#{state}" +
            "belong=#{belong}" +
            "remark=#{remark}" +
            "where module_id=#{moduleId}")
    int update(SsModule ssModule);
}
