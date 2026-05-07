package com.araujo.assetrans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.araujo.assetrans.model.Documentation;

public interface DocumentationRepository extends JpaRepository<Documentation, Long> {
}