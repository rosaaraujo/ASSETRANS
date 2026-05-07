# ASSETRANS - Gestión de Activos de Transporte

## Historia de Fases

### Fase 1: Base Arquitectura
- Fecha de implementación: Fase inicial
- Stack: Spring Boot 3 + Thymeleaf + Bootstrap 5 + Maven
- Alcance: Esqueleto del proyecto sin clases de dominio/negocio; página home estática renderizada por Thymeleaf; estructura de paquetes base com.araujo.assetrans.*; pom.xml único; CSS base con variables CSS (verde/negro sobre fondo blanco).
- Entregables:
  - pom.xml
  - src/main/resources/templates/index.html
  - src/main/resources/static/css/styles.css
  - src/main/java/com/araujo/assetrans/.gitkeep
  - docs/AGENTS.md

### Fase 2: Capa de Presentación y Esqueleto Spring Boot
- Fecha de implementación: Segunda fase
- Stack: Spring Boot 3 + Thymeleaf + Bootstrap 5 + Maven
- Alcance: Clase principal con @SpringBootApplication y HomeController para servir la página home en la ruta raíz "/"; mantener intacta la Fase 1 y preparar la app para ejecutarse como jar.
- Entregables:
  - src/main/java/com/araujo/assetrans/AssetransApplication.java
  - src/main/java/com/araujo/assetrans/HomeController.java
- Restricciones: No modificar archivos de la Fase 1; no introducir lógica de negocio ni entidades.

### Fase 3: Modelo y ORM Inicial
- Fecha de implementación: Tercera fase
- Stack: Spring Boot 3 + JPA/Hibernate + Spring Data JPA + H2 (en memoria)
- Alcance: Entidades JPA básicas (AssetType, Asset) y repositorios Spring Data JPA; configuración mínima de data source; sin conexión real a PostgreSQL.
- Entregables:
  - src/main/java/com/araujo/assetrans/model/AssetType.java
  - src/main/java/com/araujo/assetrans/model/Asset.java
  - src/main/java/com/araujo/assetrans/repository/AssetTypeRepository.java
  - src/main/java/com/araujo/assetrans/repository/AssetRepository.java
  - src/main/resources/application.properties
- Propiedades añadidas:
  - AssetType: id, name, description, codigo
  - Asset: id, name, serialNumber, codigo, type (relación ManyToOne con AssetType)
- Dependencias añadidas en pom.xml:
  - spring-boot-starter-data-jpa

### Fase 4: Gestión de Documentación y Mantenimientos
- Fecha de implementación: Cuarta fase
- Stack: Spring Boot 3 + JPA/Hibernate + Spring Data JPA + H2 (en memoria)
- Alcance: Entidades Documentation y Maintenance asociadas a activos; repositorios Spring Data JPA; configuración mínima de relaciones entre entidades.
- Entregables:
  - src/main/java/com/araujo/assetrans/model/Documentation.java
  - src/main/java/com/araujo/assetrans/model/Maintenance.java
  - src/main/java/com/aurojo/assetrans/repository/DocumentationRepository.java
  - src/main/java/com/araujo/assetrans/repository/MaintenanceRepository.java
- Propiedades Documentation:
  - id, name, documentType, filePath, issueDate, asset (ManyToOne)
- Propiedades Maintenance:
  - id, description, maintenanceType, startDate, endDate, status, asset (ManyToOne)
- Restricciones: No modificar archivos de las fases anteriores; no implementar servicios ni lógica de negocio.

## Propósito de este AGENTS.md
- Servir como guía de ejecución para todas las fases y como plantilla para fases futuras.
- Instrucciones para IA y para quien aplique los patches en el repositorio.
- Mantener trazabilidad de los cambios realizados en cada fase.

## Skills del Proyecto
- **Spring Boot Developer**: `skills/spring-boot/SKILL.md`
  - Skill para desarrollo Spring Boot 3 en ASSETRANS
  - Incluye patrones de código, convenciones y ejemplos específicos del dominio
  - Referencia: `skills/spring-boot/references/conventions.md` y `skills/spring-boot/references/domain-models.md`
  - La IA debe consultar esta skill al trabajar con código Spring Boot del proyecto

## Stack Técnico del Proyecto
- Framework: Spring Boot 3
- Plantillas: Thymeleaf
- Frontend: Bootstrap 5 + Vanilla JS
- Build: Maven
- ORM: JPA/Hibernate (Jakarta Persistence)
- Base de datos temporal: H2 (en memoria)
- Java: 17+ (compatible con Spring Boot 3)

## Estructura de Paquetes
- com.araujo.assetrans.* (raíz)
  - model/ (entidades JPA)
  - repository/ (repositorios Spring Data JPA)
  - controller/ (controladores)
  - service/ (servicios - fases posteriores)
  - config/ (configuración - fases posteriores)

## Convenciones de Código
- Paquetes: minúsculas, separados por puntos
- Clases: PascalCase
- Métodos: camelCase
- Propiedades de entidades: camelCase con anotaciones Jakarta Persistence
- Rutas de recursos estáticos: /css/, /js/, /images/

## Notas de IA y Ejecución
- Cada fase debe entregarse como un patch aplicable sin conflictos.
- No generar clases de negocio, repositorios o lógica de negocio fuera de la fase correspondiente.
- Verificar compilación con mvn -DskipTests package.
- Mantener ASCII en los archivos; evitar caracteres especiales fuera de los usados en el repo.
- Actualizar este AGENTS.md al final de cada fase con los cambios realizados.

## Guía de Uso de IA (resumen)
- Mantener ASCII; evitar caracteres especiales fuera de los usados en el repo.
- Verificar compilación con mvn -DskipTests package.
- Verificar que index.html se sirve desde /templates y que CSS se carga desde /css/styles.css.
- Usar Jakarta Persistence (jakarta.persistence.*) en lugar de javax.persistence para Spring Boot 3.
- Mantener consistencia en nombres de paquetes, rutas y convenciones.
