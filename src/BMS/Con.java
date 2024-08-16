package BMS;

import java.sql.*;

public class Con {
    Connection c;
    Statement s;

    public Con() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///BankManagementSystems", "root", "Dhana9");
            s = c.createStatement();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}

