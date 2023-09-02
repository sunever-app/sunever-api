package com.jovicsantos.suneverapi.infrastructure.repository;

import com.jovicsantos.suneverapi.infrastructure.db.entity.MeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MeasurementRepository extends JpaRepository<MeasurementEntity, UUID> {
	boolean existsByName(String name);
}
