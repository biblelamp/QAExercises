import java.sql.*;
import java.util.Arrays;

/**
 * Created by Sergey Irupin on 20.11.17. Homework
 */
public class HomeWork {
    static final String DRIVER_NAME = "org.sqlite.JDBC";
    static final String dbName = "users.db";
    static final String tableName = "users";
    static Connection connect = null;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // open database
        Class.forName(DRIVER_NAME);
        connect = DriverManager.getConnection("jdbc:sqlite:" + dbName);
        System.out.println("Opening database " + dbName + " successfully.");

        // create table if not exists
        Statement stmt = connect.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + tableName +
                "(login VARCHAR(255)," +
                "password VARCHAR(255)," +
                "role VARCHAR(255));");
        System.out.println("Create table " + tableName + " in database " +
                dbName + " successfully");

        // added records if need
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + ";");
        if (!rs.next()) {
            // using PreparedStatement to protect against sql injections
            PreparedStatement pstmt = connect.prepareStatement("INSERT INTO " + tableName +
                    " (login, password, role) VALUES (?, ?, ?);");
            pstmt.setString(1, "mike");
            pstmt.setString(2, "qwerty");
            pstmt.setString(3, "user");
            pstmt.execute();
            pstmt.setString(1, "luke");
            pstmt.setString(2, "asdfgh");
            pstmt.setString(3, "administrator");
            pstmt.execute();
            System.out.println("Records in table " + tableName + " added successfully");
        }
        rs.close();

        // get pairs login/password by role
        System.out.println(Arrays.toString(getLoginPasswd("user", stmt, tableName)));
        System.out.println(Arrays.toString(getLoginPasswd("administrator", stmt, tableName)));
        System.out.println(Arrays.toString(getLoginPasswd("admin", stmt, tableName)));

        // close all
        stmt.close();
        connect.close();
    }

    /**
     * Get login and password by role
     *
     * @param role
     * @param stmt
     * @param tblName
     * @return String[2] (login, password)
     */
    static String[] getLoginPasswd(String role, Statement stmt, String tblName)
            throws SQLException {
        String[] result = new String[2];
        PreparedStatement pstmt = connect.prepareStatement(
                "SELECT * FROM " + tblName + " WHERE role = ?;");
        pstmt.setString(1, role);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            result[0] = rs.getString("login");
            result[1] = rs.getString("password");
        }
        rs.close();
        return result;
    }
}