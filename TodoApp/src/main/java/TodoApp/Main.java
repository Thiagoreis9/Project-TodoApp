package TodoApp;

import controller.ProjectController;
import java.util.Calendar;
import model.Project;

public class Main {

    public static void main(String[] args) {
        
        ProjectController projectController = new ProjectController();
       
        Project project = new Project();
        
        
        project.setName("projeto teste");
        project.setDescription("description");

        
        
        projectController.save(project);

    }

}
