package com.shixi.heima_mm.repository;

import com.shixi.heima_mm.pojo.UserAdmin;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserAdminDao extends JpaRepository<UserAdmin, StringNode>, JpaSpecificationExecutor<UserAdmin> {

    UserAdmin findById(@Param("id") String id);

    UserAdmin findByName(@Param("name") String name);
}
