package lk.ijse.teleleavesbilling.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.teleleavesbilling.model.Employee;
import lk.ijse.teleleavesbilling.model.Orders;
import lk.ijse.teleleavesbilling.repository.EmployeeRepo;
import lk.ijse.teleleavesbilling.repository.OrdersRepo;

import java.sql.SQLException;

public class OrdersFormController {

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
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableColumn<?, ?> colQuantity;

    @FXML
    private TableView<?> tblOrders;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtOrderID;

    @FXML
    private TextField txtQuantity;

    @FXML
    private TextField txtSearch;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtOrderID.setText("");
        txtAddress.setText("");
        txtQuantity.setText("");
        txtDate.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String orderid = txtOrderID.getText();

        try {
            boolean isDeleted = OrdersRepo.delete(orderid);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String orderid = txtOrderID.getText();
        String address = txtAddress.getText();
        String quantity = txtQuantity.getText();
        String date = txtDate.getText();

        Orders orders = new Orders(orderid, address, quantity, date);

        try {
            boolean isSaved = OrdersRepo.save(orders);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String orderid = txtOrderID.getText();

        try {
            Orders orders = OrdersRepo.searchByOrderID(orderid);

            if (orders != null) {
                txtOrderID.setText(orders.getOR_ID());
                txtAddress.setText(orders.getAddress());
                txtQuantity.setText(orders.getQuantity());
                txtDate.setText(orders.getDate());
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String orderid = txtOrderID.getText();
        String address= txtAddress.getText();
        String quantity = txtQuantity.getText();
        String date = txtDate.getText();

        Employee employee = new Employee(orderid, address, quantity, date);

        try {
            boolean isUpdated = OrdersRepo.update(orders);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}
