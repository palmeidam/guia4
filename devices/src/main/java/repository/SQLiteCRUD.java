package repository;

import model.Phone;
import org.sqlite.SQLiteConnection;

import java.sql.*;
import java.util.ArrayList;

public class SQLiteCRUD {

    private static Connection connection;

    private static void SQLiteConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            System.out.println("Connection established.");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
    public static void createTablePhones() throws SQLException {
        SQLiteConnection();
        String createTableQuery = "CREATE TABLE IF NOT EXISTS phones (id INTEGER PRIMARY KEY, model TEXT NOT NULL, " +
                "so TEXT NOT NULL, price INTEGER NOT NULL, camara TEXT NOT NULL )";
        Statement statement = connection.createStatement();
        statement.execute(createTableQuery);
        statement.close();
        connection.close();
    }
    public static void insertPhone(Phone phone) throws SQLException {
        SQLiteConnection();
        String sql = "INSERT INTO phones (model, so, price, camara) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt  = connection.prepareStatement(sql);
        pstmt.setString(1, phone.getModel());
        pstmt.setString(2, phone.getSo());
        pstmt.setInt(3, phone.getPrice());
        pstmt.setString(4, phone.getCamara());
        pstmt.executeUpdate();
        pstmt.close();
    }
    public static ArrayList<Phone> getAllPhones() throws SQLException {
        ArrayList<Phone> listPhone = new ArrayList<>();
        SQLiteConnection();
        Statement statement = connection.createStatement();
        String selectDataQuery = "SELECT * FROM phones";
        ResultSet resultSet = statement.executeQuery(selectDataQuery);
        while (resultSet.next()) {
            Phone phone = new Phone(resultSet.getInt("id"), resultSet.getString("model"), resultSet.getString("so"),
                    resultSet.getInt("price"), resultSet.getString("camara"));
            listPhone.add(phone);
            //System.out.println("User ID: " + id + ", model: " + model + ", so:" + so + ", price:" + price + ", camara:" + camara );
        }
        statement.close();
        connection.close();
        return listPhone;
    }

    public static Phone getPhonesById(int phone_id) throws SQLException {
        Phone phone = null;
        SQLiteConnection();
        String sql = "SELECT * FROM phones WHERE id = ?";
        PreparedStatement pstmt  = connection.prepareStatement(sql);
        pstmt.setInt(1, phone_id);
        ResultSet resultSet = pstmt.executeQuery();
        while (resultSet.next()) {
            phone = new Phone(resultSet.getInt("id"), resultSet.getString("model"), resultSet.getString("so"),
                    resultSet.getInt("price"), resultSet.getString("camara"));
            //System.out.println("User ID: " + id + ", model: " + model + ", so:" + so + ", price:" + price + ", camara:" + camara );
        }
        pstmt.close();
        connection.close();
        return phone;
    }

    public static void deleteById(int phone_id) throws SQLException {
        SQLiteConnection();
        String sql = "DELETE FROM phones WHERE id = ?";
        PreparedStatement pstmt  = connection.prepareStatement(sql);
        pstmt.setInt(1, phone_id);
        pstmt.executeUpdate();
        pstmt.close();
        connection.close();
    }

    public static void updateById(Phone phone ) throws SQLException {
        SQLiteConnection();
        String sql = "UPDATE  phones SET model = ?, so = ?, price = ?, camara = ?   WHERE id = ?";
        PreparedStatement pstmt  = connection.prepareStatement(sql);
        pstmt.setString(1, phone.getModel());
        pstmt.setString(2, phone.getSo());
        pstmt.setInt(3, phone.getPrice());
        pstmt.setString(4, phone.getCamara());
        pstmt.setInt(5, phone.getId());
        pstmt.executeUpdate();
        pstmt.close();
        connection.close();
    }

}
