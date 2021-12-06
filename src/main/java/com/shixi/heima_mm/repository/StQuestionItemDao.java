package com.shixi.heima_mm.repository;


import com.shixi.heima_mm.pojo.StQuestion;
import com.shixi.heima_mm.pojo.StQuestionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StQuestionItemDao extends JpaRepository<StQuestionItem,Integer>, JpaSpecificationExecutor<StQuestionItem> {


}
