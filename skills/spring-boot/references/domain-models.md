# Modelos del Dominio ASSETRANS

## Esquema de Entidades

### AssetType - Tipo de Activo

**Propiedades:**
| Campo | Tipo | Anotaciones | Descripción |
|-------|------|-------------|-------------|
| id | Long | @Id, @GeneratedValue | PK autoincremental |
| name | String | @Column(nullable=false) | Nombre del tipo |
| description | String | @Column | Descripción opcional |
| codigo | String | @Column(name="codigo") | Código identificador |

**Relaciones:**
- OneToMany con Asset (un AssetType puede tener muchos Assets)

**Ejemplo:**
```java
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

    // Getters y Setters
}
```

---

### Asset - Activo

**Propiedades:**
| Campo | Tipo | Anotaciones | Descripción |
|-------|------|-------------|-------------|
| id | Long | @Id, @GeneratedValue | PK autoincremental |
| name | String | @Column(nullable=false) | Nombre del activo |
| serialNumber | String | @Column(name="serial_number") | Número de serie |
| codigo | String | @Column(name="codigo") | Código identificador |
| type | AssetType | @ManyToOne, @JoinColumn | Tipo de activo |

**Relaciones:**
- ManyToOne con AssetType
- OneToMany con Documentation
- OneToMany con Maintenance

**Ejemplo:**
```java
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

    @ManyToOne
    @JoinColumn(name = "asset_type_id")
    private AssetType type;

    // Getters y Setters
}
```

---

### Documentation - Documentación

**Propiedades:**
| Campo | Tipo | Anotaciones | Descripción |
|-------|------|-------------|-------------|
| id | Long | @Id, @GeneratedValue | PK autoincremental |
| name | String | @Column(nullable=false) | Nombre del documento |
| documentType | String | @Column(name="document_type") | Tipo: factura, seguro, permiso |
| filePath | String | @Column(name="file_path") | Ruta del archivo |
| issueDate | LocalDate | @Column(name="issue_date") | Fecha de emisión |
| asset | Asset | @ManyToOne, @JoinColumn | Activo asociado |

**Relaciones:**
- ManyToOne con Asset (cada documento pertenece a un activo)

**Ejemplo:**
```java
@Entity
@Table(name = "documentation")
public class Documentation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "document_type")
    private String documentType;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    // Getters y Setters
}
```

---

### Maintenance - Mantenimiento

**Propiedades:**
| Campo | Tipo | Anotaciones | Descripción |
|-------|------|-------------|-------------|
| id | Long | @Id, @GeneratedValue | PK autoincremental |
| description | String | @Column(nullable=false) | Descripción del mantenimiento |
| maintenanceType | String | @Column(name="maintenance_type") | Tipo: preventivo, correctivo |
| startDate | LocalDate | @Column(name="start_date") | Fecha de inicio |
| endDate | LocalDate | @Column(name="end_date") | Fecha de fin (nullable) |
| status | String | @Column | Estado: pendiente, en_progreso, completado, cancelado |
| asset | Asset | @ManyToOne, @JoinColumn | Activo asociado |

**Valores posibles de status:**
- `pendiente`
- `en_progreso`
- `completado`
- `cancelado`

**Valores posibles de maintenanceType:**
- `preventivo`
- `correctivo`
- `predictivo`
- `inspeccion`

**Ejemplo:**
```java
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

    // Getters y Setters
}
```

---

## Diagrama de Relaciones

```
┌─────────────────┐       ┌─────────────────┐
│   AssetType     │       │     Asset       │
├─────────────────┤       ├─────────────────┤
│ id (PK)         │       │ id (PK)         │
│ name            │◄──────│ type_id (FK)    │
│ description     │ 1:N   │ name            │
│ codigo          │       │ serialNumber    │
└─────────────────┘       │ codigo          │
                          └────────┬────────┘
                                   │
                    ┌──────────────┴──────────────┐
                    │                             │
                    ▼                             ▼
          ┌─────────────────┐          ┌─────────────────┐
          │  Documentation  │          │   Maintenance  │
          ├─────────────────┤          ├─────────────────┤
          │ id (PK)         │          │ id (PK)         │
          │ asset_id (FK)   │          │ asset_id (FK)  │
          │ name            │          │ description     │
          │ documentType   │          │ maintenanceType│
          │ filePath       │          │ startDate       │
          │ issueDate      │          │ endDate         │
          └─────────────────┘          │ status          │
                                      └─────────────────┘
```

## Repositorios Asociados

| Entidad | Repositorio |
|---------|--------------|
| AssetType | AssetTypeRepository extends JpaRepository<AssetType, Long> |
| Asset | AssetRepository extends JpaRepository<Asset, Long> |
| Documentation | DocumentationRepository extends JpaRepository<Documentation, Long> |
| Maintenance | MaintenanceRepository extends JpaRepository<Maintenance, Long> |