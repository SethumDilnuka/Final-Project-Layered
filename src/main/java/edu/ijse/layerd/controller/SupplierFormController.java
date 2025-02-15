package edu.ijse.layerd.controller;

import com.jfoenix.controls.JFXButton;
import com.lowagie.text.Row;
import edu.ijse.layerd.bo.BOFactory;
import edu.ijse.layerd.bo.custom.SupplierBO;
import edu.ijse.layerd.dto.SupplierDto;
import edu.ijse.layerd.dto.tm.SupplierTm;
import edu.ijse.layerd.util.Navigation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


import java.sql.SQLException;
import java.util.List;
import java.util.function.Predicate;

public class SupplierFormController {

    SupplierBO supplierBO = (SupplierBO) BOFactory.getBoFactory().getTypes(BOFactory.BOTypes.Supplier);

    @FXML
    private TextField txtSearchID;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colLocation;

    @FXML
    private TableColumn<?, ?> colMobile;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtName;

    @FXML
    private TableView<SupplierTm> tblSupplier;

    @FXML
    private JFXButton btnBooking;

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnDelivery;

    @FXML
    private JFXButton btnEmployee;

    @FXML
    private JFXButton btnItem;

    @FXML
    private JFXButton btnLogOut;

    @FXML
    private JFXButton btnOrder;

    @FXML
    private JFXButton btnReport;


    @FXML
    void bntBookingOnAction(ActionEvent event) {
        btnBooking.getScene().getWindow().hide();
        Navigation.changeStage("/view/bookingForm.fxml","Booking Form");
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {

         txtId.clear();
         txtName.clear();
         txtLocation.clear();
         txtMobile.clear();
         txtEmail.clear();
         txtSearchID.clear();
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) {
        btnCustomer.getScene().getWindow().hide();
        Navigation.changeStage("/view/customerForm.fxml","Customer Form");
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        btnDashboard.getScene().getWindow().hide();
        Navigation.changeStage("/view/dashboardForm.fxml","Dashboard Form");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();
        try {
            boolean isDeleted = supplierBO.deleteSupplier(id);
            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Supplier Deleted Successfully").show();
                loadAllsuppliers();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeliveryOnAction(ActionEvent event) {
        btnDelivery.getScene().getWindow().hide();
        Navigation.changeStage("/view/deliveryForm.fxml","Delivery Form");
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) {
        btnEmployee.getScene().getWindow().hide();
        Navigation.changeStage("/view/employeeForm.fxml","Employee Form");
    }

    @FXML
    void btnItemOnAction(ActionEvent event) {
        btnItem.getScene().getWindow().hide();
        Navigation.changeStage("/view/itemForm.fxml","Item Form");
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        btnLogOut.getScene().getWindow().hide();
        Navigation.changeStage("/view/loginPageForm.fxml","Login Form");
    }

    @FXML
    void btnOrderOnAction(ActionEvent event) {
        btnOrder.getScene().getWindow().hide();
        Navigation.changeStage("/view/placeOrderForm.fxml","Place Order Form");
    }

    @FXML
    void btnReportOnAction(ActionEvent event) {
        btnReport.getScene().getWindow().hide();
        Navigation.changeStage("/view/reportForm.fxml","Report Form");
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws ClassNotFoundException {
        String id = txtId.getText();
        String name = txtName.getText();
        String location = txtLocation.getText();
        String mobile = txtMobile.getText();
        String email = txtEmail.getText();
        SupplierDto dto = new SupplierDto(id,name,location,mobile,email);


        try {
            boolean isSaved = supplierBO.saveSupplier(dto);
            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Supplier Saved Successfully").show();
                loadAllsuppliers();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtId.getText();
        String name = txtName.getText();
        String location = txtLocation.getText();
        String mobile = txtMobile.getText();
        String email = txtEmail.getText();

        SupplierDto dto = new SupplierDto(id,name,location,mobile,email);

        boolean isUpdated = supplierBO.updateSupplier(dto);
        if(isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION,"Supplier Updated Successdully");
            loadAllsuppliers();
        }
    }
    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactory();
        loadAllsuppliers();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("company_name"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    private void loadAllsuppliers() throws SQLException, ClassNotFoundException {
        ObservableList<SupplierTm>  obList = FXCollections.observableArrayList();

        List<SupplierDto> list = supplierBO.getAllSuppliers();
        for(SupplierDto dto : list){
            SupplierTm supplierTm = new SupplierTm(
                    dto.getId(),
                    dto.getCompany_name(),
                    dto.getLocation(),
                    dto.getMobile(),
                    dto.getEmail()
            );
            obList.add(supplierTm);
        }
        tblSupplier.setItems(obList);
    }

    public void txtSearch(KeyEvent keyEvent) throws SQLException {

    }

    public void onclick(MouseEvent mouseEvent) {

        TablePosition pos = tblSupplier.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        // Get the data from the selected row
        Row tblEmployee;
        ObservableList<TableColumn<SupplierTm, ?>> columns = tblSupplier.getColumns();

        txtId.setText(columns.get(0).getCellData(row).toString());
        txtName.setText(columns.get(1).getCellData(row).toString());
        txtLocation.setText(columns.get(2).getCellData(row).toString());
        txtMobile.setText(columns.get(3).getCellData(row).toString());
        txtEmail.setText(columns.get(4).getCellData(row).toString());
    }
}
