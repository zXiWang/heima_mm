package com.shixi.heima_mm.service;


import com.shixi.heima_mm.pojo.StQuestionItem;

import java.util.List;

public interface IStQuestionItemService {

    List<StQuestionItem> findByQuestionId(int id);

    StQuestionItem update(StQuestionItem stQuestionItem);

    StQuestionItem insert(StQuestionItem stQuestionItem);

    void delById(int id);

}
