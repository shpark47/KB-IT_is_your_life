package org.scoula.jdbc_ex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionTest {
    @Test
    public void testConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ex";
        String id = "scoula";
        String password = "mysql";
        Connection conn = DriverManager.getConnection(url, id, password);
        conn.close();
    }

    @Test
    public void testConnection2() {
        Connection conn = JDBCUtil.getConnection();
        JDBCUtil.close();
    }
}