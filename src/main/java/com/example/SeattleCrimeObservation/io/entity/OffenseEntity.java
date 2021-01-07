package com.example.SeattleCrimeObservation.io.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "temp")
public class OffenseEntity {
  @Id
  private long offenseId;
  private String offenseName;
  private String offenseGroup;
  private String offenseCategory;
  private String date;
  private String zipCode;
  private String mcpp;

  public long getOffenseId() {
    return offenseId;
  }

  public void setOffenseId(long offenseId) {
    this.offenseId = offenseId;
  }

  public String getOffenseName() {
    return offenseName;
  }

  public void setOffenseName(String offenseName) {
    this.offenseName = offenseName;
  }

  public String getOffenseGroup() {
    return offenseGroup;
  }

  public void setOffenseGroup(String offenseGroup) {
    this.offenseGroup = offenseGroup;
  }

  public String getOffenseCategory() {
    return offenseCategory;
  }

  public void setOffenseCategory(String offenseCategory) {
    this.offenseCategory = offenseCategory;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getMcpp() {
    return mcpp;
  }

  public void setMcpp(String mcpp) {
    this.mcpp = mcpp;
  }
}
