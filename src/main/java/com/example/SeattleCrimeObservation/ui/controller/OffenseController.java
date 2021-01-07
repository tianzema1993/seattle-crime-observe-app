package com.example.SeattleCrimeObservation.ui.controller;

import com.example.SeattleCrimeObservation.service.OffenseService;
import com.example.SeattleCrimeObservation.shared.dto.OffenseDto;
import com.example.SeattleCrimeObservation.ui.model.request.DataQueryRequestModel;
import com.example.SeattleCrimeObservation.ui.model.response.OffenseRest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class OffenseController {

  @Autowired
  OffenseService offenseService;

  @PostMapping("offenses")
  public List<OffenseRest> searchOffenses(@RequestBody DataQueryRequestModel dataQueryRequestModel) {
    List<OffenseRest> res = new ArrayList<>();
    List<OffenseDto> offenseDtos = offenseService
        .createEmptyOffenseDtos(dataQueryRequestModel.getStartDate(),
            dataQueryRequestModel.getEndDate(), dataQueryRequestModel.getOffenseType(),
            dataQueryRequestModel.getLocationType(), dataQueryRequestModel.getOffenseNames(),
            dataQueryRequestModel.getLocationData());
    offenseService.updateOffenseModels(offenseDtos);
    for (OffenseDto offenseDto: offenseDtos) {
      OffenseRest offenseRest = new OffenseRest();
      BeanUtils.copyProperties(offenseDto, offenseRest);
      res.add(offenseRest);
    }
    return res;
  }
}
