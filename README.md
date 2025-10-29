
# 🚀 Taller CI - Automatización y Reportes BDD

Este proyecto implementa una solución completa de Integración Continua (CI) para validar un módulo de autenticación de usuario, utilizando Maven, JUnit 5 y Cucumber (BDD). La solución incluye un pipeline en GitHub Actions para ejecutar pruebas unitarias y de integración, y generar reportes navegables como evidencia.

## 🎯 Indicadores de Logro Cubiertos

| Indicador | Descripción | 
| :--- | :--- | :--- |
| **Integración Continua** | Configuración de GitHub Actions y pipeline `ci.yml`. | 
| **Estructura de Pruebas** | Uso de JUnit para Unitarias y Cucumber para BDD. | 
| **Automatización BDD** | Implementación de escenarios BDD en `Login.feature` y `LoginSteps.java`. | 
| **Reporte Navegable** | Configuración del plugin `maven-cucumber-reporting`. | 
| **Documentación** | Claridad y completitud de este `README.md`. | 

---

## 🛠️ Requisitos Previos

Para ejecutar el proyecto localmente o para que el pipeline de CI funcione, se requiere:

* **Java Development Kit (JDK) 17 o superior** (el pipeline usa JDK 21).
* **Apache Maven 3.6.3 o superior**.

## 📜 Instalación y Ejecución Local

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://docs.github.com/es/repositories/creating-and-managing-repositories/quickstart-for-repositories](https://docs.github.com/es/repositories/creating-and-managing-repositories/quickstart-for-repositories)
    cd TallerCI
    ```

2.  **Compilar y Ejecutar Pruebas (Unitarias y BDD):**
    El comando `mvn clean install` compila el código, ejecuta los tests unitarios (`Surefire`) y los tests de integración BDD (`Failsafe`), y genera los reportes en la carpeta `target/`.
    ```bash
    mvn clean install
    ```

## 📊 Visualización de Reportes

Una vez que el pipeline de GitHub Actions se ejecute con éxito (el objetivo final que estamos resolviendo), se generan dos artefactos clave:

| Artefacto de GitHub Actions | Contenido y Propósito | Ubicación Local |
| :--- | :--- | :--- |
| `reporte-surefire-tests` | Reporte XML y HTML de Pruebas Unitarias (JUnit). | `target/surefire-reports` |
| `reporte-bdd-html-navegable` | **Reporte HTML de Cucumber (Navegable).** | `target/cucumber-html-reports` |

**Para ver el Reporte BDD (T39):**
Descarga el artefacto `reporte-bdd-html-navegable` de GitHub Actions y abre el archivo `index.html` en cualquier navegador web.

---

## ☁️ Configuración de CI (GitHub Actions)

El archivo `.github/workflows/ci.yml` define el pipeline, el cual:
1.  Configura el ambiente con **Java 21**.
2.  Ejecuta **`mvn clean install`** para compilar y probar.
3.  Utiliza el comando `actions/upload-artifact@v4` para subir los reportes BDD y Unitarios a GitHub.

## 🔑 Solución al Error de Reporte

> **Nota:** La persistencia del error `No JSON report file was found!` se resolvió mediante una configuración robusta en el `pom.xml`, que combina la generación forzada del JSON a través de `maven-failsafe-plugin` y el uso de un patrón flexible (`*.json`) en el plugin `maven-cucumber-reporting` para anular los conflictos de *timing* en el entorno de CI.