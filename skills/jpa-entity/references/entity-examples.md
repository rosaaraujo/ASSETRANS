# Ejemplos de Entidades JPA - ASSETRANS

## Tabla de Entidades

| Entidad Anterior | Entidad Nueva (Español) | Tabla DB |
|------------------|------------------------|----------|
| AssetType | TipoActivo | tipo_activo |
| Asset | Activo | activo |
| Documentation | Documento | documento |
| Maintenance | Mantenimiento | mantenimiento |

## TipoActivo - Ejemplo Completo

**Ubicación:** `src/main/java/com/araujo/assetrans/model/TipoActivo.java`

```java
package com.araujo.assetrans.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_activo")
public class TipoActivo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    private String descripcion;
    
    @Column(name = "codigo")
    private String codigo;
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
}
```

## Activo - Ejemplo Completo

**Ubicación:** `src/main/java/com/araujo/assetrans/model/Activo.java`

```java
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
    
    // Getters y Setters
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
```

## Documento - Ejemplo Completo

**Ubicación:** `src/main/java/com/araujo/assetrans/model/Documento.java`

```java
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
    
    // Getters y Setters
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
```

## Mantenimiento - Ejemplo Completo

**Ubicación:** `src/main/java/com/araujo/assetrans/model/Mantenimiento.java`

```java
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
    
    // Getters y Setters
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
```

## Guía de Conversión (Inglés → Español)

| Término Inglés | Término Español |
|----------------|-----------------|
| AssetType | TipoActivo |
| Asset | Activo |
| Documentation | Documento |
| Maintenance | Mantenimiento |
| name | nombre |
| description | descripcion |
| code/codigo | codigo |
| serialNumber | numeroSerie |
| documentType | tipoDocumento |
| filePath | rutaArchivo |
| issueDate | fechaEmision |
| maintenanceType | tipoMantenimiento |
| startDate | fechaInicio |
| endDate | fechaFin |
| status | estado |
| type | tipo (para relaciones) |

## Patrón de Nombre de Tabla

- Convertir CamelCase a snake_case
- Usar español
- Ejemplos: `tipo_activo`, `activo`, `documento`, `mantenimiento`