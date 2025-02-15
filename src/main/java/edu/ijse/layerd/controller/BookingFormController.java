package edu.ijse.layerd.controller;


import com.jfoenix.controls.JFXButton;
import edu.ijse.layerd.bo.BOFactory;
import edu.ijse.layerd.bo.custom.BookingBO;
import edu.ijse.layerd.dto.BookingDto;
import edu.ijse.layerd.dto.tm.BookingTm;
import edu.ijse.layerd.util.Navigation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.sql.SQLException;
import java.util.List;

public class BookingFormController {

    BookingBO bookingBO = (BookingBO) BOFactory.getBoFactory().getTypes(BOFactory.BOTypes.Booking);

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
    private JFXButton btnSupplier;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colCusId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colTblName;

    @FXML
    private TableView<BookingTm> tblBooking;

    @FXML
    private TextField txtBookiId;

    @FXML
    private TextField txtCustomerId;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtNic;

    @FXML
    private TextField txtTblName;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnBookingOnAction(ActionEvent event) {
        btnBooking.getScene().getWindow().hide();
        Navigation.changeStage("/view/bookingForm.fxml","Booking Form");
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtBookiId.clear()  ;
        txtDate.clear();
        txtNic.clear();
        txtTblName.clear();
        txtCustomerId.clear();
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
    void btnNewCustomerOnAction(ActionEvent event) {

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
        String id = txtBookiId.getText();
        String c_id = txtCustomerId.getText();
        String nic = txtNic.getText();
        String date = txtDate.getText();
        String table_name = txtTblName.getText();
        BookingDto dto = new BookingDto(id,c_id,nic,date,table_name);



        try {
            boolean isSaved = bookingBO.saveBooking(dto);
            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Booking Saved Successfully").show();
                loadAllBookings();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSupplierOnAaction(ActionEvent event) {
        btnSupplier.getScene().getWindow().hide();
        Navigation.changeStage("/view/supplierForm.fxml","Supplier Form");
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtBookiId.getText();
        String c_id = txtCustomerId.getText();
        String nic = txtNic.getText();
        String date = txtDate.getText();
        String table_name = txtTblName.getText();
        BookingDto dto = new BookingDto(id,c_id,nic,date,table_name);

        try {
            boolean isUpdated = bookingBO.updateBooking(dto);
            if(isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION,"Booking Updated Successfully").show();
                loadAllBookings();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtBookiId.getText();
        try {
            boolean isDeleted = bookingBO.deleteBooking(id);
            if(isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Bokking deleted Succesfully").show();
                loadAllBookings();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void initialize(){
        setCellValueFactory();
        loadAllBookings();
    }

    private void setCellValueFactory() {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCusId.setCellValueFactory(new PropertyValueFactory<>("c_id"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTblName.setCellValueFactory(new PropertyValueFactory<>("table_name"));
    }

    private void loadAllBookings() {
        ObservableList<BookingTm> obList = FXCollections.observableArrayList();
        try {
            List<BookingDto> list = bookingBO.getAllBookings();
            for(BookingDto dto : list){
                BookingTm bookingTm = new BookingTm(
                        dto.getId(),
                        dto.getC_id(),
                        dto.getNic(),
                        dto.getDate(),
                        dto.getTable_name()
                );
                obList.add(bookingTm);
            }
            tblBooking.setItems(obList);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
