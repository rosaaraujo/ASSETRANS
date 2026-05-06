package com.araujo.assetrans.model;

import jakarta.persistence.*;

@Entity
@Table(name = "asset")
public class Asset {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(name = "serial_number")
  private String serialNumber;

  @Column(name = "codigo")
  private String codigo;

  public String getCodigo() { return codigo; }
  public void setCodigo(String codigo) { this.codigo = codigo; }

  @ManyToOne
  @JoinColumn(name = "asset_type_id")
  private AssetType type;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getSerialNumber() { return serialNumber; }
  public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
  public AssetType getType() { return type; }
  public void setType(AssetType type) { this.type = type; }
}
