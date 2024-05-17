package lk.ijse.teleleavesbilling.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.teleleavesbilling.model.Collector;
import lk.ijse.teleleavesbilling.model.Items;
import lk.ijse.teleleavesbilling.model.Payment;
import lk.ijse.teleleavesbilling.repository.ItemsRepo;
import lk.ijse.teleleavesbilling.repository.PaymentRepo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentFormController {

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtPayId;

    @FXML
    private TextField txtPayMethod;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colPaymentMethod;

    @FXML
    private TableColumn<?, ?> colPayment_ID;

    @FXML
    private TableView<?> tblPayment;
    private List<Payment> paymentList = new ArrayList<>();

    public void initialize() {
        this.paymentList = getAllPayment();
        setCellValueFactory();
        loadEmployeeTable();
    }

    private List<Payment> getAllPayment() {
        return null;
    }

    private void setCellValueFactory() {

    }

    private void loadEmployeeTable() {

    }



    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtPayId.setText("");
        txtAddress.setText("");
        txtPayMethod.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String paymentid = txtPayId.getText();

        boolean isDeleted = PaymentRepo.delete(paymentid);
        if (isDeleted) {
            new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String paymentid = txtPayId.getText();
        String paymentmethod = txtPayMethod.getText();
        String address = txtAddress.getText();


        Payment payment = new Payment(paymentid, paymentmethod, address);

        boolean isSaved = PaymentRepo.save(payment);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String paymentid = txtPayId.getText();
        String paymentmethod = txtPayMethod.getText();
        String address = txtAddress.getText();


        Payment payment = new Payment(paymentid, paymentmethod, address);

        boolean isUpdated = PaymentRepo.update(payment);
        if (isUpdated) {
            new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
        }
    }

}
