package com.araujo.assetrans.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.araujo.assetrans.model.AssetType;

public interface AssetTypeRepository extends JpaRepository<AssetType, Long> {}
