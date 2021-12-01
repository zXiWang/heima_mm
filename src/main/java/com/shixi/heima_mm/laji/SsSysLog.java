package com.shixi.heima_mm.laji;


public class SsSysLog {

  private String id;
  private String userName;
  private String ip;
  private java.sql.Timestamp time;
  private String method;
  private String action;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }


  public java.sql.Timestamp getTime() {
    return time;
  }

  public void setTime(java.sql.Timestamp time) {
    this.time = time;
  }


  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }


  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

}
