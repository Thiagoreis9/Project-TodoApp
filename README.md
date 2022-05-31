# TodoApp

Project Definition Developed in the CAPGEMIMI START PROGRAM Training.

TodoApp

Description: Application for managing projects and the tasks involved in these projects.

Objective: To solve the issue of organizing tasks for one or several projects.

Entities:
* Project;
  - Name,
  - Description,
  - Creation date,
  - Update date.
* Assignment.
  - Name,
  - Description,
  - Status,
  - Comments,
  - Deadline,
  - Creation date,
  - Update date.

Requirements:
* Allow to create the Project;
* Allow to change the Project;
* Allow deleting the Project;
* Allow to create the Task;
* Allow to change the Task;
* Allow to delete the Task.

Business rules:
* Will not contain a login system;
* There will be no concept of user;
* Every task must belong to a project;

Technologies used:
* Java;
* MySql;

Development progress:
* Creation Database (OK)
* Creation model classes (OK)
* Creation conection with Database (OK)
* Creation Grafical Interface
	- Creation main screens
		- Creation of CellRederer deadline
		- Creation of CellRederer edit/delete
	- Creation of the project registration screen
	- creation of the task registration screen
* Events of implementation
	-  Validate
* Final settings
* Aplication test
