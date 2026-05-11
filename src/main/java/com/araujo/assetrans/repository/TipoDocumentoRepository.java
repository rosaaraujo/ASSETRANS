package com.araujo.assetrans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.araujo.assetrans.model.TipoDocumento;
import java.util.List;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumento, Long> {
    List<TipoDocumento> findByTipoActivoId(Long tipoActivoId);
}