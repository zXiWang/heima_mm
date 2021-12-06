package com.shixi.heima_mm.pojo;



import lombok.Data;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
@Data
@Entity
@DynamicUpdate
@Table(name = "st_question_item")
@EntityListeners(AuditingEntityListener.class)
public class StQuestionItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "content" )
    private String content;


    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "is_right")
    private String isRight;


}
