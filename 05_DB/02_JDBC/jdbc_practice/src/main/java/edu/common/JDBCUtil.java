package edu.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    // 수업 JDBCUtil 참고하여 작성
    private static Connection con = null;

    static {
        try {
            Properties prop = new Properties();
            prop.load(JDBCUtil.class.getResourceAsStream("/application.properties"));

            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String id =  prop.getProperty("id");
            String pw =  prop.getProperty("password");

            Class.forName(driver);
            con = DriverManager.getConnection(url,id,pw);
            con.setAutoCommit(false);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        return con;
    }

    public static void close() throws SQLException {
        if (con != null) con.close();
    }
}
