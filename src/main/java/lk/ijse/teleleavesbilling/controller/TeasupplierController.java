package lk.ijse.teleleavesbilling.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import lk.ijse.teleleavesbilling.model.TeaSupplier;
import lk.ijse.teleleavesbilling.repository.TeaSupplierRepo;

import java.sql.SQLException;

public class TeasupplierController {

    @FXML
    private TextField TEXT;

    @FXML
    private TextField TS_ADDRESS;

    @FXML
    private TextField TS_CONTACT;

    @FXML
    private TextField TS_ID;

    @FXML
    private TextField TS_NAME;

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
    private TableColumn<?, ?> colContactNo;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTS_ID;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtTS_ID.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtContact.setText("");
    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String ts_id = txtTS_ID.getText();

        try {
            boolean isDeleted = TeaSupplierRepo.delete(ts_id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }


    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String ts_id = txtTS_ID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();

        TeaSupplier teasupplier = new TeaSupplier(ts_id, name, address, contact);

        try {
            boolean isSaved = TeaSupplierRepo.save(teasupplier);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }



    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String ts_id = txtTS_ID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();

        TeaSupplier teasupplier = new TeaSupplier(ts_id, name, address, contact);

        try {
            boolean isUpdated = TeaSupplierRepo.update(teasupplier);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    }


