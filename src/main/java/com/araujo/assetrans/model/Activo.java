package com.araujo.assetrans.model;

import jakarta.persistence.*;

@Entity
@Table(name = "activo")
public class Activo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nombre;

  @Column(name = "numero_serie")
  private String numeroSerie;

  @Column(name = "codigo")
  private String codigo;

  @ManyToOne
  @JoinColumn(name = "tipo_activo_id")
  private TipoActivo tipo;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }
  public String getNumeroSerie() { return numeroSerie; }
  public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie; }
  public String getCodigo() { return codigo; }
  public void setCodigo(String codigo) { this.codigo = codigo; }
  public TipoActivo getTipo() { return tipo; }
  public void setTipo(TipoActivo tipo) { this.tipo = tipo; }
}