package com.jovicsantos.suneverapi.domain;

import java.math.BigDecimal;
import java.util.UUID;

public record Ingredient(UUID id, String name, BigDecimal price, BigDecimal quantityPerMeasure,
												 Measurement measurement) {
}
