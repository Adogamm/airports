# Airports
Este proyecto fue desarrollado por medio del framework spring, utilizando la herramienta spring inizilizr que permitio el desarrollo más veloz del proyecto

![](https://download.logo.wine/logo/Spring_Framework/Spring_Framework-Logo.wine.png)

## Conexión a la base de datos
Para la conexion a la base de datos se implemento el motor integrado H2 en donde se crearon los modelos para la creación e implementación de las siguientes tablas:

	Airport
	Country
	Employee
	Languaje

Cada uno con sus respectivos identificadores y campos requeridos.
Estas tablas pueden ejecutar su propio **CRUD** siguiendo las rutas creadas en los archivos Controller, los cuales se encuentran dentro de la carpeta con el mismo nombre y son identificados por iniciar con el nombre de la tabla y posteriormente la palabra Controller.

## Prueba del aplicativo
Este aplicativo requiere de implementar el uso de request ya sea por un gestor como Postman o un sistema que genere peticiones como [Python API Test](https://github.com/Adogamm/python_API_test "Python API Test") que nos permite enviar las peticiones desde un entorno Python.
