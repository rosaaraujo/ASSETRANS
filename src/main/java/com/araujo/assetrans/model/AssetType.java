package com.araujo.assetrans.model;

import jakarta.persistence.*;

@Entity
@Table(name = "asset_type")
public class AssetType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  private String description;

  @Column(name = "codigo")
  private String codigo;

  public String getCodigo() { return codigo; }
  public void setCodigo(String codigo) { this.codigo = codigo; }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
}
