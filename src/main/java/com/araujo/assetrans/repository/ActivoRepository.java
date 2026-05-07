package com.araujo.assetrans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.araujo.assetrans.model.Activo;

public interface ActivoRepository extends JpaRepository<Activo, Long> {
}