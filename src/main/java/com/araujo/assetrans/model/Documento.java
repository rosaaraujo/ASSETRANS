package com.araujo.assetrans.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "documento")
public class Documento {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nombre;

  @Column(name = "tipo_documento")
  private String tipoDocumento;

  @Column(name = "ruta_archivo")
  private String rutaArchivo;

  @Column(name = "fecha_emision")
  private LocalDate fechaEmision;

  @ManyToOne
  @JoinColumn(name = "activo_id")
  private Activo activo;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getNombre() { return nombre; }
  public void setNombre(String nombre) { this.nombre = nombre; }
  public String getTipoDocumento() { return tipoDocumento; }
  public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }
  public String getRutaArchivo() { return rutaArchivo; }
  public void setRutaArchivo(String rutaArchivo) { this.rutaArchivo = rutaArchivo; }
  public LocalDate getFechaEmision() { return fechaEmision; }
  public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }
  public Activo getActivo() { return activo; }
  public void setActivo(Activo activo) { this.activo = activo; }
}