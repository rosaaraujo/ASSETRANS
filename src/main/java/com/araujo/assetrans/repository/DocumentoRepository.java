package com.araujo.assetrans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.araujo.assetrans.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}