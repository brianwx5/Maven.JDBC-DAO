package daos;

import Utils.DBUtils;
import models.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO extends DAO<Car> {
    private static final String INSERT = "Insert into car" +
            "(id,make, model, year, color, vin)" +
            "values(?,?,?,?,?,?)";
    private static final String GET_ONE = "SELECT * FROM car WHERE id = ?";
    private static final String GET_ALL = "SELECT * FROM car";
    private static final String UPDATE = "Update car set make = ?, model = ?, year = ?, " +
            "color = ?, vin = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM car WHERE id = ?";



    public CarDAO(Connection conn) {
        super(conn);
    }


    public Car findById(int id) {
        Car car = null;
        try (PreparedStatement pstmt = DBUtils.getConnection().prepareStatement(GET_ONE)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                car = new Car();
                car.setId(rs.getInt("Id"));
                car.setMake(rs.getString("Make"));
                car.setModel(rs.getString("Model"));
                car.setYear(rs.getInt("Year"));
                car.setColor(rs.getString("Color"));
                car.setVin(rs.getString("Vin"));

            }
        } catch (SQLException e) {
            DBUtils.showErrorMessage(e);
        }
        return car;
    }


    public List<Car> findAll() {
        List<Car> carList = new ArrayList<>();
        Car car = null;
        try (PreparedStatement pstmt = DBUtils.getConnection().prepareStatement(GET_ALL)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                car = new Car();
                car.setId(rs.getInt("Id"));
                car.setMake(rs.getString("Make"));
                car.setModel(rs.getString("Model"));
                car.setYear(rs.getInt("Year"));
                car.setColor(rs.getString("Color"));
                car.setVin(rs.getString("Vin"));
                carList.add(car);
            }
        } catch (SQLException e) {
            DBUtils.showErrorMessage(e);
        }

        for (int i = 1; i < carList.size() ; i++) {
            carList.get(i).toString();
        }
        return carList;
    }


    public Car update(Car dto) {
        Car car = null;
        try (PreparedStatement psmnt = this.connection.prepareStatement(UPDATE)) {
            psmnt.setInt(1, dto.getId());
            psmnt.setString(2, dto.getMake());
            psmnt.setString(3, dto.getModel());
            psmnt.setInt(4, dto.getYear());
            psmnt.setString(5, dto.getColor());
            psmnt.setString(6, dto.getVin());
            psmnt.executeUpdate();
            car = this.findById(dto.getId());
        } catch (SQLException e) {
            DBUtils.showErrorMessage(e);
        }
        return car;
    }


    public Car create(Car dto) {
        int key = -1;
        try(PreparedStatement psmnt = this.connection.prepareStatement(INSERT,PreparedStatement.RETURN_GENERATED_KEYS)) {
            psmnt.setInt(1,dto.getId());
            psmnt.setString(2,dto.getMake());
            psmnt.setString(3,dto.getModel());
            psmnt.setInt(4,dto.getYear());
            psmnt.setString(5,dto.getColor());
            psmnt.setString(6,dto.getVin());
            psmnt.executeUpdate();

            ResultSet rs = psmnt.getGeneratedKeys();

            if(rs != null && rs.next()) {
                key = rs.getInt(1);
            }
        }

        catch (SQLException e) {
            DBUtils.showErrorMessage(e);
        }
        return this.findById(key);
    }


    public void delete(int id) {
        try (PreparedStatement psmnt = this.connection.prepareStatement(DELETE)) {
            psmnt.setInt(1, id);
            psmnt.executeUpdate();
        } catch (SQLException e) {
            DBUtils.showErrorMessage(e);
        }
    }
}

