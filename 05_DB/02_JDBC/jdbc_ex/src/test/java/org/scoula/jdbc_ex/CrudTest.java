package org.scoula.jdbc_ex;

import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
