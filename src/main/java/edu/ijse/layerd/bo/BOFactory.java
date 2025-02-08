package edu.ijse.layerd.bo;


import edu.ijse.layerd.bo.custom.DashboardBO;
import edu.ijse.layerd.bo.custom.impl.CustomerBOimpl;
import edu.ijse.layerd.bo.custom.impl.DashboardBOimpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }
    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory():boFactory;
    }

    public enum BOTypes{   //factory design pattern
        Dashboard,Customer

    }

    public SuperBO getTypes(BOTypes boTypes){
        switch (boTypes){
            case Dashboard:
                return new DashboardBOimpl();
            case Customer:
                return new CustomerBOimpl();
            default:
                return null;
        }
    }

}
