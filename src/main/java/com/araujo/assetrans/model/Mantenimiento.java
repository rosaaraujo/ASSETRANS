package com.araujo.assetrans.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String descripcion;

  @Column(name = "tipo_mantenimiento")
  private String tipoMantenimiento;

  @Column(name = "fecha_inicio")
  private LocalDate fechaInicio;

  @Column(name = "fecha_fin")
  private LocalDate fechaFin;

  private String estado;

  @ManyToOne
  @JoinColumn(name = "activo_id")
  private Activo activo;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getDescripcion() { return descripcion; }
  public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
  public String getTipoMantenimiento() { return tipoMantenimiento; }
  public void setTipoMantenimiento(String tipoMantenimiento) { this.tipoMantenimiento = tipoMantenimiento; }
  public LocalDate getFechaInicio() { return fechaInicio; }
  public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
  public LocalDate getFechaFin() { return fechaFin; }
  public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
  public String getEstado() { return estado; }
  public void setEstado(String estado) { this.estado = estado; }
  public Activo getActivo() { return activo; }
  public void setActivo(Activo activo) { this.activo = activo; }
}