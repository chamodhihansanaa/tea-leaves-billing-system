package lk.ijse.teleleavesbilling.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.teleleavesbilling.model.Collector;
import lk.ijse.teleleavesbilling.model.Payment;
import lk.ijse.teleleavesbilling.model.Price;
import lk.ijse.teleleavesbilling.repository.PaymentRepo;
import lk.ijse.teleleavesbilling.repository.PriceRepo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    private List<Collector> itemsList = new ArrayList<>();
    private List<Collector> priceList;

    public void initialize() {
        this.priceList = getAllItems();
        setCellValueFactory();
        loadPriceTable();
    }

    private void setCellValueFactory() {

    }

    private void loadPriceTable() {
    }

    private List<Collector> getAllItems() {
        return null;
    }


    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtDuration.setText("");
        txtCategory.setText("");
        txtKGPrice.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String duration = txtDuration.getText();

        boolean isDeleted = PriceRepo.delete(duration);
        if (isDeleted) {
            new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String duration = txtDuration.getText();
        String category = txtCategory.getText();
        String kgprice = txtKGPrice.getText();


        Price price = new Price(duration, category, kgprice);

        boolean isSaved = PriceRepo.save(price);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String duration = txtDuration.getText();
        String category = txtCategory.getText();
        String kgprice = txtKGPrice.getText();


        Price price = new Price(duration, category, kgprice);

        boolean isUpdated = PriceRepo.update(price);
        if (isUpdated) {
            new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
        }
    }

}
