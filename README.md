# Proyecto Automatización Móvil

Proyecto de automatización de pruebas para la APP Marvel Animation utilizando Appium, Serenity BDD, Cucumber y el patrón
Screenplay.

## Contenido

* [Prerrequisitos](#prerrequisitos)
* [Tecnologías usadas](#tecnologías-usadas)
* [Instalación](#instalación)
* [Estructura del Proyecto](#estructura-del-proyecto)
* [Configuración](#configuración)
* [Ejecución de Pruebas](#ejecución-de-pruebas)
* [Reportería](#reportería)
* [Licencia](#licencia)

## Prerrequisitos

* Java JDK 16 o superior
* IDE (Intellij o Eclipse)
* Android Debug Bridge (ADB)
* Appium Server 2.0 o superior
* Dispositivo móvil o emulador

## Tecnologías usadas

* Java
* Appium
* Serenity BDD + Screenplay
* Cucumber BDDIDE (Intellij o Eclipse)
* Junit5
* Lombok

## Instalación

Clona el repositorio:

```shell
git clone 
```

```shell
cd marvel-animation-appium-serenity-cucumber-screenplay
```

## Estructura del Proyecto

```Gherkin
⯆ 📁marvel-animation-appium-serenity-cucumber-screenplay
├── ⯆ 📁src
│      ├── ⯆ 📁main
│      │      └── ⯆ 📁java (co.com.pragma.certification)     # Estructura del Patrón Screenplay
│      │             ├── ⯈ 📁interactions       # Acciones de bajo nivel
│      │             ├── ⯈ 📁models             # Objectos de negocio
│      │             ├── ⯈ 📁questions          # Aserciones o verificaciones de las pruebas
│      │             ├── ⯈ 📁tasks              # Acciones de alto nivel (grupo de interaciones)
│      │             ├── ⯈ 📁userinterfaces     # Mapeo de elementos de las paginas
│      │             └── ⯆ 📁utils              # Clases utiles como Driver Manager
│      │                    └── 📄DriverManager.java     # Clase Java para controlar el driver
│      └── ⯆ 📁test
│             ├── ⯆ 📁java (co.com.pragma.certification)
│             │      ├── ⯈ 📁runners             # Ejecutor de la prueba
│             │      └── ⯆ 📁stepdefinitions     # Definiciones de los pasos a nivel Given, When, Then, ...
│             │             ├── 📄DriverManager.java            # Clase Java con las defeniciones de pasos comunes y el magaged del drive
│             │             └── 📄ParameterDefinitions.java     # Clase Java con los metodos que se ejecutaran antes y despues de la prueba y la parametrizacion de la variable Actor
│             └── ⯆ 📁resources
│                    ├── ⯈ 📁app                         # APK
│                    ├── ⯈ 📁features                    # Archivos Feature en lenguaje Gherkin
│                    ├── 📄junit-platform.properties     # Archivo de configuración de Junit con Cucumber
│                    ├── 📄logback-test.xml              # Archivo de cofiguración de Logback
│                    └── 📄serenity.conf                 # Archivo de cofiguración de Serenity y las capabilities de Appium formato JSON
├── ⯈ 📁target                  # Reporte Serenity
├──   📄build.gradle            # Archivo Gradle con las dependencias requeridad
└──   📄serenity.properties     # Archivo de cofiguración de Serenity formato property
```

## Configuración

Configura en el archivo `serenity.conf` ubicado en la ruta `src/test/resources/` las capabilities correspondientes al
dispositivo o emulador a utilizar y la aplicación a probar.

```properties
appium {
automationName="UiAutomator2"
platformName="Android"
platformVersion="15.0"
deviceName="SM A356E"
udid="RFCX904J2FY"
appActivity=".MainActivity"
appPackage="com.example.marvel_animation_app"
}
```

## Ejecución de Pruebas

Se debe colocar las variables de entorno, ya que el correo y la contraseña de Inicio de Sesión es data sensible y por
ello no se coloca dentro del proyecto. Las credenciales que se muestran en esta sección son un ejemplo.

```shell
$env:EMAIL="admin"
$env:PASSWORD="admin"
```

### Ejecutar todo el proyecto

```shell
./gradlew clean test
```

### Ejecutar por runner

```shell
./gradle clean test --tests "co.com.pragma.certification.runners.nombreRunner"
```

## Reportería

El reporte de Serenity se genera en la ruta `target/site/serenity/`, archivo principal `index.html`

## Licencia

Open source project.


