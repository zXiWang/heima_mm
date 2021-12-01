package com.shixi.heima_mm.laji;

import com.shixi.heima_mm.laji.SsRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SsRoleMapper {
    @Select("select * from ss_role")
    List<SsRole> findAll();

    @Insert("insert into ss_role values(#{roleId},#{name},#{remark},#{orderNo},#{createBy},#{createDept},#{createTime}," +
            "#{updateBy},#{updateTime})")
    int insert(SsRole ssRole);

    @Delete("delete from ss_role where role_id=#{roleId}")
    int delByRoleId(Integer roleId);

    @Update("update ss_role set " +
            "name=#{name}" +
            "remark=#{remark}" +
            "where role_id=#{roleId}")
    int update(SsRole ssRole);
}
