# ASSETRANS - Phase 1: Base Arquitectura

Contexto
- Proyecto: ASSETRANS (Asset Transport Management)
- Stack de la Fase 1: Spring Boot 3 + Thymeleaf + Bootstrap 5 + Maven
- Alcance: esqueleto del proyecto sin dominio/negocio; página home estática; estructura de carpetas; pom.xml único; CSS base; docs/AGENTS.md; paquete base com.araujo.assetrans.*
- Entregables: pom.xml; index.html; styles.css; estructura de paquetes; docs/AGENTS.md
- Restricciones: salida como patch aplicable; no tocar código de negocio.
- Idioma: español

Propósito de este AGENTS.md
- Servir como guía de ejecución para la Fase 1 y como plantilla para fases futuras.
- Instrucciones para IA y para quien aplique el patch en el repositorio.

Estructura de entregables de la Fase 1
- pom.xml
- src/main/resources/templates/index.html
- src/main/resources/static/css/styles.css
- src/main/java/com/araujo/assetrans/.gitkeep
- docs/AGENTS.md (este archivo)

Notas de IA y ejecución
- No generar clases de dominio, repositorios o lógica de negocio en esta fase.
- El patch debe contener solo archivos descritos aquí.
- Una vez aplicado el patch, la app debe estar preparada para evolucionar en Fase 2 con Main y HomeController.

Guía de uso de IA (resumen)
- Mantener ASCII; evitar caracteres especiales fuera de los usados en el repo.
- Verificar compilación con mvn -DskipTests package.
- Verificar que index.html se sirve desde /templates y que CSS se carga desde /css/styles.css.
