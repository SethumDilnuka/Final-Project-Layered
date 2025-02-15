package edu.ijse.layerd.dao;


import edu.ijse.layerd.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory(){
       return  (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        Dashboard, CUSTOMER ,EMPLOYEE , SUPPLIER ,ITEM , BOOKING , USER , DELIVERY ,PLACEORDER
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case Dashboard:

            case CUSTOMER:
                return new CustomerDAOIMPL();

                case EMPLOYEE:
                    return new EmployeeDAoimpl();

                    case SUPPLIER:
                        return new SupplierDAOimpl();

            case ITEM:
                return new ItemDAOimpl();
                //return new DashboardDAOImpl();

            case BOOKING:
                return new BookingDAOimpl();

            case USER:
                return new UserDAOimpl();

            case DELIVERY:
                return new DeliveryDAOimpl();

            case PLACEORDER:
                return new PlaceOrderDAOimpl();
            default:
                return null;
        }
    }
}
