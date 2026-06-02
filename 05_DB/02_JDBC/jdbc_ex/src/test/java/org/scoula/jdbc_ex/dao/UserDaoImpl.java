package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.UserVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    Connection con = JDBCUtil.getConnection();

    @Override
    public int create(UserVo user) throws SQLException {
        try (PreparedStatement pstm = con.prepareStatement("insert into users values(?, ?, ?, ?)")){
            pstm.setString(1, user.getId());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getName());
            pstm.setString(4, user.getRole());
            return pstm.executeUpdate();
        }
    }

    @Override
    public List<UserVo> getList() throws SQLException {
        List<UserVo> list = new ArrayList<>();
        try (PreparedStatement pstm = con.prepareStatement("select * from users")){
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                UserVo user = new UserVo();
                user.setId(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setName(rs.getString(3));
                user.setRole(rs.getString(4));
                list.add(user);
            }
        }
        return list;
    }

    @Override
    public Optional<UserVo> get(String id) throws SQLException {
        try (PreparedStatement pstm = con.prepareStatement("select * from users where id = ?")){
            pstm.setString(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                UserVo user = new UserVo();
                user.setId(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setName(rs.getString(3));
                user.setRole(rs.getString(4));
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public int update(UserVo user) throws SQLException {
        try (PreparedStatement pstm = con.prepareStatement("update users set name = ? where id = ?")){
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getId());
            return pstm.executeUpdate();
        }
    }

    @Override
    public int delete(String id) throws SQLException {
        try (PreparedStatement pstm = con.prepareStatement("delete from users where id = ?")){
            pstm.setString(1, id);
            return pstm.executeUpdate();
        }
    }
}
