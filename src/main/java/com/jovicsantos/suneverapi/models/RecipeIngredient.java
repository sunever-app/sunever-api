package com.jovicsantos.suneverapi.models;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "recipe_ingredient")
public class RecipeIngredient implements Serializable {
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  @JsonIgnore
  private RecipeIngredientPK id;

  @ManyToOne
  @MapsId("recipe_id")
  @JoinColumn(name = "recipe_id")
  @JsonIgnore
  private Recipe recipe;

  @ManyToOne
  @MapsId("ingredient_id")
  @JoinColumn(name = "ingredient_id")
  private Ingredient ingredient;

  @Column(nullable = false, precision = 10, scale = 2)
  private BigDecimal quantity;
}
