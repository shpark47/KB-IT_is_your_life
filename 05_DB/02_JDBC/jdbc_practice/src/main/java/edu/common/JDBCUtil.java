package edu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    // 수업 JDBCUtil 참고하여 작성
    private static Connection con;
    static {
        try {
            Properties prop = new Properties();
            prop.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String id = prop.getProperty("id");
            String pw = prop.getProperty("password");
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, pw);
            con.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() {
        return con;
    }
    public static void close() {
        try {
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
