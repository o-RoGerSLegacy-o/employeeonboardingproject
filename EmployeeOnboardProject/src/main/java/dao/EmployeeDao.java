package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbConnection.ConnectionDb;
import entitys.EmployeeEntity;

public class EmployeeDao {
    private Connection conn;

    public EmployeeDao() {
        try {
            this.conn = ConnectionDb.connectDb();
            createTableIfNotExists();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTableIfNotExists() {
        String str1 = "CREATE TABLE IF NOT EXISTS employeeonboard(" +
                "uId BIGINT PRIMARY KEY, " +
                "userName VARCHAR(100), " +
                "designation VARCHAR(100)," +
                "location VARCHAR(100)," +
                "phoneNumber BIGINT," +
                "salary BIGINT)";
        try {
            PreparedStatement pS = conn.prepareStatement(str1);
            pS.execute();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("createTableIfNotExists method error");
        }
    }

    public void insertEmployeeDetails(EmployeeEntity obj) {
        String query = "INSERT INTO employeeonboard(uId, userName, designation, location, phoneNumber, salary) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pS = conn.prepareStatement(query)) {
            pS.setLong(1, obj.getuId());
            pS.setString(2, obj.getUserName());
            pS.setString(3, obj.getDesignation());
            pS.setString(4, obj.getLocation());
            pS.setLong(5, obj.getPhoneNumber());
            pS.setLong(6, obj.getSalary());

            pS.executeUpdate();
            System.out.println("Employee onboarded successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public EmployeeEntity getEmployeeById(long uId) {
        String sql = "SELECT * FROM employeeonboard WHERE uId=?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, uId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                EmployeeEntity emp1 = new EmployeeEntity();
                emp1.setuId(resultSet.getLong("uId"));
                emp1.setUserName(resultSet.getString("userName"));
                emp1.setDesignation(resultSet.getString("designation"));
                emp1.setLocation(resultSet.getString("location"));
                emp1.setPhoneNumber(resultSet.getLong("phoneNumber"));
                emp1.setSalary(resultSet.getLong("salary"));
                return emp1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteEmployee(long uId) {
        String sql = "DELETE FROM employeeonboard WHERE uId=?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, uId);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee deleted successfully");
            } else {
                System.out.println("Employee not found or delete failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(EmployeeEntity emp) {
        String sql = "UPDATE employeeonboard SET userName=?, designation=?, location=?, phoneNumber=?, salary=? WHERE uId=?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, emp.getUserName());
            statement.setString(2, emp.getDesignation());
            statement.setString(3, emp.getLocation());
            statement.setLong(4, emp.getPhoneNumber());
            statement.setLong(5, emp.getSalary());
            statement.setLong(6, emp.getuId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully");
            } else {
                System.out.println("Employee not found or update failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<EmployeeEntity> fetchEmployees() {
        ArrayList<EmployeeEntity> empList = new ArrayList<>();
        String sql = "SELECT * FROM employeeonboard";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                EmployeeEntity emp = new EmployeeEntity();
                emp.setuId(resultSet.getLong("uId"));
                emp.setUserName(resultSet.getString("userName"));
                emp.setDesignation(resultSet.getString("designation"));
                emp.setLocation(resultSet.getString("location"));
                emp.setPhoneNumber(resultSet.getLong("phoneNumber"));
                emp.setSalary(resultSet.getLong("salary"));

                empList.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empList;
    }
}
