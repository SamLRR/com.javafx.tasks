package model;

import com.sun.rowset.CachedRowSetImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DBUtil {
    private static Connection connection;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:task.db");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ObservableList<Project> searchProjects(String selectStmt) {
        ResultSet rs = null;
        try {
            rs = dbExecuteQuery(selectStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ObservableList<Project> projectList = getProjectList(rs);
        return projectList;
    }

    private static ObservableList<Project> getProjectList(ResultSet rs) {
        ObservableList<Project> empList = FXCollections.observableArrayList();

        try {
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getString(1));
                project.setProjectName(rs.getString(2));
                project.setTaskName(rs.getString(3));
                project.setResponsible(rs.getString(4));
                project.setPhone(rs.getString(5));
                project.setEmail(rs.getString(6));
                project.setStartDate(rs.getString(7));
                project.setTaskDuration(rs.getString(8));
                project.setDone(rs.getString(9));
                empList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empList;
    }

    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException {
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            connect();
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery(queryStmt);
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
        }
        return crs;
    }
}
