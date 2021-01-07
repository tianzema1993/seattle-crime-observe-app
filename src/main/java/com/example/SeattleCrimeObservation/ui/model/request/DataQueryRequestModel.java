package com.example.SeattleCrimeObservation.ui.model.request;

import java.util.List;

public class DataQueryRequestModel {

  private String offenseType;
  private String locationType;
  private String startDate;
  private String endDate;
  private List<String> offenseNames;
  private String locationData;

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

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public List<String> getOffenseNames() {
    return offenseNames;
  }

  public void setOffenseNames(List<String> offenseNames) {
    this.offenseNames = offenseNames;
  }

  public String getLocationData() {
    return locationData;
  }

  public void setLocationData(String locationData) {
    this.locationData = locationData;
  }
}
