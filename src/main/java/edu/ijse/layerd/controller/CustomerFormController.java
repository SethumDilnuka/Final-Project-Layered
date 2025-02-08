package edu.ijse.layerd.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.layerd.bo.BOFactory;
import edu.ijse.layerd.bo.custom.CustomerBO;
import edu.ijse.layerd.dto.CustomerDto;
import edu.ijse.layerd.dto.tm.CustomerTm;
import edu.ijse.layerd.util.DataValidateController;
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
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;



public class CustomerFormController {

    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getTypes(BOFactory.BOTypes.Customer);


    @FXML
    private TableColumn<?, ?> ColId;

    @FXML
    private TableColumn<?, ?> colAddres;

    @FXML
    private TableColumn<?, ?> colDob;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colMobile;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableView<CustomerTm> tblCustomer;

    @FXML
    private TextField txtAddress;


    @FXML
    private TextField txtIDseearch;



    @FXML
    private DatePicker pickerDate;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtName;

    @FXML
    private JFXButton btnDelivery;

    @FXML
    private JFXButton btnBooking;

    @FXML
    private JFXButton btnDashboard;

    @FXML
    private JFXButton btnEmployee;

    @FXML
    private JFXButton btnItem;

    @FXML
    private JFXButton btnOrder;

    @FXML
    private JFXButton btnReport;

    @FXML
    private JFXButton btnSupplier;

    @FXML
    private JFXButton btnLogout;


    @FXML
    private Label customerAddressValiidate;

    @FXML
    private Label customerDobValiidate;

    @FXML
    private Label customerEmailValiidate;

    @FXML
    private Label customerIdValiidate;

    @FXML
    private Label customerMobileValiidate;

    @FXML
    private Label customerNameValiidate;


    @FXML
    void btnDeliveryOnAction(ActionEvent event) {
        btnDelivery.getScene().getWindow().hide();
        Navigation.changeStage("/view/deliveryForm.fxml","Delivery Form");
    }

    @FXML
    void btnEmployeeOnAction(ActionEvent event) {
        System.out.println("emp");
        btnEmployee.getScene().getWindow().hide();
        Navigation.changeStage("/view/employeeForm.fxml","Employee Form");

    }

    @FXML
    void btnItemOnAction(ActionEvent event) {
        btnItem.getScene().getWindow().hide();
        Navigation.changeStage("/view/itemForm.fxml","Item Form");
    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) {
        btnSupplier.getScene().getWindow().hide();
        Navigation.changeStage("/view/supplierForm.fxml","Supplier Form");
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
    void btnDashboardOnAction(ActionEvent event) {
        btnDashboard.getScene().getWindow().hide();
        Navigation.changeStage("/view/dashboardForm.fxml","Dashboard Form");
    }

    @FXML
    void btnBookingOnAction(ActionEvent event) {
        btnBooking.getScene().getWindow().hide();
        Navigation.changeStage("/view/bookingForm.fxml","Booking Form");
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {
        btnLogout.getScene().getWindow().hide();
        Navigation.changeStage("/view/loginPageForm.fxml","Login Form");
    }



    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtAddress.clear();
        pickerDate.setValue(null);
        txtEmail.clear();
        txtId.clear();
        txtMobile.clear();
        txtName.clear();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtId.getText();

        boolean isDeleted = customerBO.deleteCustomer(id);
        if(isDeleted){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Deleted Successfully").show();
            loadAllCustomers();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws ClassNotFoundException {
        if(txtId.getText().isEmpty() || txtAddress.getText().isEmpty()|| txtName.getText().isEmpty()||txtMobile.getText().isEmpty() ||txtEmail.getText().isEmpty()||pickerDate.getValue() == null){
            new Alert(Alert.AlertType.ERROR,"please fill all empty fileds before add new customer !").show();
        }else {
            String id = txtId.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String email = txtEmail.getText();
            String mobile = txtMobile.getText();
            String dob = String.valueOf(pickerDate.getValue());
            CustomerDto dto = new CustomerDto(id,name,address,email,mobile,dob);
              ///////////////////////////////////////////////////////////////////////////// *//*
            if(DataValidateController.customerIdValidate(txtId.getText())){
                customerIdValiidate.setText("");

                if (DataValidateController.customerNameValidate(txtName.getText())) {
                    customerNameValiidate.setText("");

                    if (DataValidateController.addressValidate(txtAddress.getText())){
                        customerAddressValiidate.setText("");

                        if(DataValidateController.contactCheck(txtMobile.getText())){
                            customerMobileValiidate.setText("");

                            if(DataValidateController.emailCheck(txtEmail.getText())){
                                customerEmailValiidate.setText("");
                                try {
                                boolean isSaved =  customerBO.saveCustomer(dto);
                                if(isSaved){
                                    new Alert(Alert.AlertType.CONFIRMATION,"Customer Saved Successfully").show();
                                    loadAllCustomers();
                                }
                            } catch (SQLException e) {
                                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
                            }
                            }else {
                                customerEmailValiidate.setText("Invalid Email");
                            }


                        }else {
                            customerMobileValiidate.setText("Invalid tel.Include 10 charcters !");
                        }

                    }else {
                        customerAddressValiidate.setText("Include atleast 4 characters !");
                    }

                }else{
                    customerNameValiidate.setText("Include atleast 4 characters !");
                }

            }else {
                customerIdValiidate.setText("Invalid customer Id !");
            }

        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String email = txtEmail.getText();
        String mobile = txtMobile.getText();
        String dob = String.valueOf(pickerDate.getValue());
        CustomerDto dto = new CustomerDto(id,name,address,email,mobile,dob);


        boolean isUpdated = customerBO.updateCustomer(dto);
        if(isUpdated){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Updated Successfully").show();
            loadAllCustomers();
        }
    }

      private void setCellValueFactory() {
        ColId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddres.setCellValueFactory(new PropertyValueFactory<>("address"));
        colMobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
    }

    private void loadAllCustomers() {

        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();

        try {
            List<CustomerDto> list =  customerBO.getAllCustomers();
            for(CustomerDto dto :list){
                CustomerTm customerTm = new CustomerTm(
                        dto.getId(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getMobile(),
                        dto.getEmail(),
                        dto.getDob()
                );
                obList.add(customerTm);
            }
            tblCustomer.setItems(obList);


        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void initialize(){
        setCellValueFactory();
        loadAllCustomers();
    }


    public void  txtSearch(KeyEvent keyEvent) throws SQLException, ClassNotFoundException {
//        //CustomerModel customerModel = new CustomerModel()
//        String searchValue = txtIDseearch.getText().trim();
//        ObservableList<CustomerDto> obList = customerBO.getAllCustomers();
//
//        if (!searchValue.isEmpty()) {
//            ObservableList<CustomerDto> filteredData = obList.filtered(new Predicate<CustomerDto>() {
//                @Override
//                public boolean test(CustomerTm customerTM) {
//                    return String.valueOf(customerTM.getId()).toLowerCase().contains(searchValue.toLowerCase());
//                }
//            });
//            tblCustomer.setItems(filteredData);
//        } else {
//            tblCustomer.setItems(obList);
//}
    }

    public void tableClick(MouseEvent mouseEvent) {
        TablePosition pos = tblCustomer.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        // Get the data from the selected row
        ObservableList<TableColumn<CustomerTm, ?>> columns = tblCustomer.getColumns();

        txtId.setText(columns.get(0).getCellData(row).toString());
        txtName.setText(columns.get(1).getCellData(row).toString());
        txtAddress.setText(columns.get(2).getCellData(row).toString());
        txtEmail.setText(columns.get(3).getCellData(row).toString());
        txtMobile.setText(columns.get(4).getCellData(row).toString());
        pickerDate.setValue(LocalDate.parse(columns.get(5).getCellData(row).toString()));
    }
}

