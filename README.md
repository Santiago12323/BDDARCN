# 🧪 Proyecto BDD con Selenium y Cucumber en GitHub Codespaces

## 📌 Descripción

Este proyecto implementa pruebas automatizadas usando:

* Java
* Maven
* Selenium 4
* Cucumber 7
* Docker
* GitHub Codespaces

El objetivo fue automatizar una búsqueda en Google utilizando la metodología **BDD (Behavior Driven Development)**.

---

# 🚀 Paso a Paso de Implementación

## 1️⃣ Creación del Proyecto Maven

Se creó un proyecto Maven con la siguiente estructura:

```
bdd-java
 └── src
     └── test
         └── java
             └── com.eci.myproject
                 ├── runners
                 ├── steps
                 └── features
```

---

## 2️⃣ Configuración del `pom.xml`

Se agregaron las siguientes dependencias:

* selenium-java
* cucumber-java
* cucumber-junit

Estas dependencias permiten:

* Automatizar el navegador con Selenium
* Definir escenarios BDD con Cucumber
* Ejecutar pruebas con JUnit

---

## 3️⃣ Creación del Feature File

Se creó el archivo:

```
src/test/java/com/eci/myproject/features/google_search.feature
```

Con el siguiente escenario:

```
Feature: Google Search

  Scenario: Search for a term
    Given I am on the Google search page
    When I search for "GitHub"
    Then I should see "GitHub" in the results
```

Este archivo define el comportamiento esperado en lenguaje natural.

---

## 4️⃣ Implementación de Step Definitions

Se creó la clase:

```
SearchSteps.java
```

Donde se implementaron los pasos:

* Abrir Google
* Escribir un término de búsqueda
* Verificar que el resultado contenga el texto esperado

---

## 5️⃣ Problema Encontrado en GitHub Codespaces

Inicialmente se intentó ejecutar Chrome localmente, pero se presentaron errores como:

```
SessionNotCreatedException: Chrome instance exited
```

### Causa del problema

GitHub Codespaces:

* Es un contenedor Linux
* No soporta Snap correctamente
* No incluye Chrome instalado
* No tiene entorno gráfico

Por esta razón, Chromium no podía ejecutarse correctamente.

---

## 6️⃣ Solución Implementada

Se utilizó Docker con la imagen oficial de Selenium:

```
selenium/standalone-chrome
```

Se ejecutó con:

```
docker run -d -p 4444:4444 -p 7900:7900 selenium/standalone-chrome
```

Esto levanta:

* Un servidor Selenium
* Chrome ya configurado
* Chromedriver incluido
* Entorno gráfico virtual

---

## 7️⃣ Cambio a RemoteWebDriver

En lugar de usar ChromeDriver local, se utilizó:

```
RemoteWebDriver
```

Con conexión a:

```
http://localhost:4444/wd/hub
```

Esto permitió que las pruebas se ejecutaran dentro del contenedor Docker.

---

## 8️⃣ Ejecución de las Pruebas

Se ejecutó:

```
mvn clean test
```

Resultado final:

```
BUILD SUCCESS
Tests run: 1, Failures: 0, Errors: 0
```

---

# 🧠 Conclusión

Se logró:

* Implementar pruebas BDD con Cucumber
* Automatizar navegación con Selenium
* Resolver problemas de entorno en Codespaces
* Integrar Docker para ejecutar Chrome correctamente

---

# 📎 Tecnologías Utilizadas

* Java
* Maven
* Selenium 4
* Cucumber 7
* Docker
* GitHub Codespaces

---

# 👨‍💻 Autor: Santiago Coronado Pinzon

Proyecto desarrollado como práctica de automatización con BDD.
