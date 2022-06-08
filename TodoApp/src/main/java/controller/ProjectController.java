package controller;

import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

public class ProjectController {
    
    public void save(Project project){
    
        String sql = "INSERT INTO projects (name, "
                + "description, "
                + "createdAt, "
                + "updatedAt) "             
                + "VALUES (?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreatedAt().getTimeInMillis()));
            statement.setDate(4, new java.sql.Date(project.getUpdatedAt().getTimeInMillis()));
            
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar projeto! ");
        } finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
        
    }
    
    public void update(Project project){
    
        String sql = "UPDATE projects SET "
                + "name = ?, "
                + "description = ?, "
                + "createdAt = ?, "
                + "updatedAt = ?, "
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            Calendar calendar = Calendar.getInstance();
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreatedAt().getTimeInMillis()));
            statement.setDate(4, new java.sql.Date(project.getUpdatedAt().getTimeInMillis()));
            statement.setInt(5, project.getId());
            
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o projeto! " + ex.getMessage());
        } finally{
            ConnectionFactory.closeConnection(connection, statement);
        }

    }
    
    public List<Project> getAll(){
    
        String sql = "SELECT * FROM projects";

        List<Project> projects = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            //Enquanto existir dados no banco de dados, fa�a
            while (resultSet.next()) {

                Project project = new Project();
                
                

                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                
                //project.setCreatedAt(new java.sql.Date(resultSet.getDate("createdAt")));
                    Calendar data = Calendar.getInstance();
                    java.sql.Date createdAt = resultSet.getDate("createdAt");
                    data.setTime(new java.util.Date(createdAt.getTime()));
                    project.setCreatedAt(data);
                //project.setCreatedAt(resultSet.getDate("updatedAt"));
                    java.sql.Date updatedAt = resultSet.getDate("updatedAt");
                    data.setTime(new java.util.Date(updatedAt.getTime()));
                    project.setUpdatedAt(data);

                //Adiciono o contato recuperado, a lista de contatos
                projects.add(project);
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar os projetos" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return projects;
    }
    
    public void removeById(int id) {

        String sql = "DELETE FROM projects WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar o projeto" + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }
    
}
