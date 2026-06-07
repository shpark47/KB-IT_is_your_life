package edu.employee.dao;

import edu.employee.vo.EmployeeVO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {
    List<EmployeeVO> getDepartmentEmployees(String dept) throws SQLException;

    List<EmployeeVO> getDepartmentAvgSalary() throws SQLException;

    List<EmployeeVO> getWorkingEmployees() throws SQLException;

    int increaseSalary(String code) throws SQLException;

    List<EmployeeVO> getEmployeesWithoutPhone() throws SQLException;
}
