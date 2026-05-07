---
name: spring-boot-assetrans
description: |
  Desarrollo de aplicaciones Spring Boot 3 para el proyecto ASSETRANS.
  Utiliza esta skill cuando el usuario necesite crear, modificar o extender código Spring Boot
  en el proyecto ASSETRANS (Asset Transport Management), incluyendo:
  - Entidades JPA con Jakarta Persistence
  - Repositorios Spring Data JPA
  - Controllers REST o MVC
  - Servicios y configuración
  - Actualización de archivos de configuración (application.properties, application.yml)
  Esta skill incluye patrones específicos del proyecto como las entidades Asset, AssetType,
  Maintenance y Documentation, usando la convención de paquetes com.araujo.assetrans.*.
---

# Skill: Spring Boot Developer para ASSETRANS

Esta skill proporciona orientación para el desarrollo de aplicaciones Spring Boot 3
en el proyecto ASSETRANS, incluyendo patrones de código, convenciones y ejemplos específicos
del dominio de gestión de activos de transporte.

## Cuándo usar esta skill

- Crear nuevas entidades JPA
- Crear repositorios Spring Data
- Crear controllers REST o MVC
- Crear servicios
- Modificar configuración de la aplicación
- Trabajar con el stack Spring Boot 3 + Thymeleaf + JPA/Hibernate

## Convenciones del Proyecto ASSETRANS

### Estructura de paquetes
```
com.araujo.assetrans/
├── model/          (entidades JPA)
├── repository/     (Spring Data JPA repositories)
├── controller/     (REST/MVC controllers)
├── service/        (servicios de negocio)
├── config/         (configuración de Spring)
```

### Nomenclatura
- **Paquetes**: minúsculas, separados por puntos
- **Clases**: PascalCase (ej: AssetType, AssetRepository)
- **Métodos**: camelCase (ej: findByName, saveAsset)
- **Propiedades**: camelCase (ej: serialNumber, codigo)

### Persistencia
- Usar **Jakarta Persistence** (`jakarta.persistence.*`) - NO `javax.persistence`
- Spring Boot 3 requiere Jakarta EE 9+
- Anotaciones: @Entity, @Table, @Id, @GeneratedValue, @Column, @ManyToOne, @OneToMany

### Configuration
- Archivos en: `src/main/resources/`
- application.properties o application.yml
- Propiedades de JPA: spring.jpa.hibernate.ddl-auto, spring.datasource.*

## Patrones de Código

### Entidad JPA básica

```java
package com.araujo.assetrans.model;

import jakarta.persistence.*;

@Entity
@Table(name = "nombre_tabla")
public class NombreEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    // Getters y Setters
}
```

### Entidad con relaciones

```java
// Relación ManyToOne
@ManyToOne
@JoinColumn(name = "foreign_key_column")
private TipoEntidad relacion;

// Relación OneToMany (en la otra entidad)
@OneToMany(mappedBy = "propiedad_inversa")
private Set<ChildEntity> hijos;
```

### Repositorio Spring Data

```java
package com.araujo.assetrans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.araujo.assetrans.model.Entidad;

public interface EntidadRepository extends JpaRepository<Entidad, Long> {
    // Métodos de consulta自定义
    Optional<Entidad> findByNombre(String nombre);
}
```

### Controller REST básico

```java
package com.araujo.assetrans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entidades")
public class EntidadController {

    @Autowired
    private EntidadService service;

    @GetMapping
    public List<Entidad> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entidad> obtenerPorId(@PathVariable Long id) {
        return service.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Entidad crear(@RequestBody Entidad entidad) {
        return service.save(entidad);
    }
}
```

## Entidades del Dominio ASSETRANS

### AssetType (Tipo de Activo)
- id: Long (PK)
- name: String (nombre del tipo)
- description: String (descripción opcional)
- codigo: String (código identificador)

### Asset (Activo)
- id: Long (PK)
- name: String (nombre del activo)
- serialNumber: String (número de serie)
- codigo: String (código identificador)
- type: AssetType (relación ManyToOne)

### Documentation (Documentación)
- id: Long (PK)
- name: String (nombre del documento)
- documentType: String (tipo: factura, seguro, permiso, etc.)
- filePath: String (ruta del archivo)
- issueDate: LocalDate (fecha de emisión)
- asset: Asset (relación ManyToOne)

### Maintenance (Mantenimiento)
- id: Long (PK)
- description: String (descripción del mantenimiento)
- maintenanceType: String (tipo: preventivo, correctivo, etc.)
- startDate: LocalDate (fecha de inicio)
- endDate: LocalDate (fecha de fin, nullable)
- status: String (estado: pendiente, en progreso, completado, cancelado)
- asset: Asset (relación ManyToOne)

## Configuración de Application

### application.properties ejemplo

```properties
# Server
server.port=8080

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect

# Datasource (H2 en memoria para desarrollo)
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true

# Thymeleaf
spring.thymeleaf.cache=false
```

## Recursos de Referencia

Para más detalles sobre convenciones específicas del proyecto, consulta:
- `skills/spring-boot/references/conventions.md`
- `skills/spring-boot/references/domain-models.md`

## Notas importantes

1. **Siempre usar Jakarta Persistence** - No usar javax.persistence
2. **Seguir la estructura de paquetes** - model, repository, controller, service, config
3. **Usar getters/setters** - No usar Lombok en este proyecto (por decisión de diseño)
4. **Anotaciones JPA correctas** - @GeneratedValue(strategy = GenerationType.IDENTITY)
5. **Fechas con LocalDate** - Para campos de fecha, usar java.time.LocalDate