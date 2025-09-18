# Casos de Pruebas

En este archivo se encuentra el detalle de los casos de prueba con las técnicas aplicadas, lo cual permitió
definir cada uno de los escenarios y casos para esta automatización.

## Funcionalidades

* [Registro](#registro)
* [Inicio de Sesión](#inicio-de-sesión)
* [Cierre de Sesión](#cierre-de-sesión)
* [Olvido de Contraseña](#olvido-de-contraseña)
* [Ver_Perfil](#ver-perfil)
* [Busqueda de Personaje](#busqueda-de-personaje)
* [Información_del_Personaje](#información-del-personaje)
* [Ubicación_del_Personaje](#ubicación-del-personaje)

## Registro

| ID    | Título                                                | Tipo de Flujo | Técnicas aplicadas                           |
|-------|-------------------------------------------------------|---------------|----------------------------------------------|
| CP001 | Registro de un nuevo usuario                          | Positivo      | Partición de equivalencia                    |
| CP002 | Registro con correo existente                         | Negativo      | Partición de equivalencia                    |
| CP003 | Registro con un campo vacio (nombre)                  | Negativo      | Tabla de decisión, Partición de equivalencia |
| CP004 | Registro con un campo vacio (correo)                  | Negativo      | Tabla de decisión, Partición de equivalencia |
| CP005 | Registro con un campo vacio (contraseña)              | Negativo      | Tabla de decisión, Partición de equivalencia |
| CP006 | Registro con un campo vacio (confirmación contraseña) | Negativo      | Tabla de decisión, Partición de equivalencia |
| CP007 | Registro con un campo vacio (genero)                  | Negativo      | Tabla de decisión, Partición de equivalencia |
| CP008 | Registro con un campo vacio (terminos)                | Negativo      | Tabla de decisión, Partición de equivalencia |
| CP009 | Registro con campos vacios                            | Negativo      | Partición de equivalencia                    |

## Inicio de Sesión

| ID    | Título                                                           | Tipo de Flujo | Técnicas aplicadas                           |
|-------|------------------------------------------------------------------|---------------|----------------------------------------------|
| CP010 | Inicio de sesion con credenciales validas                        | Positivo      | Partición de equivalencia                    |
| CP011 | Inicio de sesion con credenciales invalidas (correo)             | Negativo      | Tabla de decisión, Partición de equivalencia |
| CP012 | Inicio de sesion con credenciales invalidas (contraseña)         | Negativo      | Tabla de decisión, Partición de equivalencia |
| CP013 | Inicio de sesion con el formato invalido para correo electronico | Negativo      | Partición de equivalencia                    |
| CP014 | Inicio de sesion con campos vacios                               | Negativo      | Partición de equivalencia                    |

## Cierre de Sesión

| ID    | Título           | Tipo de Flujo | Técnicas aplicadas |
|-------|------------------|---------------|--------------------|
| CP015 | Cierre de sesion | Positivo      | Caso de Uso        |

## Olvido de Contraseña

| ID    | Título                                                   | Tipo de Flujo | Técnicas aplicadas        |
|-------|----------------------------------------------------------|---------------|---------------------------|
| CP016 | Restablecimiento de la contrasenia con correo registrado | Positivo      | Partición de equivalencia |

## Ver perfil

| ID    | Título                | Tipo de Flujo | Técnicas aplicadas        |
|-------|-----------------------|---------------|---------------------------|
| CP017 | Ver perfil de usuario | Positivo      | Partición de equivalencia |

## Busqueda de Personaje

| ID    | Título                                               | Tipo de Flujo | Técnicas aplicadas        |
|-------|------------------------------------------------------|---------------|---------------------------|
| CP018 | Busqueda de personaje existente                      | Positivo      | Partición de equivalencia |
| CP019 | Busqueda de personaje existente por desplazamiento   | Positivo      | Partición de equivalencia |
| CP020 | Busqueda de personaje que no se encuentra registrado | Negativo      | Partición de equivalencia |

## Información del Personaje

| ID    | Título                                        | Tipo de Flujo | Técnicas aplicadas        |
|-------|-----------------------------------------------|---------------|---------------------------|
| CP021 | Visualizacion de la información del personaje | Positivo      | Partición de equivalencia |
| CP022 | Visualizacion de la pagina oficial de Marvel  | Positivo      | Partición de equivalencia |

## Ubicación del Personaje

| ID    | Título                                             | Tipo de Flujo | Técnicas aplicadas        |
|-------|----------------------------------------------------|---------------|---------------------------|
| CP023 | Ubicación del personaje en el mapa                 | Positivo      | Partición de equivalencia |
| CP024 | Ubicación del personaje en el mapa con alejamiento | Positivo      | Partición de equivalencia |
