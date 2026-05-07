package com.araujo.assetrans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.araujo.assetrans.model.TipoActivo;

public interface TipoActivoRepository extends JpaRepository<TipoActivo, Long> {
}