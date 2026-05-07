# Convenciones del Proyecto ASSETRANS

## Estructura de Paquetes

```
src/main/java/com/araujo/assetrans/
├── model/              (entidades JPA)
│   ├── Asset.java
│   ├── AssetType.java
│   ├── Documentation.java
│   └── Maintenance.java
├── repository/         (Spring Data JPA)
│   ├── AssetRepository.java
│   ├── AssetTypeRepository.java
│   ├── DocumentationRepository.java
│   └── MaintenanceRepository.java
├── controller/         (REST/MVC - fases posteriores)
├── service/           (servicios - fases posteriores)
└── config/            (configuración - fases posteriores)
```

## Nomenclatura de Clases

### Entidades
- Nombre de tabla en DB: snake_case (asset_type, asset, documentation, maintenance)
- Clase Java: PascalCase (AssetType, Asset, Documentation, Maintenance)
- Archivo: Mismo nombre que clase + .java

### Repositorios
- Nombre: EntidadRepository
- Ejemplo: AssetRepository, AssetTypeRepository
- Extienden: JpaRepository<Entidad, Long>

### Controllers
- Nombre: EntidadController
- Prefijo URL: /api/entidades (REST)
- Anotaciones: @RestController, @RequestMapping, @GetMapping, @PostMapping, etc.

## Estándares de Código

### Propiedades de Entidad
```java
// Correcto
private String name;
private String serialNumber;
private String codigo;

// Evitar
private String nombre;
private String numeroSerie;
private String codigoActivo;
```

### Getters y Setters
```java
// Formato estándar
public Long getId() { return id; }
public void setId(Long id) { this.id = id; }

public String getName() { return name; }
public void setName(String name) { this.name = name; }
```

### Anotaciones JPA

```java
// Entidad básica
@Entity
@Table(name = "nombre_tabla")

// Primary Key
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

// Columnas
@Column(nullable = false)
@Column(name = "nombre_columna")

// Relaciones
@ManyToOne
@JoinColumn(name = "foreign_key")
@OneToMany(mappedBy = "propiedad_inversa")
```

## Application Properties

Ubicación: `src/main/resources/application.properties`

Propiedades principales:
- `server.port` - Puerto del servidor
- `spring.jpa.hibernate.ddl-auto` - Auto creación de tablas
- `spring.datasource.*` - Configuración de BD
- `spring.thymeleaf.*` - Configuración de Thymeleaf

## Reglas Generales

1. **Sin Lombok** - No usar anotaciones @Data, @Getter, @Setter
2. **Jakarta Persistence** - Usar jakarta.persistence.* (no javax)
3. **Fechas con LocalDate** - Para campos de fecha, usar java.time.LocalDate
4. **Inyección por constructor oAutowired** - Preferir constructor para dependencies
5. **Responses estándar** - Usar ResponseEntity para endpoints REST

## Patrón de Capas

```
Controller → Service → Repository → Model
```

- **Controller**: Maneja HTTP requests/responses
- **Service**: Lógica de negocio
- **Repository**: Acceso a datos (Spring Data JPA)
- **Model**: Entidades JPA