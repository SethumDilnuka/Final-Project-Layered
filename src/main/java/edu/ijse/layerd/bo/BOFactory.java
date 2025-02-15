package edu.ijse.layerd.bo;


import edu.ijse.layerd.bo.custom.DashboardBO;
import edu.ijse.layerd.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }
    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory():boFactory;
    }

    public enum BOTypes{   //factory design pattern
        Dashboard,Customer,EMPLOYEE ,Supplier,Item,Order,Delivery,Booking,USER

    }

    public SuperBO getTypes(BOTypes boTypes){
        switch (boTypes){
            case Dashboard:
                    return new DashboardBOimpl();
            case Customer:
                    return new CustomerBOimpl();
                case EMPLOYEE:
                    return new EmployeeBOimpl();
            case Supplier:
                    return new SupplierBOimpl();
                case Item:
                    return new ItemBOimpl();

            case Booking:
                    return new BookingBOimpl();

            case USER:
                    return new UserBOimpl();

            case Delivery:
                    return new DeliveryBOimpl();

                    case Order:
                        return new PlaceOrderBOimpl();
            default:
                    return null;
        }
    }

}
