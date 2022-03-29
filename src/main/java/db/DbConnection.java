package db;

import java.sql.*;

public class DbConnection {

    private Connection connection;

    public DbConnection(){
        try {
            //Importación del driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://200.3.193.22:3306/P09728_1_11",
                    "P09728_1_11",
                    "ZCSaQGZU");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //INSERT, UPDATE, DELETE
    public void runSQL(String sql){
        try {
            Statement st = connection.createStatement();
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void readTable(){
        try {
            String sql = "SELECT * FROM students";
            Statement st = connection.createStatement();
            ResultSet results = st.executeQuery(sql);
            while(results.next()){
                String name = results.getString("name");
                System.out.println(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
