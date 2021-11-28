package com.shixi.heima_mm.model;


public class SsDept {

  private String deptId;
  private String deptName;
  private String parentId;
  private double state;


  public String getDeptId() {
    return deptId;
  }

  public void setDeptId(String deptId) {
    this.deptId = deptId;
  }


  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }


  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }


  public double getState() {
    return state;
  }

  public void setState(double state) {
    this.state = state;
  }

}
