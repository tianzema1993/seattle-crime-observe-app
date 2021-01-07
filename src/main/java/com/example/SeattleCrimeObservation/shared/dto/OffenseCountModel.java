package com.example.SeattleCrimeObservation.shared.dto;

public class OffenseCountModel {

  private String offenseName;
  private int count = 0;

  public String getOffenseName() {
    return offenseName;
  }

  public void setOffenseName(String offenseName) {
    this.offenseName = offenseName;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
