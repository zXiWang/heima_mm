package com.shixi.heima_mm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
@Table(name = "tr_member")
@EntityListeners(AuditingEntityListener.class)
public class TrMember {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "password")
    private String password;


    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "email")
    private String email;


    @Column(name = "telephone")
    private String telephone;

    @Column(name = "address")
    private String address;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "register_date")
    private Date registerDate;


    @Column(name = "remark")
    private String remark;

    @Column(name = "state")
    private String state;

}
