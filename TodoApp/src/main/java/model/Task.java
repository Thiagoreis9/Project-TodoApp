package model;

import java.util.Calendar;
import java.util.Date;

public class Task {
    
    private int id;
    private int idProject;
    private String name;
    private String description;
    private String notes;
    private boolean isCompleted;
    private Calendar deadline;
    private Calendar createdAt;
    private Calendar updatedAt;

    public Task(int id, int idProject, String name, String description, String notes, boolean isCompleted, Calendar deadline, Calendar createdAt, Calendar updatedAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public Task() {
        this.createdAt = Calendar.getInstance();
        this.updatedAt = Calendar.getInstance();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Calendar getDeadline() {
        deadline = Calendar.getInstance();
        return deadline;
    }

    public void setDeadline(Calendar deadline) {
        this.deadline = Calendar.getInstance();
    }

    public Calendar getCreatedAt() {
        createdAt = Calendar.getInstance();
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = Calendar.getInstance();
    }

    public Calendar getUpdatedAt() {
        updatedAt = Calendar.getInstance();
        return updatedAt;
    }

    public void setUpdatedAt(Calendar updatedAt) {
        updatedAt = Calendar.getInstance();
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description + ", notes=" + notes + ", isCompleted=" + isCompleted + ", deadline=" + deadline + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

    public void setDeadline(Date deadline) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setDeadline(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
