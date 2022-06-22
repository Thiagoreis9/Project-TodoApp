# TodoApp

Project Definition Developed in the CAPGEMIMI START PROGRAM Training.

![TodoAppScreenEmpty](https://user-images.githubusercontent.com/61464525/175041590-bece04e3-fdd8-479d-a703-49778ae48188.png)
![TodoAppScreenMainTasks1](https://user-images.githubusercontent.com/61464525/175041611-dc92dfee-0b9f-4feb-9af1-25402d8ce613.png)
![TodoAppScreenMainTasks2](https://user-images.githubusercontent.com/61464525/175041652-e8844989-2696-4ee2-9659-8ac649eaf884.png)
![TodoAppScreenProject](https://user-images.githubusercontent.com/61464525/175041664-d4c2df9d-5418-42df-a395-9e682e54eb11.png)
![TodoAppScreenTasks](https://user-images.githubusercontent.com/61464525/175041684-9cf6dc1a-fed2-42bd-8c60-4e45d8f71147.png)

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
* Creation Grafical Interface (OK)
	- Creation main screens (OK)
		- Creation of CellRederer deadline
		- Creation of CellRederer edit/delete
	- Creation of the project registration screen
	- creation of the task registration screen
* Events of implementation
	-  Validate
* Final settings
* Aplication test
