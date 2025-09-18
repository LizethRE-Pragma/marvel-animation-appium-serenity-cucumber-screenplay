#language: es
Característica: Ubicación del Personaje
  YO COMO usuario de la aplicación Marvel Animation
  QUIERO ver la ubicación del personaje
  PARA poder saber donde se encuentra

  Antecedentes: Estar en la aplicación
    Dado que Maria ha iniciado sesion

  @ubicacionPersonaje @flujoPositivo
  Esquema del escenario: Ubicación del personaje en el mapa
    Cuando busca el personaje por <Apodo>
    Y va a la ubicacion del personaje
    Entonces deberia ver la marca en el mapa
    Ejemplos:
      | Apodo     |
      | "Aquaman" |

  @ubicacionPersonaje @flujoPositivo @E2E
  Esquema del escenario: Ubicación del personaje en el mapa con alejamiento
    Y que se encuentra en el mapa del personaje <Apodo>
    Cuando se aleja de la ubicacion
    Entonces deberia ver la marca en el mapa
    Ejemplos:
      | Apodo      |
      | "Iron Man" |