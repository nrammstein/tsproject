package ru.ts.bestteam.interfaces.implementation;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ts.bestteam.HibernateUtil;
import ru.ts.bestteam.entityobjects.Department;
import ru.ts.bestteam.interfaces.dao.DepartmentDao;

import java.sql.SQLException;
import java.util.Collection;

@Service
public class DepartmentDaoImpl implements DepartmentDao {
    private static final Logger logger = Logger.getLogger(DepartmentDaoImpl.class);

    @Autowired
    HibernateUtil hibernateUtil;

    public void addDepartment(Department department) throws SQLException {

    }

    public void deleteDepartment(Department department) throws SQLException {

    }

    public Department getDepartment(Long id) throws SQLException {
        Department department=null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            department=session.get(Department.class, id);
        }catch (HibernateException ex){
            logger.error(ex);
            ex.printStackTrace();
        }
        return department;
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
