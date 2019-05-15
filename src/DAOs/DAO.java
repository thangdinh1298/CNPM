package DAOs;

import java.sql.*;

public class DAO {
    // JDBC driver name and database URL
    //private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/CNPM1";
    //"jdbc:mysql://localhost::port/<dbname>";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "12345678";

    static Connection conn = null;
    DAO(){

    }

    static void getInstance(){
        if(conn == null){
            try{
                Class.forName(JDBC_DRIVER);

                System.out.println("Dang ket noi toi CSDL ....");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Tao thanh cong");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//        new DAOs.DAO();
//    }
}