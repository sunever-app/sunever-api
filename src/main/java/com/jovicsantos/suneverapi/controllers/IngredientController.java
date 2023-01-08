package com.jovicsantos.suneverapi.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jovicsantos.suneverapi.dtos.IngredientDto;
import com.jovicsantos.suneverapi.models.Ingredient;
import com.jovicsantos.suneverapi.services.IngredientService;
import com.jovicsantos.suneverapi.services.MeasurementService;

import jakarta.validation.Valid;
import lombok.var;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
  @Autowired
  IngredientService ingredientService;
  @Autowired
  MeasurementService measurementService;

  @PostMapping
  public ResponseEntity<Object> saveIngredient(@RequestBody @Valid IngredientDto ingredientDto) {
    if (ingredientService.existsByName(ingredientDto.name())) {
      return ResponseEntity.status(HttpStatus.CONFLICT)
          .body("Conflict: This ingredient already exists.");
    }

    var ingredientModel = new Ingredient();
    BeanUtils.copyProperties(ingredientDto, ingredientModel);

    var optionalMeasurement = measurementService.findById(ingredientDto.measurement_id());

    if (!optionalMeasurement.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Measurement ID not found.");
    }

    ingredientModel.setMeasurement(optionalMeasurement.get());

    return ResponseEntity.status(HttpStatus.CREATED).body(ingredientService.save(ingredientModel));
  }

  @GetMapping
  public ResponseEntity<Object> getAllIngredients() {
    return ResponseEntity.status(HttpStatus.OK).body(ingredientService.findAll());
  }
}
