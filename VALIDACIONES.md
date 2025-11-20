# Validaciones y Manejo de Errores - API REST Spring Boot

## ✅ Implementaciones Completadas

### 1. Validaciones en Entidades (@Valid)

#### **Cliente**
- `nombre`: 
  - `@NotBlank` - Campo obligatorio
  - `@Size(min=2, max=100)` - Entre 2 y 100 caracteres
- `telefono`:
  - `@NotBlank` - Campo obligatorio
  - `@Pattern(regexp="^[0-9]{9,15}$")` - Entre 9 y 15 dígitos numéricos

#### **Plato**
- `nombre`:
  - `@NotBlank` - Campo obligatorio
  - `@Size(min=2, max=100)` - Entre 2 y 100 caracteres
- `descripcion`:
  - `@Size(max=500)` - Máximo 500 caracteres (opcional)
- `precio`:
  - `@NotNull` - Campo obligatorio
  - `@DecimalMin(value="0.0", inclusive=false)` - Debe ser mayor a 0

#### **Pedido**
- `numeroMesa`:
  - `@NotNull` - Campo obligatorio
  - `@Min(value=1)` - Debe ser mayor a 0
- `plato`:
  - `@NotNull` - Campo obligatorio
- `cliente`:
  - `@NotNull` - Campo obligatorio

### 2. Manejo Global de Excepciones

Se implementó `@RestControllerAdvice` con:

#### **ResourceNotFoundException**
- Retorna HTTP 404 cuando no se encuentra un recurso
- Mensaje personalizado por entidad

#### **MethodArgumentNotValidException**
- Retorna HTTP 400 para errores de validación
- Incluye detalles de todos los campos con error
- Formato JSON estructurado con campo y mensaje

#### **Exception (General)**
- Retorna HTTP 500 para errores internos
- Captura cualquier excepción no manejada

### 3. Respuestas de Error Estructuradas

```json
{
  "timestamp": "2025-11-20T10:30:00",
  "status": 400,
  "error": "Validation Failed",
  "message": "Error de validación en los campos",
  "path": "/api/cliente",
  "validationErrors": {
    "nombre": "El nombre es obligatorio",
    "telefono": "El teléfono debe contener entre 9 y 15 dígitos"
  }
}
```

### 4. CRUD Completo en Todos los Controladores

#### Endpoints implementados:
- `GET /api/{entidad}` - Listar todos
- `GET /api/{entidad}/{id}` - Obtener por ID
- `POST /api/{entidad}` - Crear nuevo (con @Valid)
- `PUT /api/{entidad}/{id}` - Actualizar (con @Valid)
- `DELETE /api/{entidad}/{id}` - Eliminar

#### Entidades:
- `/api/cliente`
- `/api/plato`
- `/api/pedido`

### 5. Mejoras en Controladores

- Eliminación de try-catch innecesarios (manejados globalmente)
- Validación de existencia antes de actualizar/eliminar
- Códigos HTTP apropiados:
  - 200 OK - Lectura exitosa
  - 201 CREATED - Creación exitosa
  - 204 NO_CONTENT - Eliminación exitosa
  - 404 NOT_FOUND - Recurso no encontrado
  - 400 BAD_REQUEST - Validación fallida
  - 500 INTERNAL_SERVER_ERROR - Error del servidor

### 6. Spring Data JPA

- Uso de `JpaRepository` en todos los repositorios
- Operaciones CRUD automáticas
- Relaciones `@OneToMany` y `@ManyToOne` configuradas
- `@JsonIgnore` para evitar recursión infinita

### 7. Correcciones Realizadas

- ✅ Sintaxis corregida en entidades (package, imports)
- ✅ Cambio de `numero_mesa` a `numeroMesa` (camelCase)
- ✅ Agregado `@JsonIgnore` en relaciones bidireccionales
- ✅ Validaciones completas en todas las entidades
- ✅ Manejo de errores centralizado
- ✅ Controladores simplificados y limpios

## 📋 Ejemplos de Uso

### Crear Cliente (POST /api/cliente)
```json
{
  "nombre": "Juan Pérez",
  "telefono": "987654321"
}
```

### Crear Plato (POST /api/plato)
```json
{
  "nombre": "Ceviche",
  "descripcion": "Ceviche de pescado fresco",
  "precio": 25.50
}
```

### Crear Pedido (POST /api/pedido)
```json
{
  "numeroMesa": 5,
  "plato": {
    "idPlato": 1
  },
  "cliente": {
    "idCliente": 1
  }
}
```

## 🔧 Dependencias Utilizadas

- Spring Boot 3.5.7
- Spring Data JPA
- Spring Validation
- Lombok
- MySQL Connector

## ✨ Características Spring Boot 3.x

- Jakarta EE (jakarta.* en lugar de javax.*)
- Validaciones con Bean Validation 3.0
- JPA 3.0
- Mejor rendimiento y seguridad
