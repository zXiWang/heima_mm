package com.shixi.heima_mm.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "st_course")
@EntityListeners(AuditingEntityListener.class)
public class StCourse {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "state" )
    private String state;

    @Column(name = "remark")
    private String remark;

    @Column(name = "order_no")
    private Integer orderNo;

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
