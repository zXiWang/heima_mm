package com.shixi.heima_mm.repository;


import com.shixi.heima_mm.pojo.StCatalog;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface StCatalogDao extends JpaRepository<StCatalog, Integer>, JpaSpecificationExecutor<StCatalog> {


    StCatalog findByName(@Param("name") String name);
}

