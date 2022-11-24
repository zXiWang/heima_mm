package com.shixi.heima_mm.controller;

import com.shixi.heima_mm.pojo.Result;
import com.shixi.heima_mm.pojo.StQuestion;
import com.shixi.heima_mm.pojo.StQuestionItem;
import com.shixi.heima_mm.repository.StQuestionItemDao;
import com.shixi.heima_mm.service.IStQuestionItemService;
import com.shixi.heima_mm.service.IStQuestionService;
import com.shixi.heima_mm.service.impl.StQuestionItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/option")
public class StQuestionItemController {

    @Autowired
    private IStQuestionItemService stQuestionItemService;

    @Autowired
    private IStQuestionService stQuestionService;

    //TODO 单选多选简答的形式判断
    @PostMapping("/judge")
    public Result judge(Integer id, Integer id2, Integer id3, Integer id4) {
        StQuestionItem stQuestionItem = stQuestionItemService.findById(id);
        StQuestion stQuestion = stQuestionService.findById(stQuestionItem.getQuestionId());
        int a[] = {id, id2, id3, id4};
        //单选
        if (stQuestion.getType().equals("1")) {
            int temp = 0;
            for (int i = 0; i < a.length; i++) {
                if (a[i] == 0)
                    continue;
                stQuestionItem = stQuestionItemService.findById(a[i]);
                if (stQuestionItem.getIsRight().equals("1"))
                    temp++;
            }
            if (temp != 1) {
                return new Result("500", "答案错误!", null);
            }
            return new Result("200", "答案正确!", null);


        }
        //多选
        else if (stQuestion.getType().equals("2")) {
            int temp = 0, count = 0;
            //得出4个选项的实体
            List<StQuestionItem> stQuestionItems = stQuestionItemService.findByQuestionId(stQuestion.getId());
            for (int i = 0; i < 4; i++) {
                //记4个实体中的正确个数
                if (stQuestionItems.get(i).getIsRight().equals("1"))
                    count++;
            }
            for (int i = 0; i < 4; i++) {
                if (a[i] == 0)
                    continue;
                if (!stQuestionItemService.findById(a[i]).getIsRight().equals("1"))
                    return new Result("501", "选择了至少一个错误答案!", null);

                temp++;

            }
            //判断答案
            if (temp == 0)
                //不加分
                return new Result("500", "答案错误!", null);
            if (temp < count) {
                //少选只加1分
                return new Result("201", "答案正确,但少选了正确答案!", null);
            }
            //全对加3分
            if (temp == count) {
                return new Result("200", "答案正确!", null);

            }

        }
        //简答题
        //TODO
//        else if(stQuestion.getType()=="5"){
//
//        }
        return new Result("404", "未知的错误!", null);
    }

}
