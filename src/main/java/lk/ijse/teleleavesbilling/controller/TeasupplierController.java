package lk.ijse.teleleavesbilling.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import lk.ijse.teleleavesbilling.model.Collector;
import lk.ijse.teleleavesbilling.model.TeaSupplier;
import lk.ijse.teleleavesbilling.repository.TeaSupplierRepo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    private List<TeaSupplier> teaSupplierList = new ArrayList<>();

    public void initialize() {
        this.teaSupplierList = getAllEmployee();
        setCellValueFactory();
        loadTeaSupplierTable();
    }

    private void setCellValueFactory() {

    }

    private void loadTeaSupplierTable() {
    }

    private List<TeaSupplier> getAllEmployee() {
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        TS_ID.setText("");
        TS_NAME.setText("");
        TS_ADDRESS.setText("");
        TS_CONTACT.setText("");
    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String tsid = TS_ID.getText();

        boolean isDeleted = TeaSupplierRepo.delete(tsid);
        if (isDeleted) {
            new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
        }
    }


    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String tsid = TS_ID.getText();
        String name = TS_NAME.getText();
        String address = TS_ADDRESS.getText();
        String contact = TS_CONTACT.getText();

        TeaSupplier teasupplier = new TeaSupplier(tsid, name, address, contact);

        boolean isSaved = TeaSupplierRepo.save(teasupplier);
        if (isSaved) {
            new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
        }


    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String tsid = TS_ID.getText();
        String name = TS_NAME.getText();
        String address = TS_ADDRESS.getText();
        String contact = TS_CONTACT.getText();

        TeaSupplier teasupplier = new TeaSupplier(tsid, name, address, contact);

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


