#language: es
Característica: Registro de Usuario
  YO COMO usuario de la aplicacion Marvel Animation
  QUIERO registrarme
  PARA poder ver el detalle de los personajes de Marvel

  Antecedentes: Estar en la aplicación
    Dado que Usuario no registrado esta en la pagina de Inicio de Sesion de Marvel Animation

  @registroUsuario @flujoPositivo @datosValido
  Escenario: Registro de un nuevo usuario
    Y va a la pagina de Registro
    Cuando diligencia la informacion de registro
      | Name  | Email          | Password | Confirm Password | Gender | Terms |
      | Marta | marta2@mail.com | Marta.1  | Marta.1          | F      | S     |
    Entonces deberia ver la alerta con el mensaje "Successful registration"

  @registroUsuario @flujoNegativo @emailExistente
  Escenario: Registro con correo existente
    Y va a la pagina de Registro
    Cuando diligencia la informacion de registro
      | Name | Email                     | Password | Confirm Password | Gender | Terms |
      | Pepe | lizeth.rios@pragma.com.co | Pepe.1   | Pepe.1           | M      | S     |
    Entonces deberia ver la alerta con el mensaje "The email address is already in use by another account."

  @registroUsuario @flujoNegativo @campoVacio
  Escenario: Registro con un campo vacio
    Y va a la pagina de Registro
    Cuando diligencia la informacion de registro
      | Name  | Email                     | Password | Confirm Password | Gender | Terms |
      | Maria | lizeth.rios@pragma.com.co | Maria.2  | Maria.2          |        | S     |
      |       | lizeth.rios@pragma.com.co | Maria.2  | Maria.2          | F      | S     |
      | Pepe  |                           | Pepe.1   | Pepe.1           | M      | S     |
      | Maria | lizeth.rios@pragma.com.co |          | Maria.2          | F      | S     |
      | Pepe  | lizeth.rios@pragma.com.co | Pepe.1   |                  | M      | S     |
      | Maria | lizeth.rios@pragma.com.co | Maria.2  | Maria.2          | F      | N     |
    Entonces deberia ver la alerta con el mensaje "All fields are required"

  @registroUsuario @camposVacios
  Escenario: Registro con campos vacios
    Y va a la pagina de Registro
    Cuando da en Registrarse
    Entonces deberia ver la alerta con el mensaje "All fields are required"