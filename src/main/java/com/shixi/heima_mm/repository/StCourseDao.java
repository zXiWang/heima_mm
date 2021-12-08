package com.shixi.heima_mm.repository;


import com.shixi.heima_mm.pojo.StCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StCourseDao extends JpaRepository<StCourse, Integer>{


    StCourse findByName(@Param("name") String name);
}
