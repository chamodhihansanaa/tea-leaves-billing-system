package lk.ijse.teleleavesbilling.repository;

import lk.ijse.teleleavesbilling.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrdersRepo {
    public static boolean save(Orders orders) throws SQLException {
        String sql = "INSERT INTO orders VALUES(?, ?, ?,?)";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setString(1, orders.getOrderID());
        pstm.setString(2, orders.getQuantity());
        pstm.setDate(3, orders.getDate());
        pstm.setAddress(4, orders.getAddress());
        return pstm.executeUpdate() > 0;
    }
}
