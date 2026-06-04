package org.edu.member.dao;

import org.edu.member.vo.Member;

import java.sql.SQLException;
import java.util.List;

// DAO(Data Access Object) : 데이터 접근 객체
// DB와 연결되어 SQL을 수행하고 결과를 반환 받는 역할
public interface MemberDao {

    // 회원 등록
    int create(Member m) throws SQLException;

    int update(Member m) throws SQLException;

    Member select(int no) throws SQLException;

    int delete(int no) throws SQLException;

    List<Member> getList() throws SQLException;

    Member getDeptName(int no) throws SQLException;
}

