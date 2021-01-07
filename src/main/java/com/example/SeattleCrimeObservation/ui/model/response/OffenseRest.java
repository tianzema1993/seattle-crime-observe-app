package com.example.SeattleCrimeObservation.ui.model.response;

import com.example.SeattleCrimeObservation.shared.dto.OffenseCountModel;
import java.util.List;

public class OffenseRest {

  private String date;
  private List<OffenseCountModel> offenseCountModels;

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
}
