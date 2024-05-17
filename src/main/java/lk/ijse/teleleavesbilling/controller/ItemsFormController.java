package lk.ijse.teleleavesbilling.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.teleleavesbilling.model.Employee;
import lk.ijse.teleleavesbilling.model.Items;
import lk.ijse.teleleavesbilling.repository.EmployeeRepo;
import lk.ijse.teleleavesbilling.repository.ItemsRepo;

import java.sql.SQLException;

public class ItemsFormController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private TextField btnDescription;

    @FXML
    private TextField btnItemID;

    @FXML
    private TextField btnPrice;

    @FXML
    private Button btnSave;

    @FXML
    private TextField btnSearch;

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
    void btnClearOnAction(ActionEvent event) {
        txtI_ID.setText("");
        txtDescription.setText("");
        txtPrice.setText("");


    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String i_id = txtI_ID.getText();

            try {
                boolean isDeleted = ItemsRepo.delete(i_id);
                if (isDeleted) {
                    new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String i_id = txtI_ID.getText();
        String description = txtDescription.getText();
        String price = txtPrice.getText();


        Items items = new Items(i_id, description, price);

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
        String i_id = txtI_ID.getText();

        try {
            Items items = ItemsRepo.searchByI_ID(i_id);

            if (items != null) {
                txtI_ID.setText(items.getI_ID());
                txtDescription.setText(items.getDescription());
                txtPrice.setText(items.getPrice());

            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String i_id = txtI_ID.getText();
        String description = txtDescription.getText();
        String price = txtPrice.getText();


        Items items = new Items(i_id, description, price);

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

