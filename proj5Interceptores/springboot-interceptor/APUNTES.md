# Apuntes del proyecto - springboot-interceptor

Fichero para ir guardando las explicaciones del curso.

## Índice

1. [Interceptores: cómo entran en juego y cómo se activan](#1-interceptores-cómo-entran-en-juego-y-cómo-se-activan)

---

## 1. Interceptores: cómo entran en juego y cómo se activan

No se activan solo por usar `implements` en `LoadingTimeInterceptor`. Son 3 piezas:

### 1.1. Definir el comportamiento: `LoadingTimeInterceptor`

`src/main/java/com/manuel/curso/springboot/app/interceptor/springboot_interceptor/interceptors/LoadingTimeInterceptor.java`

```java
@Component("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor
```

- El `implements HandlerInterceptor` solo dice: "esta clase sabe ser un interceptor" y te obliga a implementar `preHandle()` / `postHandle()`.
- El `@Component` solo la registra como bean en Spring, pero aún no la usa nadie.

### 1.2. Registrarlo / activarlo: `MvcConfig`

`src/main/java/com/manuel/curso/springboot/app/interceptor/springboot_interceptor/MvcConfig.java`

```java
@Override
public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(timeInterceptor);
}
```

- Esto es lo clave. `MvcConfig implements WebMvcConfigurer` + `@Configuration` le dice a Spring MVC: "usa este interceptor para las peticiones".
- Sin ese `registry.addInterceptor(...)`, `preHandle` / `postHandle` nunca se llamarían.

### 1.3. Flujo cuando llamas a `/app/foo`, `/bar`, `/baz`

Definidos en `src/main/java/com/manuel/curso/springboot/app/interceptor/springboot_interceptor/controllers/FooController.java`:

1. Petición HTTP -> `DispatcherServlet`.
2. `preHandle()` (antes del controlador, loguea "entrando..."). Si devuelve `true` continúa, si devuelve `false` corta la petición.
3. Se ejecuta el método del `FooController`.
4. `postHandle()` (después del controlador, loguea "saliendo...").

Nota: como en `MvcConfig` se registra sin `.addPathPatterns(...)`, se aplica a **todas** las rutas.
