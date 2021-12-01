package com.shixi.heima_mm.laji;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SsModule {

  @Id
  @Column(name = "moduleId")
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private String moduleId;

  @Column(name = "parentId")
  private String parentId;

  @Column(name = "parentName")
  private String parentName;

  @Column(name = "name")
  private String name;

  @Column(name = "isLeaf")
  private double isLeaf;

  @Column(name = "ico")
  private String ico;

  @Column(name = "cpermission")
  private String cpermission;

  @Column(name = "curl")
  private String curl;

  @Column(name = "ctype")
  private double ctype;

  @Column(name ="state" )
  private double state;

  @Column(name = "belong")
  private String belong;

  @Column(name = "remark")
  private String remark;

  @Column(name = "orderNo")
  private double orderNo;


}
