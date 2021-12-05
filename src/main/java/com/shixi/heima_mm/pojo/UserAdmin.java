package com.shixi.heima_mm.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "user_admin")
@EntityListeners(AuditingEntityListener.class)
public class UserAdmin {

        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        private String id;

        @Column(name = "name")
        private String name;

        @Column(name = "password" )
        private String password;

        @CreatedDate
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        @Column(name ="create_time" )
        private Date createTime;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
        @Column(name = "apply_time")
        private Date applyTime;


}
