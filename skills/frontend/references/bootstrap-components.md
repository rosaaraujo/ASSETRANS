# Componentes Bootstrap 5 - ASSETRANS

## Instalación

### CDN (en todas las plantillas)
```html
<!-- CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
```

## Componentes Recomendados

### 1. Navbar (Navegación)

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

**Clases útiles:**
- `navbar-expand-lg` / `navbar-expand-md` / `navbar-expand-sm`
- `navbar-light` / `navbar-dark`
- `fixed-top` / `fixed-bottom` / `sticky-top`

### 2. Tablas

```html
<table class="table table-striped table-hover">
    <thead class="table-light">
        <tr>
            <th>Encabezado</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Contenido</td>
        </tr>
    </tbody>
</table>
```

**Variantes:**
- `table-striped` - Rayas alternas
- `table-hover` - Resaltar al pasar el mouse
- `table-bordered` - Bordes
- `table-borderless` - Sin bordes
- `table-dark` - Fondo oscuro
- `table-light` - Fondo claro

**Colores de filas:**
```html
<tr class="table-success">...</tr>
<tr class="table-danger">...</tr>
<tr class="table-warning">...</tr>
<tr class="table-info">...</tr>
```

### 3. Formularios

```html
<form>
    <div class="mb-3">
        <label for="campo" class="form-label">Etiqueta</label>
        <input type="text" class="form-control" id="campo">
        <div class="form-text">Texto de ayuda</div>
    </div>
    
    <div class="mb-3">
        <label for="seleccion" class="form-label">Selección</label>
        <select class="form-select" id="seleccion">
            <option>Opción 1</option>
            <option>Opción 2</option>
        </select>
    </div>
    
    <div class="mb-3">
        <label for="textarea" class="form-label">Área de texto</label>
        <textarea class="form-control" id="textarea" rows="3"></textarea>
    </div>
    
    <div class="mb-3">
        <div class="form-check">
            <input class="form-check-input" type="checkbox" id="checkbox">
            <label class="form-check-label" for="checkbox">Checkbox</label>
        </div>
    </div>
    
    <div class="mb-3">
        <div class="form-check">
            <input class="form-check-input" type="radio" name="opcion" id="radio1">
            <label class="form-check-label" for="radio1">Opción 1</label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="opcion" id="radio2">
            <label class="form-check-label" for="radio2">Opción 2</label>
        </div>
    </div>
</form>
```

**Estados de input:**
- `is-valid` - Validado correctamente
- `is-invalid` - Error de validación
- `disabled` - Deshabilitado

### 4. Botones

```html
<button type="button" class="btn btn-primary">Primary</button>
<button type="button" class="btn btn-secondary">Secondary</button>
<button type="button" class="btn btn-success">Success</button>
<button type="button" class="btn btn-danger">Danger</button>
<button type="button" class="btn btn-warning">Warning</button>
<button type="button" class="btn btn-info">Info</button>
<button type="button" class="btn btn-light">Light</button>
<button type="button" class="btn btn-dark">Dark</button>
<button type="button" class="btn btn-link">Link</button>
```

**Tamaños:**
```html
<button class="btn btn-primary btn-lg">Large</button>
<button class="btn btn-primary">Default</button>
<button class="btn btn-primary btn-sm">Small</button>
```

**Outline (sin fondo):**
```html
<button class="btn btn-outline-primary">Primary</button>
<button class="btn btn-outline-secondary">Secondary</button>
```

### 5. Cards

```html
<div class="card">
    <div class="card-header">Encabezado</div>
    <div class="card-body">
        <h5 class="card-title">Título</h5>
        <p class="card-text">Contenido de la card.</p>
        <a href="#" class="btn btn-primary">Acción</a>
    </div>
    <div class="card-footer">Pie</div>
</div>
```

**Card con imagen:**
```html
<div class="card" style="width: 18rem;">
    <img src="..." class="card-img-top" alt="...">
    <div class="card-body">
        <h5 class="card-title">Título</h5>
        <p class="card-text">Texto</p>
    </div>
</div>
```

### 6. Alerts

```html
<div class="alert alert-primary" role="alert">
    Alerta primaria
</div>
<div class="alert alert-secondary" role="alert">
    Alerta secundaria
</div>
<div class="alert alert-success" role="alert">
    Alerta de éxito
</div>
<div class="alert alert-danger" role="alert">
    Alerta de peligro
</div>
<div class="alert alert-warning" role="alert">
    Alerta de advertencia
</div>
<div class="alert alert-info" role="alert">
    Alerta informativa
</div>
```

**Con dismiss:**
```html
<div class="alert alert-warning alert-dismissible fade show" role="alert">
    <strong> Atención!</strong> Mensaje.
    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
</div>
```

### 7. Modales

```html
<!-- Botón para abrir -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" 
        data-bs-target="#miModal">
    Abrir modal
</button>

<!-- Modal -->
<div class="modal fade" id="miModal" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Título</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                Contenido
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" 
                        data-bs-dismiss="modal">Cerrar</button>
                <button type="button" class="btn btn-primary">Guardar</button>
            </div>
        </div>
    </div>
</div>
```

### 8. Badges

```html
<span class="badge bg-primary">Primary</span>
<span class="badge bg-success">Success</span>
<span class="badge bg-danger">Danger</span>
<span class="badge bg-warning text-dark">Warning</span>
<span class="badge bg-info text-dark">Info</span>
```

**Badge en botón:**
```html
<button class="btn btn-primary">
    Notificaciones <span class="badge bg-light text-dark">3</span>
</button>
```

### 9. Spinners

```html
<div class="spinner-border text-primary" role="status">
    <span class="visually-hidden">Cargando...</span>
</div>

<div class="spinner-border spinner-border-sm" role="status">
    <span class="visually-hidden">Cargando...</span>
</div>
```

### 10. Progress

```html
<div class="progress">
    <div class="progress-bar" role="progressbar" style="width: 25%" 
         aria-valuenow="25" aria-valuemin="0" aria-valuemax="100">25%</div>
</div>

<div class="progress">
    <div class="progress-bar bg-success" role="progressbar" style="width: 50%"></div>
</div>

<div class="progress">
    <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 75%"></div>
</div>
```

## Utilidades de Diseño

### Contenedores
```html
<div class="container">Container</div>
<div class="container-fluid">Container fluido</div>
```

### Márgenes y Padding
```html
<div class="m-3">Margen todo</div>
<div class="mt-3">Margen top</div>
<div class="mb-3">Margen bottom</div>
<div class="ms-3">Margen start (izquierda)</div>
<div class="me-3">Margen end (derecha)</div>

<div class="p-3">Padding todo</div>
<div class="pt-3">Padding top</div>
```

Valores: 0, 1, 2, 3, 4, 5 (auto)

### Flexbox
```html
<div class="d-flex justify-content-between">Justificar</div>
<div class="d-flex align-items-center">Alinear</div>
```

### Colores de texto
```html
<p class="text-primary">.text-primary</p>
<p class="text-success">.text-success</p>
<p class="text-danger">.text-danger</p>
<p class="text-muted">.text-muted</p>
```

### Colores de fondo
```html
<div class="bg-primary text-white">.bg-primary</div>
<div class="bg-success text-white">.bg-success</div>
```

### Bordos
```html
<div class="border">Borde</div>
<div class="border-top">Borde top</div>
<div class="border-success">Borde color</div>
<div class="rounded">Redondeado</div>
<div class="rounded-circle">Circular</div>
```