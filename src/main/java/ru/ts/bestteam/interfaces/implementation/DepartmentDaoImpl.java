package ru.ts.bestteam.interfaces.implementation;

import ru.ts.bestteam.entityobjects.Department;
import ru.ts.bestteam.interfaces.dao.DepartmentDao;

import java.sql.SQLException;
import java.util.Collection;

public class DepartmentDaoImpl implements DepartmentDao {
    public void addDepartment(Department department) throws SQLException {

    }

    public void deleteDepartment(Department department) throws SQLException {

    }

    public Department getDepartment(Long id) throws SQLException {
        return null;
    }

    public Department getDepartment(String name) throws SQLException {
        return null;
    }

    public Collection<Department> getDepartments() throws SQLException {
        return null;
    }

    public void updateDepartment(Department department) throws SQLException {

    }
}
