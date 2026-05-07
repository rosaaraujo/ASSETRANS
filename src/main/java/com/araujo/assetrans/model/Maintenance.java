package com.araujo.assetrans.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "maintenance")
public class Maintenance {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String description;

  @Column(name = "maintenance_type")
  private String maintenanceType;

  @Column(name = "start_date")
  private LocalDate startDate;

  @Column(name = "end_date")
  private LocalDate endDate;

  private String status;

  @ManyToOne
  @JoinColumn(name = "asset_id")
  private Asset asset;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public String getMaintenanceType() { return maintenanceType; }
  public void setMaintenanceType(String maintenanceType) { this.maintenanceType = maintenanceType; }
  public LocalDate getStartDate() { return startDate; }
  public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
  public LocalDate getEndDate() { return endDate; }
  public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
  public Asset getAsset() { return asset; }
  public void setAsset(Asset asset) { this.asset = asset; }
}