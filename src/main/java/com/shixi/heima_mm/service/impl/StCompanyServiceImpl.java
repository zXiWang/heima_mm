package com.shixi.heima_mm.service.impl;


public class StCompanyServiceImpl {

  private String id;
  private String name;
  private java.sql.Timestamp expirationDate;
  private String address;
  private String licenseId;
  private String representative;
  private String phone;
  private String companySize;
  private String industry;
  private String remarks;
  private long state;
  private String city;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public java.sql.Timestamp getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(java.sql.Timestamp expirationDate) {
    this.expirationDate = expirationDate;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getLicenseId() {
    return licenseId;
  }

  public void setLicenseId(String licenseId) {
    this.licenseId = licenseId;
  }


  public String getRepresentative() {
    return representative;
  }

  public void setRepresentative(String representative) {
    this.representative = representative;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getCompanySize() {
    return companySize;
  }

  public void setCompanySize(String companySize) {
    this.companySize = companySize;
  }


  public String getIndustry() {
    return industry;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
  }


  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

}
