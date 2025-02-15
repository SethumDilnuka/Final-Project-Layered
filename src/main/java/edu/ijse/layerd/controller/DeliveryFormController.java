package edu.ijse.layerd.controller;

import com.jfoenix.controls.JFXButton;
import edu.ijse.layerd.bo.BOFactory;
import edu.ijse.layerd.bo.custom.DeliveryBO;
import edu.ijse.layerd.bo.custom.EmployeeBO;
import edu.ijse.layerd.bo.custom.PlaceOrderBO;
import edu.ijse.layerd.dto.DeliveryDto;
import edu.ijse.layerd.dto.EmployeeDto;
import edu.ijse.layerd.dto.tm.DeliveryTm;
import edu.ijse.layerd.util.Navigation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class DeliveryFormController {

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
    private JFXButton btnSupplier;

    @FXML
    private JFXButton btnbooking;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colDeliveryId;

    @FXML
    private TableColumn<?, ?> colDeliveryStatus;

    @FXML
    private TableColumn<?, ?> colEmpId;

    @FXML
    private TableColumn<?, ?> colLocation;

    @FXML
    private TableColumn<?, ?> colOrderId;

    @FXML
    private TableView<DeliveryTm> tblDelivery;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtDeliversyStatus;

    @FXML
    private TextField txtDeliveryId;

    @FXML
    private TextField txtEmpId;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtlocation;

    @FXML
    private ComboBox<String> cmbEmpId;

    @FXML
    private ComboBox<String> cmbOrderId;

    DeliveryBO deliveryBO = (DeliveryBO) BOFactory.getBoFactory().getTypes(BOFactory.BOTypes.Delivery);
    EmployeeBO employeeBO = (EmployeeBO) BOFactory.getBoFactory().getTypes(BOFactory.BOTypes.EMPLOYEE);
    PlaceOrderBO placeOrderBO = (PlaceOrderBO) BOFactory.getBoFactory().getTypes(BOFactory.BOTypes.Order);
    @FXML
    private DatePicker pickerDate;
    private LocalDate none;


    @FXML
    void btnBookingOnAction(ActionEvent event) {
        btnbooking.getScene().getWindow().hide();
        Navigation.changeStage("/view/bookingForm.fxml","Booking Form");
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFileds();
    }

    private void clearFileds() {
        txtDeliveryId.clear();
        cmbOrderId.setValue(null);
        cmbEmpId.setValue(null);
        txtDeliversyStatus.clear();
        txtlocation.clear();
        pickerDate.setValue(none);
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) {
        btnCustomer.getScene().getWindow().hide();
        Navigation.changeStage("/view/customerForm.fxml","Customer Form");
    }

    @FXML
    void btnDashboardAction(ActionEvent event) {
        btnDashboard.getScene().getWindow().hide();
        Navigation.changeStage("/view/dashboardForm.fxml","Dashboard Form");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtDeliveryId.getText();
        try {
            boolean isDeleted = deliveryBO.deleteDelivery(id);
            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Delivery Deleted Successfully").show();
                loadAllDeliveries();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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
    void btnLogoutOnAction(ActionEvent event) {
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
    void btnSaveOnAction(ActionEvent event) {
        String id = txtDeliveryId.getText();
        String order_id = cmbOrderId.getValue();
        String emp_id = cmbEmpId.getValue();
        String status = txtDeliversyStatus.getText();
        String location = txtlocation.getText();
        String date = String.valueOf(pickerDate.getValue());
        DeliveryDto dto = new DeliveryDto(id,order_id,emp_id,status,location,date);


        try {
            boolean isSaved = deliveryBO.saveDelivery(dto);
            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Delivery Saved Successfully").show();
                loadAllDeliveries();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) {
        btnSupplier.getScene().getWindow().hide();
        Navigation.changeStage("/view/supplierForm.fxml","Supplier Form");
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtDeliveryId.getText();
        String order_id = cmbOrderId.getValue();
        String emp_id = cmbEmpId.getValue();
        String status = txtDeliversyStatus.getText();
        String location = txtlocation.getText();
        String date = String.valueOf(pickerDate.getValue());
        DeliveryDto dto = new DeliveryDto(id,order_id,emp_id,status,location,date);

        try {
            boolean isUpdated = deliveryBO.updateDelivery(dto);
            if(isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION,"Delivery Updated Successfully").show();
                loadAllDeliveries();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btndeliveryOnAction(ActionEvent event) {
        btnDelivery.getScene().getWindow().hide();
        Navigation.changeStage("/view/deliveryForm.fxml","Delivery Form");
    }
    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactory();
        loadAllDeliveries();
        loadEmployeeId();
        loadOrderId();


//        txtDeliveryId.setText(deliveryModel.generateNextDeliverId());
    }

    private void setCellValueFactory() {
        colDeliveryId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colOrderId.setCellValueFactory(new PropertyValueFactory<>("order_id"));
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("emp_id"));
        colDeliveryStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));

    }

    private void loadAllDeliveries() {
        ObservableList<DeliveryTm> obList = FXCollections.observableArrayList();
        try {
            List<DeliveryDto> list =  deliveryBO.getAllDeliveries();
            for(DeliveryDto dto:list ){
                DeliveryTm deliveryTm = new DeliveryTm(
                        dto.getId(),
                        dto.getOrder_id(),
                        dto.getEmp_id(),
                        dto.getStatus(),
                        dto.getLocation(),
                        dto.getDate()
                );
                obList.add(deliveryTm);
            }
            tblDelivery.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadEmployeeId() throws SQLException, ClassNotFoundException {

        List<EmployeeDto> employeeDtos = employeeBO.getAllEmployees();
        ObservableList<String> employeeData = FXCollections.observableArrayList();
        for (EmployeeDto employeeDto : employeeDtos) {
            employeeData.add(employeeDto.getId());
        }
        cmbEmpId.setItems(employeeData);

        /*ObservableList<String> employeeData = employeeModel.loadEmployeeID();
        cmbEmpId.setItems(employeeData);*/
    }

    public void loadOrderId() throws SQLException {

        ObservableList<String> orderData = placeOrderBO.loadOrderId();
        cmbOrderId.setItems(orderData);
    }

}
