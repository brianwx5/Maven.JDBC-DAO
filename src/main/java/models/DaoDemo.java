package models;

import Utils.DBUtils;
import daos.CarDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoDemo {
    public static void main(String[] args) {

        try(Connection conn = DBUtils.getConnection()) {
            CarDAO carDAO = new CarDAO(conn);

            //Creating a car
            Car createdCar = new Car();
            createdCar.setMake("Nissan");
            createdCar.setModel("Maxima");
            createdCar.setYear(2019);
            createdCar.setColor("Blue");
            createdCar.setVin("FJ49DVK29FJLOFK34");

            System.out.println(carDAO.create(createdCar));
            //carDAO.delete(7);
            //System.out.println(carDAO.findById(1).getYear());
        }

        catch (SQLException e) {
            DBUtils.showErrorMessage(e);
        }
    }

}
