package com.shixi.heima_mm.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
@Table(name = "st_question")
@EntityListeners(AuditingEntityListener.class)
public class StQuestion {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "catalog_id")
    private Integer catalogId;

    @Column(name = "catalog_name" )
    private String catalogName;

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "number")
    private String number;

    @Column(name = "subject")
    private String subject;

    @Column(name = "type")
    private String type;

    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "analysis")
    private String analysis;

    @Column(name = "analysis_video")
    private String analysisVideo;

    @Column(name = "remark")
    private String remark;

    @Column(name = "is_classic")
    private String isClassic;

    @Column(name = "state")
    private String state;

    @Column(name = "review_status")
    private String reviewStatus;

    @CreatedBy
    @Column(name = "create_by")
    private String createBy;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name ="create_time" )
    private Date createTime;

    @LastModifiedBy
    @Column(name = "update_by")
    private String updateBy;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time")
    private Date updateTime;

}
