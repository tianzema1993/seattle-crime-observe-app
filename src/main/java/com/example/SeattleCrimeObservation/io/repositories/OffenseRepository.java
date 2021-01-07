package com.example.SeattleCrimeObservation.io.repositories;

import com.example.SeattleCrimeObservation.io.entity.OffenseEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OffenseRepository extends CrudRepository<OffenseEntity, Long> {
  @Query(value="select count(*) from CrimeDetails where OffenseName = :offenseName and Date like %:date% and Mcpp = :mcpp", nativeQuery = true)
  int findCountByOffenseNameAndMcpp(@Param("offenseName") String offenseName, @Param("date") String date, @Param("mcpp") String mcpp);

  @Query(value="select count(*) from CrimeDetails where OffenseName = :offenseName and Date like %:date% and ZipCode = :zipCode", nativeQuery = true)
  int findCountByOffenseNameAndZipCode(@Param("offenseName") String offenseName, @Param("date") String date, @Param("zipCode") String zipCode);

  @Query(value="select count(*) from CrimeDetails where OffenseGroup = :offenseGroup and Date like %:date% and Mcpp = :mcpp", nativeQuery = true)
  int findCountByOffenseGroupAndMcpp(@Param("offenseGroup") String offenseGroup, @Param("date") String date, @Param("mcpp") String mcpp);

  @Query(value="select count(*) from CrimeDetails where OffenseGroup = :offenseGroup and Date like %:date% and ZipCode = :zipCode", nativeQuery = true)
  int findCountByOffenseGroupAndZipCode(@Param("offenseGroup") String offenseGroup, @Param("date") String date, @Param("zipCode") String zipCode);

  @Query(value="select count(*) from CrimeDetails where OffenseCategory = :offenseCategory and Date like %:date% and Mcpp = :mcpp", nativeQuery = true)
  int findCountByOffenseCategoryAndMcpp(@Param("offenseCategory") String offenseCategory, @Param("date") String date, @Param("mcpp") String mcpp);

  @Query(value="select count(*) from CrimeDetails where OffenseCategory = :offenseCategory and Date like %:date% and ZipCode = :zipCode", nativeQuery = true)
  int findCountByOffenseCategoryAndZipCode(@Param("offenseCategory") String offenseCategory, @Param("date") String date, @Param("zipCode") String zipCode);
}
