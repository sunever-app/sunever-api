package com.jovicsantos.suneverapi.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public final class Ingredient {
	private UUID id;
	private String name;
	private BigDecimal price;
	private BigDecimal quantityPerMeasure;
	private Measurement measurement;
}
