package com.araujo.assetrans.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.araujo.assetrans.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {}
