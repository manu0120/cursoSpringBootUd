# Resumen de Anotaciones de Spring en Controladores

Este documento resume las anotaciones de Spring utilizadas en los controladores del proyecto, proporcionando una breve descripción de su propósito.

## Anotaciones a Nivel de Clase

*   `@RestController`:
    *   **Uso**: Se utiliza en clases para marcar un controlador donde cada método devuelve directamente un objeto de dominio en lugar de una vista. Es una combinación de `@Controller` y `@ResponseBody`.
    *   **Ejemplo**: `[UserRestController.java]([https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/UserRestController.java](https://github.com/manu0120/cursoSpringBootUd/edit/master/PrimerProyecto/springboot-web/annotations_summary.md))`, `[RequestParamController.java](https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/RequestParamController.java)`, `[PathVariableController.java](https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/PathVariableController.java)`

*   `@Controller`:
    *   **Uso**: Indica que una clase es un controlador de Spring MVC. Se utiliza para manejar solicitudes web y devolver vistas o datos.
    *   **Ejemplo**: `[UserController.java](https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/UserController.java)`

*   `@RequestMapping("/ruta_base")`:
    *   **Uso**: Se utiliza a nivel de clase para mapear una URL base para todos los métodos de controlador dentro de esa clase. También se puede usar a nivel de método.
    *   **Ejemplo**: `@RequestMapping("/api/params")` en `[RequestParamController.java](https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/RequestParamController.java)`, `@RequestMapping("/api/path-variable")` en `[PathVariableController.java](https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/PathVariableController.java)`, `@RequestMapping("/api")` en `[UserRestController.java](https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/UserRestController.java)`

## Anotaciones a Nivel de Método

*   `@GetMapping("/ruta")`:
    *   **Uso**: Una anotación compuesta que actúa como un atajo para `@RequestMapping(method = RequestMethod.GET)`. Se utiliza para mapear solicitudes HTTP GET a métodos de controlador específicos.
    *   **Ejemplo**: `@GetMapping("/foo")` en `[RequestParamController.java](https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/RequestParamController.java)`, `@GetMapping("/baz/{param}")` en `[PathVariableController.java](https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/PathVariableController.java)`, `@GetMapping("/details")` en `[UserController.java](https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/UserController.java)`

*   `@PostMapping("/ruta")`:
    *   **Uso**: Una anotación compuesta que actúa como un atajo para `@RequestMapping(method = RequestMethod.POST)`. Se utiliza para mapear solicitudes HTTP POST a métodos de controlador específicos, comúnmente para crear nuevos recursos.
    *   **Ejemplo**: `@PostMapping("/create")` en `[PathVariableController.java](https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/PathVariableController.java)`

## Anotaciones a Nivel de Parámetro

*   `@RequestParam(name = "nombre_parametro", required = false, defaultValue = "valor_por_defecto")`:
    *   **Uso**: Se utiliza para vincular un parámetro de solicitud web a un parámetro de método en el controlador.
    *   `name`: Especifica el nombre del parámetro en la URL.
    *   `required`: Indica si el parámetro es obligatorio (por defecto es `true`).
    *   `defaultValue`: Proporciona un valor predeterminado si el parámetro no está presente en la solicitud.
    *   **Ejemplo**: `@RequestParam(required = false, defaultValue = "No hay mensaje como parámetro") String mensaje` en `[RequestParamController.java](https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/RequestParamController.java)`

*   `@PathVariable("nombre_variable")`:
    *   **Uso**: Se utiliza para vincular una variable de plantilla URI (parte de la URL) a un parámetro de método en el controlador.
    *   **Ejemplo**: `@PathVariable String param` en `[PathVariableController.java](https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/PathVariableController.java)`

*   `@RequestBody`:
    *   **Uso**: Se utiliza para vincular el cuerpo de la solicitud HTTP a un parámetro de método. Spring intentará convertir automáticamente el cuerpo de la solicitud (por ejemplo, JSON o XML) al tipo de objeto especificado.
    *   **Ejemplo**: `@RequestBody User user` en `[PathVariableController.java](https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/PathVariableController.java)`

*   `@ModelAttribute("nombre_atributo")`:
    *   **Uso**: Se utiliza en un método para indicar que su valor de retorno debe agregarse al modelo bajo un nombre específico. También se puede usar en un parámetro de método para vincular un objeto del modelo a la solicitud.
    *   **Ejemplo**: `@ModelAttribute("users") public List<User> userModel()` en `[UserController.java](https://github.com/manu0120/cursoSpringBootUd/blob/master/src/main/java/com/manuel/springboot/webapp/springboot_web/controllers/UserController.java)`
