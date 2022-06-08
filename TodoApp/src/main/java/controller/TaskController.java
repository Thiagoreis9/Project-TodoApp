package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Task;
import util.ConnectionFactory;

public class TaskController {

    public void save(Task task) {
        
        //Criação da query SQL.
        String sql = "INSERT INTO tasks (idProject,"
                + " name,"
                + " description,"
                + " completed,"
                + " notes,"
                + " deadline,"
                + " createAt,"
                + " updateAt VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        //Declaracao da conexão e do statement.
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            
            //Estabelecendo a conexão com o BD.
            connection = ConnectionFactory.getConnection();
            
            //Preparando a query.
            statement = connection.prepareStatement(sql);
            
            //Definindo os valores do statement.
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao adicionar a tarefa!" + ex.getMessage());
        } finally {
            //Encerrando as conexões com o BD.
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void update(Task task) {
        
        //Criação da query SQL.
        String sql = "UPDATE tasks SET "
                + "idProject = ?"
                + "name = ?"
                + "description = ?"
                + "notes = ?"
                + "completed = ?"                
                + "deadline = ?"
                + "createAt = ?"
                + "updateAt = ?"
                + "WHERE id = ?";
        
        //Declaracao da conexão e do statement.
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Estabelecendo a conexão com o BD.
            connection = ConnectionFactory.getConnection();
            
            //Preparando a query.
            statement = connection.prepareStatement(sql);
            
            //Definindo os valores do statement.
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.getIsCompleted());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            
            //Executando a query.
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Nao foi possivel alterar a tarefa!" + ex.getMessage());
        } finally {
            //Encerrando as conexões com o BD.
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeById(int TaskId) {
        
        //Criação da query SQL.
        String sql = "DELETE FROM tasks WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            
            //Criação da conexão com o BD.
            connection = ConnectionFactory.getConnection();
            
            //Preparando a query.
            statement = connection.prepareStatement(sql);
            
            //Definindo os valores do statement.
            statement.setInt(1, TaskId);
            
            //Executando a query;
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a task" + ex.getMessage());
        } finally {
            //Encerrando as conexões com o BD.
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public List<Task> getAll(int idProject) {
        
        //Criação da query SQL.
        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        
        //Declaracao da conexão e do statement.
        Connection connection = null;
        PreparedStatement statement = null;
        
        //Variavel que armazena os valores retornados da query
        ResultSet resultSet = null;
        
        //Lista de tarefas que será devolvida quando a chamada do metodo acontecer
        List<Task> tasks = new ArrayList<Task>();
        
        try {
            
            //Criação da conexão com o BD.
            connection = ConnectionFactory.getConnection();
            
            //Preparação a query.
            statement = connection.prepareStatement(sql);
            
            //Definindo os valores do statement.
            statement.setInt(1, idProject);
            
            //Atribuindo o valor retornado da execução da query ao resultSet.
            resultSet = statement.executeQuery();
            
            /*Estrutura usada para sempre que tiver um proximo resultSet, 
            executar o bloco de comandos*/
            while (resultSet.next()) {
                
                //Instancia da nova tarefa.
                Task task = new Task();
                
                //Atribuindo os valores a nova tarefa.
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setNotes(resultSet.getString("notes"));
                task.setIsCompleted(resultSet.getBoolean("completed"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                //Adicionando a nova tarefa a lista de tarefas.
                tasks.add(task);
  
            }
            
            
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao pegar todas as tarefas do projeto! " + ex.getMessage());
        } finally{
            //Encerrando as conexões com o BD.
            ConnectionFactory.closeConnection(connection, statement, resultSet);                    
        }
        
        return tasks;

    }

}
