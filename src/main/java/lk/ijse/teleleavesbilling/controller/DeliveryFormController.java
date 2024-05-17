package lk.ijse.teleleavesbilling.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.teleleavesbilling.model.Delivery;
import lk.ijse.teleleavesbilling.model.Employee;
import lk.ijse.teleleavesbilling.repository.DeliveryRepo;
import lk.ijse.teleleavesbilling.repository.EmployeeRepo;

import java.sql.SQLException;

public class DeliveryFormController {

    @FXML
    private TextField btnAddress;

    @FXML
    private Button btnClear;

    @FXML
    private TextField btnCode;

    @FXML
    private TextField btnDate;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField btnPrice;

    @FXML
    private Button btnSave;

    @FXML
    private TextField btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableView<?> tblDelivery;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtCode.setText("");
        txtPrice.setText("");
        txtDate.setText("");
        txtAddress.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String code = txtCode.getText();

        try {
            boolean isDeleted = DeliveryRepo.delete(code);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String code = txtCode.getText();
        String price = txtPrice.getText();
        String date = txtDate.getText();
        String address = txtAddress.getText();

        Delivery delivery = new Delivery(code, price,date,address);

        try {
            boolean isSaved = DeliveryRepo.save(delivery);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String code = txtCode.getText();

        try {
            Delivery delivery = DeliveryRepo.searchByCode(code);

            if (delivery != null) {
                txtCode.setText(delivery.getCode());
                txtPrice.setText(delivery.getPrice());
                txtDate.setText(delivery.getDate());
                txtAddress.setText(delivery.getAddress());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String code = txtCode.getText();
        String price= txtPrice.getText();
        String date = txtDate.getText();
        String address = txtAddress.getText();

        Delivery delivery = new Delivery(code, price,date,address);

        try {
            boolean isUpdated = DeliveryRepo.update(delivery);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}
