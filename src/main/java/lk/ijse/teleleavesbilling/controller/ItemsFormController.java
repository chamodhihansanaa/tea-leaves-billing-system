package lk.ijse.teleleavesbilling.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.teleleavesbilling.model.Collector;
import lk.ijse.teleleavesbilling.model.Employee;
import lk.ijse.teleleavesbilling.model.Items;
import lk.ijse.teleleavesbilling.repository.EmployeeRepo;
import lk.ijse.teleleavesbilling.repository.ItemsRepo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemsFormController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colItem_ID;

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableView<?> tblItems;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemID;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtSearch;
    private List<Collector> itemsList = new ArrayList<>();

    public void initialize() {
        this.itemsList = getAllItems();
        setCellValueFactory();
        loadEmployeeTable();
    }

    private List<Collector> getAllItems() {
        return null;
    }

    private void setCellValueFactory() {

    }

    private void loadEmployeeTable() {

    }




    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtItemID.setText("");
        txtDescription.setText("");
        txtPrice.setText("");

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String itemid = txtItemID.getText();

        try {
            boolean isDeleted = ItemsRepo.delete(itemid);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

            String itemid = txtItemID.getText();
            String description = txtDescription.getText();
            String price = txtPrice.getText();


            Items items = new Items(itemid, description, price);

            try {
                boolean isSaved = ItemsRepo.save(items);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {
        String itemid = txtItemID.getText();

        try {
            Items items = ItemsRepo.searchByI_ID(itemid);

            if (items != null) {
                txtItemID.setText(items.getI_ID());
                txtDescription.setText(items.getDescription());
                txtPrice.setText(items.getPrice());

            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String itemid = txtItemID.getText();
        String description = txtDescription.getText();
        String price = txtPrice.getText();


        Items items = new Items(itemid, description, price);

        try {
            boolean isUpdated = ItemsRepo.update(items);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}
