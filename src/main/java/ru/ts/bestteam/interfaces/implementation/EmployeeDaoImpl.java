package ru.ts.bestteam.interfaces.implementation;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ts.bestteam.HibernateUtil;
import ru.ts.bestteam.entityobjects.Employee;
import ru.ts.bestteam.interfaces.dao.EmployeeDao;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeDaoImpl implements EmployeeDao {

    private static final Logger logger = Logger.getLogger(EmployeeDaoImpl.class);
    @Autowired
    HibernateUtil hibernateUtil;

    public void addEmployee(Employee employee) throws SQLException {
        if (employee.getId() != null){
            logger.error("Error, column id should be null");
            throw new SQLException("Error, column id should be null");
        }
        try(Session session = hibernateUtil.getSessionFactory().openSession() ){

            String sqlInsert = "INSERT INTO employees (ID, HISTORY_ID, FIRST_NAME, SECOND_NAME, THIRD_NAME, " +
                    "SEX, BIRTH_DATE, DEPARTMENT_ID, POSITION_ID, GRADE_ID, SALARY, FROM_DATE) " +
                    "VALUES (employees_id_seq.nextval, employees_uid_seq.nextval, :fname, :sname, :tname, :sex," +
                    " :bdate, :depid, :posid, :grid, :salary, :fromdate)";
            Query query = session.createNativeQuery(sqlInsert);
            query.setParameter("fname", employee.getFirstName());
            query.setParameter("sname", employee.getSecondName());
            query.setParameter("tname", employee.getThirdName());
            query.setParameter("sex", employee.getSex());
            query.setParameter("bdate", employee.getBirthDate());
            if (employee.getDepartment() == null) {
                query.setParameter("depid", "");
            } else {
                query.setParameter("depid", employee.getDepartment().getId());
            }
            if (employee.getPosition() == null) {
                query.setParameter("posid","");
            } else {
                query.setParameter("posid", employee.getPosition().getId());
            }
            if (employee.getGrade() == null) {
                query.setParameter("grid", "");
            } else {
                query.setParameter("grid", employee.getGrade().getId());
            }
            query.setParameter("salary", employee.getSalary());
            query.setParameter("fromdate", new Date());
            session.beginTransaction();
            query.executeUpdate();
            session.getTransaction().commit();
        }catch (HibernateException ex){
            logger.error(ex);
            ex.printStackTrace();
        }
    }

    public void deleteEmployee(Employee employee) throws SQLException {
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            Employee employeeInBase = session.get(Employee.class, employee.getId());
            if (employeeInBase.getToDate() == null){
                employeeInBase.setToDate(new Date());
                session.beginTransaction();
                session.update(employeeInBase);
                session.getTransaction().commit();
            }else {
                logger.error("Already deleted or wrong id");
                throw new SQLException("Already deleted or wrong id");
            }
        }catch (HibernateException ex){
            logger.error(ex);
            ex.printStackTrace();
        }
    }

    public Employee getEmployee(Long id) throws SQLException {
        Employee employee=null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            employee=session.get(Employee.class, id);
        }catch (HibernateException ex){
            logger.error(ex);
            ex.printStackTrace();
        }
        return employee;
    }

    public Employee getEmployee(String firstName, String lastName) throws SQLException {
        Employee employee = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            String sqlSelect = "SELECT * FROM EMPLOYEES WHERE first_name = :fname AND second_name = :lname AND to_date IS NULL";
            Query<Employee> query = session.createNativeQuery(sqlSelect, Employee.class);
            query.setParameter("fname", firstName);
            query.setParameter("lname", lastName);
            employee=query.getSingleResult();
        }
        return employee;
    }

    public Collection<Employee> getEmployees() throws SQLException {
        List<Employee> employees=null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            String sqlSelect="SELECT * FROM employees WHERE to_date IS NULL";
            Query query = session.createNativeQuery(sqlSelect, Employee.class);
            employees=query.list();
        }
        return employees;
    }

    public void updateEmployee(Employee employee) throws SQLException {
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
          Employee oldEmployee = session.get(Employee.class,employee.getId());
          if (oldEmployee.getToDate() == null){
              oldEmployee.setToDate(new Date());
              String sqlInsert = "INSERT INTO employees (ID, HISTORY_ID, FIRST_NAME, SECOND_NAME, THIRD_NAME, " +
                      "SEX, BIRTH_DATE, DEPARTMENT_ID, POSITION_ID, GRADE_ID, SALARY, FROM_DATE) " +
                      "VALUES (employees_id_seq.nextval, :hid, :fname, :sname, :tname, :sex," +
                      " :bdate, :depid, :posid, :grid, :salary, :fromdate)";
              Query query = session.createNativeQuery(sqlInsert);
              query.setParameter("hid", employee.getHistoryId());
              query.setParameter("fname", employee.getFirstName());
              query.setParameter("sname", employee.getSecondName());
              query.setParameter("tname", employee.getThirdName());
              query.setParameter("sex", employee.getSex());
              query.setParameter("bdate", employee.getBirthDate());
              if (employee.getDepartment() == null) {
                  query.setParameter("depid", "");
              } else {
                  query.setParameter("depid", employee.getDepartment().getId());
              }
              if (employee.getPosition() == null) {
                  query.setParameter("posid","");
              } else {
                  query.setParameter("posid", employee.getPosition().getId());
              }
              if (employee.getGrade() == null) {
                  query.setParameter("grid", "");
              } else {
                  query.setParameter("grid", employee.getGrade().getId());
              }
              query.setParameter("salary", employee.getSalary());
              query.setParameter("fromdate", new Date());
              session.beginTransaction();
              session.update(oldEmployee);
              query.executeUpdate();
              session.getTransaction().commit();
          }else {
              logger.error("Can not update object. column to_date is completed");
              throw new SQLException("Can not update object. column to_date is completed");
          }
        }catch (HibernateException ex){
            logger.error(ex);
            ex.printStackTrace();
        }
    }

    public Collection<Employee> getHistory(Employee employee) throws SQLException {
        Collection<Employee> col = null;
        try(Session session = hibernateUtil.getSessionFactory().openSession()){
            String sqlSelect = "SELECT * FROM employees WHERE history_id = :hid ";
            Query query = session.createNativeQuery(sqlSelect, Employee.class);
            query.setParameter("hid", employee.getHistoryId());
            col=query.list();
        }catch (HibernateException ex){
            logger.error(ex);
            ex.printStackTrace();
        }
        return col;
    }
}
