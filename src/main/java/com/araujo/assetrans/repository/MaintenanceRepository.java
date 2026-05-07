package com.araujo.assetrans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.araujo.assetrans.model.Maintenance;

public interface MaintenanceRepository extends JpaRepository<Maintenance, Long> {
}