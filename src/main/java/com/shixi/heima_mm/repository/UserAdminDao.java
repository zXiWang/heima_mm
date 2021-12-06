package com.shixi.heima_mm.repository;

import com.shixi.heima_mm.pojo.UserAdmin;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserAdminDao extends JpaRepository<UserAdmin, Integer>, JpaSpecificationExecutor<UserAdmin> {

}
