#language: es
Característica: Información del Personaje
  YO COMO usuario de la aplicación Marvel Animation
  QUIERO ver la información del personaje
  PARA poder ver su información al detalle

  Antecedentes: Estar en la aplicación
    Dado que Maria ha iniciado sesion

  @informacionPersonaje @flujoPositivo
  Esquema del escenario: Visualizacion de la información del personaje
    Cuando busca el personaje por <Apodo>
    Y va a la informacion del personaje <Nombre> y <Apodo>
    Entonces deberia ver el detalle del personaje <Apodo>
    Ejemplos:
      | Nombre                         | Apodo    |
      | "Gamora Zen Whoberi Ben Titan" | "Gamora" |

  @informacionPersonaje @paginaOficial @flujoPositivo @E2E
  Esquema del escenario: Visualizacion de la pagina oficial de Marvel
    Y que se encuentra en la pagina de Informacion del personaje <Nombre> y <Apodo>
    Cuando va a la pagina de Marvel Comics Characters
    Entonces deberia ver la pagina externa de Marvel
    Ejemplos:
      | Nombre        | Apodo       |
      | "Kara Zor-El" | "Supergirl" |