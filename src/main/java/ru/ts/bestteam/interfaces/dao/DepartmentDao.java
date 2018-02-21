package ru.ts.bestteam.interfaces.dao;

import ru.ts.bestteam.entityobjects.Department;

import java.sql.SQLException;
import java.util.Collection;

public interface DepartmentDao {
    void addDepartment(Department department) throws SQLException;
    void deleteDepartment(Department department) throws SQLException;
    Department getDepartment(Long id) throws SQLException;
    Department getDepartment(String name) throws SQLException;
    Collection<Department> getDepartments() throws SQLException;
    void updateDepartment(Department department) throws SQLException;
}
