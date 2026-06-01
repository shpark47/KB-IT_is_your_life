package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.domain.UserVo;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    int create(UserVo user) throws SQLException;
    List<UserVo> getList() throws SQLException;
    Optional<UserVo> get(String id) throws SQLException;
    int update(UserVo user) throws SQLException;
    int delete(String id) throws SQLException;
}
