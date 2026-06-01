package org.scoula.jdbc_ex.dao;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.JDBCUtil;
import org.scoula.jdbc_ex.domain.UserVo;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserDaoTest {
    UserDao dao = new UserDaoImpl();

    @Test
    @Order(1)
    void create() throws SQLException {
        UserVo user = new UserVo("test1", "test1", "test1", "aaa");
        int count = dao.create(user);
        Assertions.assertEquals(1, count);
    }

    @Test
    @Order(2)
    void getList() throws SQLException {
        List<UserVo> list = dao.getList();
        for (UserVo u : list) {
            System.out.println(u.toString());
        }
    }

    @Test
    @Order(3)
    void get() throws SQLException {
        UserVo user = dao.get("test1").orElseThrow();
        Assertions.assertNotNull(user);
    }

    @Test
    @Order(4)
    void update() throws SQLException {
        UserVo user = dao.get("test1").orElseThrow();
        user.setName("aaaaaa");
        int count = dao.update(user);
        Assertions.assertEquals(1, count);
    }

    @Test
    @Order(5)
    void delete() throws SQLException {
        int count = dao.delete("test1");
        Assertions.assertEquals(1, count);
    }

    @AfterAll
    static void last() {
        JDBCUtil.close();
    }
}