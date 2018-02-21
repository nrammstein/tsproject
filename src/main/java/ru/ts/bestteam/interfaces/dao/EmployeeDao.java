package ru.ts.bestteam.interfaces.dao;

import ru.ts.bestteam.entityobjects.Employee;

import java.sql.SQLException;
import java.util.Collection;

public interface EmployeeDao {
    void addEmployee(Employee employee) throws SQLException;
    void deleteEmployee(Employee employee) throws SQLException;
    Employee getEmployee(Long id)  throws SQLException;
    Employee getEmployee(String firstName, String lastName) throws SQLException;
    Collection<Employee> getEmployees() throws SQLException;
    void updateEmployee(Employee employee) throws SQLException;
    Collection<Employee> getHistory(Employee employee) throws SQLException;
}
