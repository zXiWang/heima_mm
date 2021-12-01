package com.shixi.heima_mm.laji;


import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ss_dept")
@EntityListeners(AuditingEntityListener.class)
public class SsDept {

  @Id
  @Column(name = "dept_id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private String deptId;

  @Column(name = "dept_name")
  private String deptName;

  @Column(name = "parent_id" )
  private String parentId;


  @Column(name = "state")
  private Long state;


}
