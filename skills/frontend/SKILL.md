---
name: frontend-assetrans
description: |
  Desarrollar interfaces de usuario para ASSETRANS usando Thymeleaf y Bootstrap 5.
  Usa esta skill al crear o modificar plantillas HTML, formularios, tablas, navegación, o cualquier componente visual.
  Incluye uso correcto de variables CSS para colores verde/negro sobre fondo blanco.
  Proporciona patrones, ejemplos y buenas prácticas específicas para el proyecto ASSETRANS.
---

# Skill: Frontend Developer para ASSETRANS

Esta skill guía el desarrollo frontend del proyecto ASSETRANS usando Thymeleaf y Bootstrap 5,
con un diseño minimalista profesional (fondo blanco, colores verde y negro).

## Cuándo usar esta skill

- Crear nuevas páginas HTML con Thymeleaf
- Crear o modificar formularios
- Crear tablas con datos dinámicos
- Implementar navegación (navbar)
- Añadir mensajes de alerta o feedback
- Integrar CSS personalizado
- Trabajar con fragmentos y layouts

## Diseño y Estilo

### Variables CSS del Proyecto

El proyecto usa las siguientes variables CSS (definidas en `styles.css`):

```css
:root {
  --green: #0a6b2a;      /* Verde principal */
  --black: #111111;      /* Negro para textos */
  --white: #ffffff;      /* Fondo blanco */
}
```

### Reglas de diseño

1. **Fondo**: Siempre blanco (`background: #fff`)
2. **Textos**: Color negro (`color: var(--black)`)
3. **Elementos destacados**: Verde (`color: var(--green)`)
4. **UI minimalista**: Espacios limpios, sin excesos

## Estructura de Plantilla Thymeleaf

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Título de la Página</title>
    
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- CSS personalizado -->
    <link rel="stylesheet" th:href="@{/css/styles.css}">
</head>
<body class="bg-white">
    <!-- Contenido aquí -->
    
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```

## Pautas de Thymeleaf

### Atributos Thymeleaf más usados

| Atributo | Uso | Ejemplo |
|----------|-----|---------|
| `th:text` | Insertar texto | `<span th:text="${variable}">` |
| `th:href` | Enlaces | `<a th:href="@{/ruta}">` |
| `th:src` | Imágenes | `<img th:src="@{/img/logo.png}">` |
| `th:each` | Iterar | `<tr th:each="item : ${lista}">` |
| `th:if` | Condicional | `<div th:if="${condicion}">` |
| `th:field` | Formularios | `<input th:field="*{campo}">` |
| `th:object` | Objeto formulario | `<form th:object="${objeto}">` |

### Ejemplo: Iterar sobre una lista

```html
<table class="table table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Código</th>
            <th>Acciones</th>
        </tr>
    </thead>
    <tbody>
        <tr th:each="activo : ${listaActivos}">
            <td th:text="${activo.id}">1</td>
            <td th:text="${activo.nombre}">Camión</td>
            <td th:text="${activo.codigo}">CAM-001</td>
            <td>
                <a th:href="@{/activos/editar/{id}(id=${activo.id})}" class="btn btn-sm btn-primary">Editar</a>
            </td>
        </tr>
    </tbody>
</table>
```

### Ejemplo: Formulario

```html
<form th:action="@{/activos/guardar}" th:object="${activo}" method="post">
    <div class="mb-3">
        <label for="nombre" class="form-label">Nombre</label>
        <input type="text" class="form-control" id="nombre" th:field="*{nombre}" required>
    </div>
    
    <div class="mb-3">
        <label for="codigo" class="form-label">Código</label>
        <input type="text" class="form-control" id="codigo" th:field="*{codigo}">
    </div>
    
    <div class="mb-3">
        <label for="tipo" class="form-label">Tipo de Activo</label>
        <select class="form-select" id="tipo" th:field="*{tipo.id}">
            <option th:each="tipo : ${listaTipos}" 
                    th:value="${tipo.id}" 
                    th:text="${tipo.nombre}">Tipo</option>
        </select>
    </div>
    
    <button type="submit" class="btn btn-success">Guardar</button>
    <a th:href="@{/activos}" class="btn btn-secondary">Cancelar</a>
</form>
```

## Componentes Bootstrap Recomendados

### Navbar (Navegación)

```html
<nav class="navbar navbar-expand-lg navbar-light bg-white border-bottom">
    <div class="container">
        <a class="navbar-brand" th:href="@{/}">
            <span class="text-success fw-bold">ASSETRANS</span>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" 
                data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" th:href="@{/activos}">Activos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" th:href="@{/tipos}">Tipos</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" th:href="@{/mantenimientos}">Mantenimientos</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
```

### Tabla (Listados)

```html
<div class="container mt-4">
    <h2 class="mb-3">Listado de Activos</h2>
    <table class="table table-hover table-bordered">
        <thead class="table-light">
            <tr>
                <th>Nombre</th>
                <th>Código</th>
                <th>Tipo</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="activo : ${activos}">
                <td th:text="${activo.nombre}">-</td>
                <td th:text="${activo.codigo}">-</td>
                <td th:text="${activo.tipo.nombre}">-</td>
                <td>
                    <a th:href="@{/activos/ver/{id}(id=${activo.id})}" 
                       class="btn btn-sm btn-outline-primary">Ver</a>
                    <a th:href="@{/activos/editar/{id}(id=${activo.id})}" 
                       class="btn btn-sm btn-outline-secondary">Editar</a>
                </td>
            </tr>
        </tbody>
    </table>
</div>
```

### Alerts (Mensajes)

```html
<!-- Alert de éxito -->
<div th:if="${mensaje}" class="alert alert-success alert-dismissible fade show" role="alert">
    <span th:text="${mensaje}">Operación exitosa</span>
    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
</div>

<!-- Alert de error -->
<div th:if="${error}" class="alert alert-danger alert-dismissible fade show" role="alert">
    <span th:text="${error}">Ha ocurrido un error</span>
    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
</div>
```

### Cards (Información)

```html
<div class="card">
    <div class="card-header bg-success text-white">
        <h5 class="card-title mb-0">Información del Activo</h5>
    </div>
    <div class="card-body">
        <p><strong>Nombre:</strong> <span th:text="${activo.nombre}">-</span></p>
        <p><strong>Código:</strong> <span th:text="${activo.codigo}">-</span></p>
        <p><strong>Tipo:</strong> <span th:text="${activo.tipo.nombre}">-</span></p>
    </div>
</div>
```

### Botones

```html
<!-- Botón primario -->
<a th:href="@{/ruta}" class="btn btn-primary">Acción</a>

<!-- Botón secundario -->
<a th:href="@{/ruta}" class="btn btn-secondary">Cancelar</a>

<!-- Botón success (verde) -->
<button type="submit" class="btn btn-success">Guardar</button>

<!-- Botón danger (rojo) -->
<button type="button" class="btn btn-danger">Eliminar</button>
```

## Ejemplo: Página Completa de Listado

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Activos - ASSETRANS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" th:href="@{/css/styles.css}">
</head>
<body class="bg-white">
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-white border-bottom">
        <div class="container">
            <a class="navbar-brand" th:href="@{/}">
                <span class="text-success fw-bold">ASSETRANS</span>
            </a>
            <div class="navbar-nav">
                <a class="nav-link active" th:href="@{/activos}">Activos</a>
                <a class="nav-link" th:href="@{/tipos}">Tipos</a>
            </div>
        </div>
    </nav>

    <!-- Contenido principal -->
    <div class="container mt-4">
        <div class="d-flex justify-content-between align-items-center mb-3">
            <h2>Listado de Activos</h2>
            <a th:href="@{/activos/nuevo}" class="btn btn-success">Nuevo Activo</a>
        </div>

        <!-- Alert de mensaje -->
        <div th:if="${mensaje}" class="alert alert-success" th:text="${mensaje}"></div>

        <!-- Tabla -->
        <table class="table table-hover table-bordered">
            <thead class="table-light">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Código</th>
                    <th>Tipo</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <tr th:each="activo : ${activos}">
                    <td th:text="${activo.id}">1</td>
                    <td th:text="${activo.nombre}">Camión</td>
                    <td th:text="${activo.codigo}">CAM-001</td>
                    <td th:text="${activo.tipo?.nombre}">Vehículo</td>
                    <td>
                        <a th:href="@{/activos/ver/{id}(id=${activo.id})}" 
                           class="btn btn-sm btn-outline-primary">Ver</a>
                        <a th:href="@{/activos/editar/{id}(id=${activo.id})}" 
                           class="btn btn-sm btn-outline-secondary">Editar</a>
                    </td>
                </tr>
                <tr th:if="${#lists.isEmpty(activos)}">
                    <td colspan="5" class="text-center text-muted">No hay activos registrados</td>
                </tr>
            </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
```

## Recursos de Referencia

Para más ejemplos y detalles, consulta:
- `skills/frontend/references/thymeleaf-patterns.md`
- `skills/frontend/references/bootstrap-components.md`

## Notas Importantes

1. **Siempre usar namespace Thymeleaf**: `xmlns:th="http://www.thymeleaf.org"`
2. **Rutas con @{}**: Usar `th:href="@{/ruta}"` y `th:src="@{/ruta}"`
3. **Formularios con *{}**: Usar `th:field="*{campo}"` con `th:object`
4. **No lógica de negocio**: Las plantillas solo muestran datos, no procesan lógica
5. **CSS del proyecto**: Usar las variables CSS definidas en `styles.css`