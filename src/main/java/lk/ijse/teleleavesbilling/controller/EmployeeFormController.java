package lk.ijse.teleleavesbilling.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.teleleavesbilling.model.Employee;
import lk.ijse.teleleavesbilling.repository.EmployeeRepo;

import java.sql.SQLException;

public class EmployeeFormController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colEMP_ID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableView<?> tblEmployee;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtEMP_ID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtSearch;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtEMP_ID.setText("");
        txtName.setText("");
        txtSalary.setText("");
        txtDate.setText("");

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String emp_id = txtEMP_ID.getText();

        try {
            boolean isDeleted = EmployeeRepo.delete(emp_id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String emp_id = txtEMP_ID.getText();
        String name = txtName.getText();
        String salary = txtSalary.getText();
        String date = txtDate.getText();

        Employee employee = new Employee(emp_id, name, salary, date);

        try {
            boolean isSaved = EmployeeRepo.save(employee);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String id = txtEMP_ID.getText();

        try {
            Employee employee = EmployeeRepo.searchByEMP_ID(emp_id);

            if (employee != null) {
                txtEMP_ID.setText(employee.getEMP_ID());
                txtName.setText(employee.getName());
                txtSalary.setText(employee.getSalary());
                txtDate.setText(employee.getDate());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String emp_id = txtEMP_ID.getText();
        String name = txtName.getText();
        String salary = txtSalary.getText();
        String date = txtDate.getText();

        Employee employee = new Employee(emp_id, name, salary, date);

        try {
            boolean isUpdated = EmployeeRepo.update(employee);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}
