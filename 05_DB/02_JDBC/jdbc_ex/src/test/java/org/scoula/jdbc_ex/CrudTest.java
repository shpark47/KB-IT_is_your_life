package org.scoula.jdbc_ex;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
    Connection con = JDBCUtil.getConnection();

    @AfterAll
    static void close() {
        JDBCUtil.close();
    }

    @Test
    @Order(1)
    @DisplayName("회원가입 테스트")
    public void insertUser() throws SQLException {
        String sql = "insert into users values(?, ?, ?, ?)";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, "winner3");
        pstm.setString(2, "1234");
        pstm.setString(3, "win");
        pstm.setString(4, "admin");
        int row = pstm.executeUpdate();
        Assertions.assertEquals(1, row);
        pstm.close();
    }

    @Test
    @Order(2)
    public void selectUser() throws SQLException {
        String sql = "select * from users";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getString(2));
        }
        stmt.close();
    }

    @Test
    @Order(3)
    public void selectUserById() throws SQLException {
        String sql = "select * from users where id = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, "admin");
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString(2));
        }
        pstm.close();
    }

    @Test
    @Order(4)
    public void updateUser() throws SQLException {
        String sql = "update users set name = ? where id = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, "aaa123");
        pstm.setString(2, "admin");
        int row = pstm.executeUpdate();
        System.out.println(row);
        pstm.close();
    }

    @Test
    @Order(5)
    public void deleteUser() throws SQLException {
        String sql = "delete from users where id = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, "winner2");
        int row = pstm.executeUpdate();
        System.out.println(row);
        pstm.close();
    }
}
