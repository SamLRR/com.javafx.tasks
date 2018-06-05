package view;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.DBUtil;
import model.Project;

public class ProjectOverviewController {
    @FXML
    private TableView projectTable = new TableView();
    @FXML
    private TableColumn<Project, String> idColumn;
    @FXML
    private TableColumn<Project, String> projectNameColumn;

    @FXML
    private TableColumn<Project, String> taskNameColumn;

    @FXML
    private TableColumn<Project, String> responsibleColumn;

    @FXML
    private TableColumn<Project, String> phoneColumn;

    @FXML
    private TableColumn<Project, String> emailColumn;

    @FXML
    private TableColumn<Project, String> startDateColumn;

    @FXML
    private TableColumn<Project, String> taskDuratonColumn;

    @FXML
    private TableColumn<Project, String> doneColumn;

    public ProjectOverviewController() {
    }

    @FXML
    void showAllProjects() {
        ObservableList<Project> projectsData = DBUtil.searchProjects("SELECT * FROM tasks");
        projectTable.setItems(projectsData);
    }

    @FXML
    private void projectsInWork() {
        ObservableList<Project> projectsData = DBUtil.searchProjects("SELECT * FROM tasks WHERE done=0");
        projectTable.setItems(projectsData);
    }

    @FXML
    private void countTaskOfCurrentProjectIsNotDone() {
        ObservableList<Project> projectsData = DBUtil.searchProjects("SELECT * FROM tasks WHERE  done=0");
        projectTable.setItems(projectsData);
    }

    @FXML
    private void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        projectNameColumn.setCellValueFactory(cellData -> cellData.getValue().projectNameProperty());
        taskNameColumn.setCellValueFactory(cellData -> cellData.getValue().taskNameProperty());
        responsibleColumn.setCellValueFactory(cellData -> cellData.getValue().responsibleProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        startDateColumn.setCellValueFactory(cellData -> cellData.getValue().startDateProperty());
        taskDuratonColumn.setCellValueFactory(cellData -> cellData.getValue().taskDurationProperty());
        doneColumn.setCellValueFactory(cellData -> cellData.getValue().doneProperty());
    }
}
