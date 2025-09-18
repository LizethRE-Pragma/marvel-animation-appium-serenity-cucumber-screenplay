#language: es
Característica: Busqueda de Personaje
  YO COMO usuario de la aplicación Marvel Animation
  QUIERO buscar un heroe
  PARA poder ver su información

  Antecedentes: Estar en la aplicación
    Dado que Maria ha iniciado sesion

  @busquedaPersonaje @flujoPositivo @personajeExistente
  Esquema del escenario: Busqueda de personaje existente
    Cuando busca el personaje por <Apodo>
    Entonces deberia ver el resultado de la busqueda <Apodo> <Cantidad>
    Ejemplos:
      | Apodo     | Cantidad |
      | "Ant-Man" | 2        |

  @busquedaPersonaje @busquedaPersonajePorDesplazamiento @flujoPositivo @personajeExistente
  Esquema del escenario: Busqueda de personaje existente por desplazamiento
    Cuando busca el personaje por <Nombre> y <Apodo> desplazandose
    Entonces deberia ver la tarjeta del personaje <Nombre> y <Apodo>
    Ejemplos:
      | Nombre        | Apodo    |
      | "Bruce Wayne" | "Batman" |

  @busquedaPersonaje @flujoNegativo @personajeNoExistente
  Esquema del escenario: Busqueda de personaje que no se encuentra registrado
    Cuando busca el personaje por <Apodo>
    Entonces deberia ver el resultado de la busqueda <Apodo> <Cantidad>
    Ejemplos:
      | Apodo       | Cantidad |
      | "Peter Pan" | 0        |