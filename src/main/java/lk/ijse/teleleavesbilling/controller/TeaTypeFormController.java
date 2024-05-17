package lk.ijse.teleleavesbilling.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.teleleavesbilling.model.Employee;
import lk.ijse.teleleavesbilling.model.Price;
import lk.ijse.teleleavesbilling.model.TeaSupplier;
import lk.ijse.teleleavesbilling.model.TeaType;
import lk.ijse.teleleavesbilling.repository.EmployeeRepo;
import lk.ijse.teleleavesbilling.repository.PriceRepo;
import lk.ijse.teleleavesbilling.repository.TeaTypeRepo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeaTypeFormController {

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
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colTeaID;

    @FXML
    private TableView<?> tblTeaType;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtTeaID;
    private List<TeaType> teatypeList = new ArrayList<>();
    private Object teaSupplierList;

    public void initialize() {
        this.teaSupplierList = getAllEmployee();
        setCellValueFactory();
        loadTeaSupplierTable();
    }

    private void setCellValueFactory() {

    }

    private void loadTeaSupplierTable() {

    }

    private Object getAllEmployee() {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtTeaID.setText("");
        txtCategory.setText("");
        txtPrice.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String teaid = txtTeaID.getText();

        try {
            boolean isDeleted = TeaTypeRepo.delete(teaid);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String teaid = txtTeaID.getText();
        String category = txtCategory.getText();
        String price = txtPrice.getText();


        TeaType teatype = new TeaType(teaid, category, price);

        try {
            boolean isSaved = TeaTypeRepo.save(teatype);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String teaid = txtTeaID.getText();

        try {
            TeaType teatype = TeaTypeRepo.searchByTeaID(teaid);

            if (TeaType != null) {
                txtTeaID.setText(teatype.getTea_ID());
                txtCategory.setText(teatype.getTea_Category());
                txtPrice.setText(teatype.getPrice());

            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String teaid = txtTeaID.getText();
        String category = txtCategory.getText();
        String price = txtPrice.getText();


        TeaType teatype = new TeaType(teaid, category, price);

        try {
            boolean isUpdated = TeaTypeRepo.update(teaid);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}
