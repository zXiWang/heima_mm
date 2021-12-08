package com.shixi.heima_mm.repository;

import com.shixi.heima_mm.pojo.TrMember;
import com.shixi.heima_mm.pojo.UserAdmin;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TrMemberDao extends JpaRepository<TrMember,Integer>, CrudRepository<TrMember,Integer> {

    TrMember findByEmail(@Param("email") String email);
    TrMember findByNickName(String name);

    Page<TrMember> findAllById(@Param("id") Integer id, Pageable pageable);
}
