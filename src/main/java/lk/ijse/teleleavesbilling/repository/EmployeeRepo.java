package lk.ijse.teleleavesbilling.repository;

import lk.ijse.teleleavesbilling.db.DBConnection;
import lk.ijse.teleleavesbilling.model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRepo {
    public static boolean save(Employee employee) throws SQLException {
//        In here you can now save your customer
        String sql = "INSERT INTO employee VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1, employee.getEMP_ID());
        pstm.setObject(2, employee.getName());
        pstm.setObject(3, employee.getSalary());
        pstm.setObject(4, employee.getDate());

        return pstm.executeUpdate() > 0;


    }

    public static boolean update(Employee employee) throws SQLException {
        String sql = "UPDATE employee SET name = ?, salary = ?, date = ? WHERE emp_id = ?";

        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1, employee.getName());
        pstm.setObject(2, employee.getSalary());
        pstm.setObject(3, employee.getDate());
        pstm.setObject(4, employee.getEMP_ID());

        return pstm.executeUpdate() > 0;
    }

    public static Employee searchById(String id) throws SQLException {
        String sql = "SELECT * FROM employee WHERE emp_id = ?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1, id);
        ResultSet resultSet = pstm.executeQuery();

        Employee employee = null;

        if (resultSet.next()) {
            String emp_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String salary = resultSet.getString(3);
            String date = resultSet.getString(4);

            employee = new Employee(emp_id, name, salary, date);
        }
        return employee;
    }

    public static boolean delete(String id) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1, id);

        return pstm.executeUpdate() > 0;
    }


}
