package com.shixi.heima_mm.pojo;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity
@DynamicUpdate
@Table(name="tr_member_question")
@EntityListeners(AuditingEntityListener.class)
public class TrMemberQuestion {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "examinationpaper_id" )
    private Integer examinationpaperId;

    @Column(name = "answer_result")
    private String answerResult;

    @Column(name = "right_answer")
    private String rightAnswer;

}
