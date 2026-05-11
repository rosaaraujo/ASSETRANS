package com.araujo.assetrans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.araujo.assetrans.model.TipoMantenimiento;
import java.util.List;

public interface TipoMantenimientoRepository extends JpaRepository<TipoMantenimiento, Long> {
    List<TipoMantenimiento> findByTipoActivoId(Long tipoActivoId);
}