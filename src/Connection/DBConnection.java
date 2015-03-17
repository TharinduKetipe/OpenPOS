package Connection;

import java.beans.*;
import java.beans.Statement;
import java.sql.*;



/**
 * Created by Tharindu on 3/14/2015.
 */
public class DBConnection {

    private static String URL ="jdbc:mysql://localhost:3306/OpenPOS";
    private static String USER = "root";
    private static String PWD = "";
    private static DBConnection dbConnection = null;
    private static Connection conn = null;


public static Connection getConnection(){


    try{
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/OpenPOS",USER,PWD);
    }catch (SQLException e){
        e.printStackTrace();
    }catch (ClassNotFoundException e){
        e.printStackTrace();
    }

    return conn;

}

    public static void main(String [] args) throws SQLException {
        Connection connection = getConnection();

        java.sql.Statement st = null;
        ResultSet rs = null;

        try{
            st = connection.createStatement();
            rs = st.executeQuery("select count(*)from user");
            rs.next();
            int useCount = rs.getInt(1);
            System.out.println(useCount);
        }finally {

            if (st!= null){
                st.close();
            }
            if (rs!= null){
                st.close();
            }

        }



    }




}
