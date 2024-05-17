package lk.ijse.teleleavesbilling.repository;

import lk.ijse.teleleavesbilling.db.DBConnection;
import lk.ijse.teleleavesbilling.model.Collector;
import lk.ijse.teleleavesbilling.model.Orders;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersRepo {
    public static boolean save(Orders orders) throws SQLException {

        String sql = "INSERT INTO Collector VALUES(?, ?, ?, ?)";
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1, orders.getOR_ID());
        pstm.setObject(2, orders.getDate());
        pstm.setObject(3, orders.getAddress());
        pstm.setObject(4, orders.getQuantity());

        return pstm.executeUpdate() > 0;


    }
    public static boolean update(Orders orders) throws SQLException {
        String sql = "UPDATE customers SET name = ?, address = ?, tel = ? WHERE id = ?";

        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);

        pstm.setObject(1, orders.getOR_ID());
        pstm.setObject(2, orders.getDate());
        pstm.setObject(3, orders.getAddress());
        pstm.setObject(4, orders.getQuantity());

        return pstm.executeUpdate() > 0;
    }

    public static boolean delete(String collectId) throws SQLException {
        String sql = "DELETE FROM Collector WHERE Collect_ID = ?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection()
                .prepareStatement(sql);

        pstm.setObject(1, collectId);

        return pstm.executeUpdate() > 0;
    }

    public static Orders searchByOrderID(String collectId) throws SQLException {
        String sql = "SELECT * FROM Collector WHERE Collector_ID = ?";
        PreparedStatement pstm = DBConnection.getInstance().getConnection()
                .prepareStatement(sql);

        pstm.setObject(1, collectId);
        ResultSet resultSet = pstm.executeQuery();

        Orders orders = null;

        if (resultSet.next()) {
            String ordId = resultSet.getString(1);
            String date = resultSet.getString(2);
            String address = resultSet.getString(3);
            String qty = resultSet.getString(4);

            orders = new Orders(ordId, date, address, qty);
        }
        return orders;
    }

    public static List<Collector> getAll() throws SQLException {
        String sql = "SELECT * FROM Collector";

        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<Collector> collectorList = new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String tel = resultSet.getString(4);

            Collector collector = new Collector(id, name, address, tel);
            collectorList.add(collector);
        }
        return collectorList;
    }
}

