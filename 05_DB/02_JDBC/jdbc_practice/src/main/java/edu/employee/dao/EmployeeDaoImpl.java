package edu.employee.dao;

import edu.common.JDBCUtil;
import edu.employee.vo.EmployeeVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    Connection con = JDBCUtil.getConnection();

    @Override
    public List<EmployeeVO> getDepartmentEmployees(String dept) throws SQLException {
        List<EmployeeVO> list = new ArrayList<>();
        String sql = "select emp_name, dept_title, job_name, ifnull(bonus, '보너스 없음') bonus, if(ent_yn = 'N', '재직', '퇴사') ent_yn from employee e join department d on(dept_code = dept_id) left join job j using(job_code) where dept_title = ? order by bonus desc";
        try (PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, dept);
            ResultSet rs = pstm.executeQuery();
            if (rs == null) return null;
            while (rs.next()) {
                EmployeeVO e = new EmployeeVO();
                e.setEmpName(rs.getString(1));
                e.setDeptTitle(rs.getString(2));
                e.setJobName(rs.getString(3));
                e.setBonus(rs.getString(4));
                e.setEntYn(rs.getString(5));
                list.add(e);
            }
        }
        return list;
    }

    @Override
    public List<EmployeeVO> getDepartmentAvgSalary() throws SQLException {
        List<EmployeeVO> list = new ArrayList<>();
        String sql = "select dept_title, job_name, count(*) employeeCount, round(avg(salary)) avgSalary from employee e left join department d on(dept_id = dept_code) left join job using(job_code) where ent_yn = 'N' group by DEPT_TITLE, JOB_NAME having avgSalary >= 3000000 order by avgSalary desc";
        try (PreparedStatement pstm = con.prepareStatement(sql)){
            ResultSet rs = pstm.executeQuery();
            if (rs == null) return null;
            while (rs.next()) {
                EmployeeVO e = new EmployeeVO();
                e.setDeptTitle(rs.getString(1));
                e.setJobName(rs.getString(2));
                e.setEmployeeCount(rs.getInt(3));
                e.setAvgSalary(rs.getInt(4));
                list.add(e);
            }
        }
        return list;
    }

    @Override
    public List<EmployeeVO> getWorkingEmployees() throws SQLException {
        List<EmployeeVO> list = new ArrayList<>();
        String sql = "select dept_title, job_name, emp_name, salary from employee e left join department d on(dept_code = dept_id) left join job using(job_code) where ENT_YN = 'N' order by salary desc limit 10";
        try (PreparedStatement pstm = con.prepareStatement(sql)){
            ResultSet rs = pstm.executeQuery();
            if (rs == null) return null;
            while (rs.next()) {
                EmployeeVO e = new EmployeeVO();
                e.setDeptTitle(rs.getString(1));
                e.setJobName(rs.getString(2));
                e.setEmpName(rs.getString(3));
                e.setSalary(rs.getInt(4));
                list.add(e);
            }
        }
        return list;
    }

    @Override
    public int increaseSalary(String code) throws SQLException {
        String sql = "update employee set salary = salary + salary * 0.1 where dept_code = ?";
        try (PreparedStatement pstm = con.prepareStatement(sql)){
            pstm.setString(1, code);
            int result = pstm.executeUpdate();
            if (result > 0) {
                con.commit();
            } else {
                con.rollback();
            }
            return result;
        }
    }

    @Override
    public List<EmployeeVO> getEmployeesWithoutPhone() throws SQLException {
        List<EmployeeVO> list = new ArrayList<>();
        String sql = "select emp_name, ifnull(phone, '없음') phone, dept_title from employee e left join department d on(dept_id = dept_code) where phone is null order by emp_name desc";
        try (PreparedStatement pstm = con.prepareStatement(sql)){
            ResultSet rs = pstm.executeQuery();
            if (rs == null) return null;
            while (rs.next()) {
                EmployeeVO e = new EmployeeVO();
                e.setEmpName(rs.getString(1));
                e.setPhone(rs.getString(2));
                e.setDeptTitle(rs.getString(3));
                list.add(e);
            }
        }
        return list;
    }
}
