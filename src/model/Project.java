package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Project {
    private final StringProperty id;
    private final StringProperty projectName;
    private final StringProperty taskName;
    private final StringProperty responsible;
    private final StringProperty phone;
    private final StringProperty email;
    private final StringProperty startDate;
    private final StringProperty taskDuration;
    private final StringProperty done;



    public Project() {
        this.id = new SimpleStringProperty();
        this.projectName = new SimpleStringProperty();
        this.taskName = new SimpleStringProperty();
        this.responsible = new SimpleStringProperty();
        this.phone = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.startDate = new SimpleStringProperty();
        this.taskDuration = new SimpleStringProperty();
        this.done = new SimpleStringProperty();
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getProjectName() {
        return projectName.get();
    }

    public StringProperty projectNameProperty() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName.set(projectName);
    }

    public String getTaskName() {
        return taskName.get();
    }

    public StringProperty taskNameProperty() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName.set(taskName);
    }

    public String getResponsible() {
        return responsible.get();
    }

    public StringProperty responsibleProperty() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible.set(responsible);
    }

    public String getPhone() {
        return phone.get();
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getStartDate() {
        return startDate.get();
    }

    public StringProperty startDateProperty() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate.set(startDate);
    }

    public String getTaskDuration() {
        return taskDuration.get();
    }

    public StringProperty taskDurationProperty() {
        return taskDuration;
    }

    public void setTaskDuration(String taskDuration) {
        this.taskDuration.set(taskDuration);
    }

    public String getDone() {
        return done.get();
    }

    public StringProperty doneProperty() {
        return done;
    }

    public void setDone(String done) {
        this.done.set(done);
    }
}
