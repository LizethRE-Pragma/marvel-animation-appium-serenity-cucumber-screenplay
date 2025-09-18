#language: es
Característica: Inicio de Sesión
  YO COMO usuario de la aplicación Marvel Animation
  QUIERO iniciar sesión
  PARA poder ver la información de los personajes de Marvel

  Antecedentes: Estar en la aplicación
    Dado que Maria esta en la pagina de Inicio de Sesion de Marvel Animation

  @inicioSesion @flujoPositivo @credencialesValidas
  Esquema del escenario: Inicio de sesion con credenciales validas
    Cuando ingresa sus credenciales <Email> <Contrasenia>
    Entonces deberia ver el mensaje de bienvenida
    Ejemplos:
      | Email    | Contrasenia |
      | "$EMAIL" | "$PASSWORD" |

  @inicioSesion @flujoNegativo @credencialesInvalidas
  Esquema del escenario: Inicio de sesion con credenciales invalidas
    Cuando ingresa sus credenciales <Email> <Contrasenia>
    Entonces deberia ver la alerta con el mensaje "The supplied auth credential is incorrect, malformed or has expired."
    Ejemplos:
      | Email                              | Contrasenia |
      | "lizeth.rios.epalza@pragma.com.co" | "$PASSWORD" |
      | "$EMAIL"                           | "Maria.2"   |

  @inicioSesion @flujoNegativo @formatoInvalidoEmail
  Esquema del escenario: Inicio de sesion con el formato invalido para correo electronico
    Cuando ingresa sus credenciales <Email> <Contrasenia>
    Entonces deberia ver la alerta con el mensaje "The email address is badly formatted."
    Ejemplos:
      | Email                       | Contrasenia |
      | "lizeth.rios.pragma.com.co" | "$PASSWORD" |


  @inicioSesion @flujoNegativo @camposVacios
  Escenario: Inicio de sesion con campos vacios
    Cuando da en Iniciar Sesion
    Entonces deberia ver la alerta con el mensaje "All fields are required"