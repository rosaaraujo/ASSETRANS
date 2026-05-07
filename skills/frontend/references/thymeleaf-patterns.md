# Patrones Thymeleaf - ASSETRANS

## Expresiones Thymeleaf

### Expresión Simple `${...}`
```html
<span th:text="${variable}">valor por defecto</span>
```

### Expresión de Objeto `*{...}` (para formularios)
```html
<input th:field="*{nombre}">
```

### Expresión de URL `@{...}`
```html
<a th:href="@{/activos}">Activos</a>
```

### Expresión de Fragmento `~{...}`
```html
<div th:replace="~{fragments/header :: header}"></div>
```

## Iteración con `th:each`

### Iteración simple
```html
<ul>
    <li th:each="item : ${lista}" th:text="${item.nombre}"></li>
</ul>
```

### Iteración con estado
```html
<tr th:each="item, iterStat : ${lista}">
    <td th:text="${iterStat.index}">0</td>
    <td th:text="${item.nombre}">nombre</td>
    <td th:text="${iterStat.even}">true/false</td>
</tr>
```

Variables de estado disponibles:
- `index`: índice (inicia en 0)
- `count`: contador (inicia en 1)
- `size`: tamaño total
- `even`: true si es par
- `odd`: true si es impar
- `first`: true si es el primero
- `last`: true si es el último

## Condicionales

### th:if (mostrar si es verdadero)
```html
<div th:if="${activo != null}">
    <p th:text="${activo.nombre}"></p>
</div>

<!-- Negación -->
<div th:if="${!activo.disponible}">No disponible</div>
```

### th:unless (mostrar si es falso)
```html
<div th:unless="${usuario.admin}">
    Solo usuarios
</div>
```

### th:switch / th:case
```html
<div th:switch="${estado}">
    <span th:case="'pendiente'" class="text-warning">Pendiente</span>
    <span th:case="'completado'" class="text-success">Completado</span>
    <span th:case="*">Otro</span>
</div>
```

## Manejo de Nulos

### Operador Elvis `?:`
```html
<span th:text="${activo.nombre ?: 'Sin nombre'}"></span>
```

### Safe Navigation `?.`
```html
<span th:text="${activo.tipo?.nombre}">Tipo</span>
```

## Fechas

### Formatear fechas
```html
<!-- Con #temporals (JDK 8+) -->
<span th:text="${#temporals.format(activo.fechaAlta, 'dd/MM/yyyy')}"></span>

<!-- Fecha actual -->
<span th:text="${#temporals.format(#temporals.now(), 'dd/MM/yyyy HH:mm')}"></span>
```

## Números

### Formatear números
```html
<!-- Decimal -->
<span th:text="${#numbers.formatDecimal(numero, 1, 2)}">1,00</span>

<!-- Moneda -->
<span th:text="${#numbers.formatCurrency(valor)}">$1,000.00</span>

<!-- Porcentaje -->
<span th:text="${#numbers.formatPercent(porcentaje, 1, 1)}">10%</span>
```

## Strings

### Manipulación de strings
```html
<!-- Mayúsculas -->
<span th:text="${#strings.toUpperCase(texto)}">TEXTO</span>

<!-- Minúsculas -->
<span th:text="${#strings.toLowerCase(texto)}">texto</span>

<!-- Longitud -->
<span th:text="${#strings.length(texto)}">5</span>

<!-- Contains -->
<span th:if="${#strings.contains(texto, 'busqueda')}">Encontrado</span>

<!-- Empty check -->
<span th:if="${#strings.isEmpty(texto)}">Vacío</span>
```

## Fragmentos y Layouts

### Definir fragmento
```html
<!-- En fragments.html -->
<div th:fragment="header">
    <nav>...</nav>
</div>
```

### Usar fragmento
```html
<!-- Include -->
<div th:replace="~{fragments/header :: header}"></div>

<!-- Insert (dentro de un bloque) -->
<div th:insert="~{fragments/header :: header}"></div>
```

### Con parámetros
```html
<!-- Definir -->
<div th:fragment="boton(titulo, tipo)">
    <button th:class="${'btn btn-' + tipo}" th:text="${titulo}"></button>
</div>

<!-- Usar -->
<div th:replace="~{fragments/boton :: boton(titulo='Guardar', tipo='success')}"></div>
```

## Data Attributes (para JS)

```html
<!-- Pasar datos a JavaScript -->
<button th:attr="data-id=${activo.id}, data-nombre=${activo.nombre}" 
        onclick="seleccionar(this)">Seleccionar</button>
```

## Form Binding Completo

### Objeto de formulario
```html
<form th:action="@{/activos/guardar}" th:object="${activo}" method="post">
    <div class="mb-3">
        <label th:for="nombre" class="form-label">Nombre</label>
        <input type="text" class="form-control" th:field="*{nombre}" 
               th:errorclass="is-invalid">
        <div class="invalid-feedback" th:if="${#fields.hasErrors('nombre')}" 
             th:errors="*{nombre}">Error</div>
    </div>
    
    <div class="mb-3">
        <label th:for="tipo" class="form-label">Tipo</label>
        <select class="form-select" th:field="*{tipo.id}">
            <option value="">Seleccionar tipo</option>
            <option th:each="tipo : ${tipos}" 
                    th:value="${tipo.id}" 
                    th:text="${tipo.nombre}">Tipo</option>
        </select>
    </div>
    
    <button type="submit" class="btn btn-success">Guardar</button>
</form>
```

## Errores de Validación

```html
<!-- Mostrar errores de campo -->
<div th:if="${#fields.hasErrors('nombre')}" class="text-danger">
    <small th:errors="*{nombre}">Error de nombre</small>
</div>

<!-- Mostrar todos los errores -->
<ul>
    <li th:each="err : ${#fields.errors('*')}" th:text="${err}"></li>
</ul>
```