package lk.ijse.teleleavesbilling.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.teleleavesbilling.model.Items;
import lk.ijse.teleleavesbilling.model.Payment;
import lk.ijse.teleleavesbilling.repository.ItemsRepo;
import lk.ijse.teleleavesbilling.repository.PaymentRepo;

import java.sql.SQLException;

public class PaymentFormController {

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

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtPayment_ID.setText("");
        txtPaymentMathod.setText("");
        txtAddress.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String payment_id = txtPayment_ID.getText();

        try {
            boolean isDeleted = PaymentRepo.delete(payment_id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String payment_id = txtPayment_ID.getText();
        String paymentmethod = txtPaymentMethod.getText();
        String address = txtAddress.getText();


        Payment payment = new Payment(payment_id, paymentmethod, address);

        try {
            boolean isSaved = PaymentRepo.save(payment);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String payment_id = txtPayment_ID.getText();
        String paymentmethod = txtPaymentMethod.getText();
        String address = txtAddress.getText();


        Payment payment = new Payment(payment_id, paymentmethod, address);

        try {
            boolean isUpdated = PaymentRepo.update(payment);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}
