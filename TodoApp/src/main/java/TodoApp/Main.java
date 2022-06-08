package TodoApp;

import controller.ProjectController;
import controller.TaskController;
import model.Project;
import model.Task;

public class Main {

    public static void main(String[] args) {
        
        ProjectController projectController = new ProjectController();
        
        TaskController taskController = new TaskController();
        
        //Project project = new Project();
        
        
        //project.setName("TestandoProjeto2huehue");
        //project.setDescription("description do teste do projeto 2huehue");
        
        /*
        Task task = new Task();
        task.setIdProject(2);
        task.setName("Task teste project2");
        task.setDescription("dhuhwuhwuwuh");
        task.setIsCompleted(false);
        task.setNotes("huwehuehuwehuh");
        */
        
        

        
        //taskController.removeById(2);
        projectController.getAll();
        
        //taskController.getAll(1);
        //taskController.save(task);
        //projectController.save(project);
        

    }

}
