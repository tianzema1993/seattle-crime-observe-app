package com.example.SeattleCrimeObservation.service;

import com.example.SeattleCrimeObservation.shared.dto.OffenseDto;
import java.util.List;

public interface OffenseService {
  List<OffenseDto> createEmptyOffenseDtos(String startDate, String endDate, String offenseType, String locationType, List<String> offenseNames, String locationData);
  void updateOffenseModels(List<OffenseDto> offenseDtos);
}
