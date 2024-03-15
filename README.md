# Spring Boot → Azure
Tutorial para desplegar una aplicación con SpringBoot en Azure.
> En éste proyecto usamos el IDE IntelliJ Idea
### Requisitos
- Azure
- Java 17
- IntelliJ idea

### Contenido
1. Crear Aplicación Web en Azure
2. Crear Proyecto Spring Boot
3. Crear Repositorio en GitHub
4. Desplegar

## 1. Crear Aplicación Web en Azure
El primer paso se trata de crear una aplicación web en Azure.
Debemos crear un **nuevo recurso** de **Aplicación Web**.
- Establecemos un **grupo** de recursos
- Establecemos el **nombre** de la aplicación
- Pila del entorno de ejecución: **Java 17**
- Seleccionamos plan de precios
> En éste caso el plan de precios utilizado es el F1 gratuito
- Pulsamos en *Revisar y Crear*

## 2. Crear Proyecto Spring Boot
### Iniciar proyecto
En nuestro caso, utilizando *IntelliJ Idea* como IDE, creamos un nuevo proyecto **SpringBoot**.
Seleccionamos como lenguaje **Java**, como gestor de proyectos  **Maven** y como JDK **Java17**.
Pulsamos *next* y añadimos la dependencia **Spring Web**.
Por último pulsamos en **crear**.
### Aplicación
En nuestra clase **SpringBootApplication**: 
- Añadimos la anotación **@RestController**.
- Mapeamos un *endpoint*

Con la anotación @GetMapping("/welcome") y el nombre del endpoint, en éste caso será *welcome*
- Creamos el **método welcome**

Éste método devolverá una cadena, en éste caso *"welcome"*, la cuál será mostrada en nuestro endpoint.

**Código:**
```java
import ...
  
@SpringBootApplication  
@RestController  
public class SpringBootAzureApplication {  
  
    @GetMapping("/welcome")  
    public String welcome(){  
        return "<h1>WELCOME</h1>";  
    }  
  
    public static void main(String[] args) {  
       SpringApplication.run(SpringBootAzureApplication.class, args);  
    }  
}
```

## 3. Crear Repositorio en GitHub
Éste paso consiste en **crear un repositorio** *Git* de nuestra aplicación y subirlo a *GitHub*.
- Crear Repositorio en GitHub
- En la **terminal** de nuestra aplicación, ejecutar los siguientes comandos:

*Iniciar repositorio Git*
`git init`
*Añadir archivos relevantes*
`git add pom.xml`
`git add src/`
*Realizar commit*
`git commit -m "SpringBoot Project"`
*Crear nuestra rama main*
`git branch -M main`
*Añadir origen de nuestro repositorio de GitHub remoto*
`git remote add origin https://enlaceDelRepositorio`
*Hacer push*
`git push -u origin main`

## 4. Desplegar
Antes de desplegar, podemos comprobar que nuestra aplicación funciona en local.
Si compilamos la aplicación, debería desplegarse en un servidor Tomcat en el puerto 8080.

> localhost:8080/welcome

![deplegarEnLocal](https://github.com/AlonsoMartinez8/SpringBootAzure/assets/117280599/fbf08921-a574-4f6f-937b-9e0204fbbf20)

### Desplegar Azure
Para desplegar en Azure, nos dirigimos al apartado **Centro de Implementación**.
En la **configuración**:
- Origen: GitHub
- Conectamos con nuestro **usuario**, **repositorio** y **rama**
- Pulsamos en crear

En **registros**, comprobamos que se ha realizado un nuevo registro.
> Quizás tarde unos segundos, pulsa en actualizar para refrescar el apartado.

Tras ello, podemos dirigirnos al apartado de **Acciones** de nuestro repositorio en GitHub y comprobar que se ha realizado el despliegue.

![desplegarEnGitHub](https://github.com/AlonsoMartinez8/SpringBootAzure/assets/117280599/4fae82b1-82f7-4cbb-9636-0a8f46c47c8f)

Si accedemos a la dirección que nos proporciona estaremos accediendo a nuestra aplicación.
> Recuerda que para visualizar el método welcome debes acceder al **endpoint** : *https://springbootazurealonso.azurewebsites.net/welcome*

![deplegado](https://github.com/AlonsoMartinez8/SpringBootAzure/assets/117280599/f7f81297-b27b-4765-9276-9d0e1cf809c9)
