package com.example.SeattleCrimeObservation.service.impl;

import com.example.SeattleCrimeObservation.io.repositories.OffenseRepository;
import com.example.SeattleCrimeObservation.service.OffenseService;
import com.example.SeattleCrimeObservation.shared.dto.OffenseCountModel;
import com.example.SeattleCrimeObservation.shared.dto.OffenseDto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffenseServiceImpl implements OffenseService {

  @Autowired
  OffenseRepository offenseRepository;

  @Override
  public List<OffenseDto> createEmptyOffenseDtos(String startDate, String endDate,
      String offenseType, String locationType, List<String> offenseNames, String locationData) {
    LocalDate start = LocalDate.parse(startDate);
    LocalDate end = LocalDate.parse(endDate);
    long year = start.until(end, ChronoUnit.YEARS);
    long month = start.until(end, ChronoUnit.MONTHS);
    long day = start.until(end, ChronoUnit.DAYS);
    List<OffenseDto> res = new ArrayList<>();
    if (year > 0) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
      while (start.isBefore(end) || start.isEqual(end)) {
        res.add(createOffenseDto(formatter, start, offenseType, locationType, offenseNames,
            locationData));
        start = start.plusYears(1);
      }
    } else if (month > 0) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
      while (start.isBefore(end) || start.isEqual(end)) {
        res.add(createOffenseDto(formatter, start, offenseType, locationType, offenseNames,
            locationData));
        start = start.plusMonths(1);
      }
    } else {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      while (start.isBefore(end) || start.isEqual(end)) {
        res.add(createOffenseDto(formatter, start, offenseType, locationType, offenseNames,
            locationData));
        start = start.plusDays(1);
      }
    }
    return res;
  }

  private OffenseDto createOffenseDto(DateTimeFormatter formatter, LocalDate date,
      String offenseType, String locationType, List<String> offenseNames, String locationData) {
    OffenseDto offenseDto = new OffenseDto();
    offenseDto.setOffenseType(offenseType);
    offenseDto.setLocationType(locationType);
    offenseDto.setLocationData(locationData);
    offenseDto.setDate(formatter.format(date));
    List<OffenseCountModel> offenseCountModels = new ArrayList<>();
    for (String offenseName : offenseNames) {
      OffenseCountModel offenseCountModel = new OffenseCountModel();
      offenseCountModel.setOffenseName(offenseName);
      offenseCountModels.add(offenseCountModel);
    }
    offenseDto.setOffenseCountModels(offenseCountModels);
    return offenseDto;
  }

  @Override
  public void updateOffenseModels(List<OffenseDto> offenseDtos) {
    for (OffenseDto offenseDto : offenseDtos) {
      String date = offenseDto.getDate();
      String location = offenseDto.getLocationData();
      if (offenseDto.getOffenseType().equals("offenseName")) {
        if (offenseDto.getLocationType().equals("mcpp")) {
          for (OffenseCountModel offenseCountModel : offenseDto.getOffenseCountModels()) {
            String offenseName = offenseCountModel.getOffenseName();
            long count = offenseRepository
                .findCountByOffenseNameAndMcpp(offenseName, date, location);
            offenseCountModel.setCount((int) count);
          }
        } else {
          for (OffenseCountModel offenseCountModel : offenseDto.getOffenseCountModels()) {
            String offenseName = offenseCountModel.getOffenseName();
            int count = offenseRepository
                .findCountByOffenseNameAndZipCode(offenseName, date, location);
            offenseCountModel.setCount(count);
          }
        }
      } else if (offenseDto.getOffenseType().equals("offenseGroup")) {
        if (offenseDto.getLocationType().equals("mcpp")) {
          for (OffenseCountModel offenseCountModel : offenseDto.getOffenseCountModels()) {
            String offenseName = offenseCountModel.getOffenseName();
            int count = offenseRepository
                .findCountByOffenseGroupAndMcpp(offenseName, date, location);
            offenseCountModel.setCount(count);
          }
        } else {
          for (OffenseCountModel offenseCountModel : offenseDto.getOffenseCountModels()) {
            String offenseName = offenseCountModel.getOffenseName();
            int count = offenseRepository
                .findCountByOffenseGroupAndZipCode(offenseName, date, location);
            offenseCountModel.setCount(count);
          }
        }
      } else {
        if (offenseDto.getLocationType().equals("mcpp")) {
          for (OffenseCountModel offenseCountModel : offenseDto.getOffenseCountModels()) {
            String offenseName = offenseCountModel.getOffenseName();
            int count = offenseRepository
                .findCountByOffenseCategoryAndMcpp(offenseName, date, location);
            offenseCountModel.setCount(count);
          }
        } else {
          for (OffenseCountModel offenseCountModel : offenseDto.getOffenseCountModels()) {
            String offenseName = offenseCountModel.getOffenseName();
            int count = offenseRepository
                .findCountByOffenseCategoryAndZipCode(offenseName, date, location);
            offenseCountModel.setCount(count);
          }
        }
      }
    }
  }
}
