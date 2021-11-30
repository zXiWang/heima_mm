package com.shixi.heima_mm.service.impl;


public class TrExaminationPaperServiceImpl {

  private String id;
  private String memberId;
  private double score;
  private long state;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp applyTime;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }


  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getApplyTime() {
    return applyTime;
  }

  public void setApplyTime(java.sql.Timestamp applyTime) {
    this.applyTime = applyTime;
  }

}
