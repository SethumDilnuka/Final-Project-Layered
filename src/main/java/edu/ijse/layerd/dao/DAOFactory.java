package edu.ijse.layerd.dao;


import edu.ijse.layerd.dao.custom.impl.CustomerDAOIMPL;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory(){
       return  (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        Dashboard, CUSTOMER
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case Dashboard:

            case CUSTOMER:
                return new CustomerDAOIMPL();
                //return new DashboardDAOImpl();
            default:
                return null;
        }
    }
}
