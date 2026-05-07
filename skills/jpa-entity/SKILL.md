---
name: jpa-entity-developer
description: |
  Crear y modificar entidades JPA para ASSETRANS.
  Usa esta skill al crear nuevas entidades JPA, actualizar existentes, o definir relaciones entre entidades.
  IMPORTANTE: Todos los nombres de CLASES y PROPIEDADES deben ser en español según las convenciones del proyecto.
  Ejemplos correctos: TipoActivo (no AssetType), documento (no document), nombre (no name).
  Esta skill proporciona patrones, ejemplos y convenciones específicas para el proyecto ASSETRANS.
---

# Skill: JPA Entity Developer para ASSETRANS

Esta skill guía la creación y modificación de entidades JPA en el proyecto ASSETRANS,
asegurando que todas las clases y propiedades usen nombres en español.

## Cuándo usar esta skill

- Crear nuevas entidades JPA
- Modificar entidades existentes
- Definir relaciones entre entidades (ManyToOne, OneToMany)
- Añadir nuevos campos a entidades
- Crear consultas personalizadas

## REGLA FUNDAMENTAL: Todo en Español

### Nombres de clases
- **Correcto**: `TipoActivo`, `Activo`, `Documento`, `Mantenimiento`
- **Incorrecto**: `AssetType`, `Asset`, `Documentation`, `Maintenance`

### Nombres de propiedades
- **Correcto**: `nombre`, `descripcion`, `codigo`, `tipoDocumento`, `fechaInicio`
- **Incorrecto**: `name`, `description`, `codigo`, `documentType`, `startDate`

### Nombres de tablas en base de datos
- **Correcto**: `tipo_activo`, `activo`, `documento`, `mantenimiento`
- **Incorrecto**: `asset_type`, `asset`, `documentation`, `maintenance`

## Estructura de una Entidad JPA

```java
package com.araujo.assetrans.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "nombre_tabla")
public class NombreClase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;
    private String codigo;
    
    // Para fechas: usar LocalDate
    private LocalDate fecha;
    
    // Getters y Setters
}
```

## Anotaciones JPA

### Básicas
```java
@Entity                 // Marca la clase como entidad
@Table(name = "tabla") // Nombre de la tabla en DB
@Id                    // Primary Key
@GeneratedValue        // Autoincremento
@Column                // Configuración de columna
```

### Relaciones
```java
@ManyToOne             // Muchos a uno (clave foránea)
@JoinColumn(name = "fk") // Columna de la foreign key
@OneToMany(mappedBy = "propiedad") // Uno a muchos
```

## Entidades del Proyecto ASSETRANS

### TipoActivo (antes AssetType)

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

### Activo (antes Asset)

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

### Documento (antes Documentation)

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

### Mantenimiento (antes Maintenance)

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

## Valores de Ejemplo

### Estado de Mantenimiento
- `pendiente`
- `en_progreso`
- `completado`
- `cancelado`

### Tipo de Mantenimiento
- `preventivo`
- `correctivo`
- `predictivo`
- `inspeccion`

### Tipo de Documento
- `factura`
- `seguro`
- `permiso`
- `certificado`
- `otro`

## Repositorios Asociados

```java
package com.araujo.assetrans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.araujo.assetrans.model.TipoActivo;

public interface TipoActivoRepository extends JpaRepository<TipoActivo, Long> {
}

public interface ActivoRepository extends JpaRepository<Activo, Long> {
}

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}

public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {
}
```

## Notas Importantes

1. **SIEMPRE usar español**: Nombres de clases y propiedades en español
2. **Jakarta Persistence**: Usar `jakarta.persistence.*` (no `javax`)
3. **LocalDate para fechas**: Para campos de fecha, usar `java.time.LocalDate`
4. **Getters y Setters**: No usar Lombok, escribir manualmente
5. **Anotación de columna**: Usar `@Column(name = "nombre_columna")` para nombres en snake_case

## Recursos de Referencia

Para más ejemplos y detalles, consulta:
- `skills/jpa-entity/references/entity-examples.md`