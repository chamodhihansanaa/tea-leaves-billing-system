package lk.ijse.teleleavesbilling.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.teleleavesbilling.model.Payment;
import lk.ijse.teleleavesbilling.model.Price;
import lk.ijse.teleleavesbilling.repository.PaymentRepo;
import lk.ijse.teleleavesbilling.repository.PriceRepo;

import java.sql.SQLException;

public class PriceFormController {

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
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colKGPrice;

    @FXML
    private TableView<?> tblPrice;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtKGPrice;

    @FXML
    private TextField txtSearch;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtDuration.setText("");
        txtCategory.setText("");
        txtKGPrice.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String duration = txtDuration.getText();

        try {
            boolean isDeleted = PriceRepo.delete(duration);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String duration = txtDuration.getText();
        String category = txtCategory.getText();
        String kgprice = txtKGPrice.getText();


        Price price = new Price(duration, category, kgprice);

        try {
            boolean isSaved = PriceRepo.save(price);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String duration = txtDuration.getText();
        String category = txtCategory.getText();
        String kgprice = txtKGPrice.getText();


        Price price = new Price(duration, category, kgprice);

        try {
            boolean isUpdated = PriceRepo.update(price);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}
