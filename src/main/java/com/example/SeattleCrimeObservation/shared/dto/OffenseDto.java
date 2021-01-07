package com.example.SeattleCrimeObservation.shared.dto;

import java.util.List;

public class OffenseDto {

  String date;
  List<OffenseCountModel> offenseCountModels;
  String offenseType;
  String locationType;
  String locationData;

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public List<OffenseCountModel> getOffenseCountModels() {
    return offenseCountModels;
  }

  public void setOffenseCountModels(
      List<OffenseCountModel> offenseCountModels) {
    this.offenseCountModels = offenseCountModels;
  }

  public String getOffenseType() {
    return offenseType;
  }

  public void setOffenseType(String offenseType) {
    this.offenseType = offenseType;
  }

  public String getLocationType() {
    return locationType;
  }

  public void setLocationType(String locationType) {
    this.locationType = locationType;
  }

  public String getLocationData() {
    return locationData;
  }

  public void setLocationData(String locationData) {
    this.locationData = locationData;
  }
}
