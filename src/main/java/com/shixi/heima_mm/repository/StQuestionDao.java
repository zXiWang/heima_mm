package com.shixi.heima_mm.repository;


import com.shixi.heima_mm.pojo.StQuestion;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StQuestionDao extends JpaRepository<StQuestion, Integer>, JpaSpecificationExecutor<StQuestion> {

    StQuestion findBySubject(@Param("subject") String subject);
}
