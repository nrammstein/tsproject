package ru.ts.bestteam;

import org.hibernate.Session;
import ru.ts.bestteam.entityobjects.*;
import ru.ts.bestteam.interfaces.dao.*;
import ru.ts.bestteam.interfaces.implementation.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        EmployeeDao employeeDao = new EmployeeDaoImpl();
//        DepartmentDao departmentDao = new DepartmentDaoImpl();
//        Department department;
        Employee employee = new Employee();
//        employee.setFirstName("Jon");
//        employee.setSecondName("Travolta");
//        employee.setSex('M');
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(1980, 4,27, 0,0,0);
//        Date date = calendar.getTime();
//        employee.setBirthDate(date);
//        employee.setSalary(new BigDecimal("65000"));
//        employeeDao.addEmployee(employee);
        employee= employeeDao.getEmployee(2L);
        System.out.println("bla bla " + employee.getDepartment().getId());
       /* Collection<Employee> col =  employeeDao.getEmployees();
        Iterator<Employee> iterator = col.iterator();
        while(iterator.hasNext()){
            Employee em = iterator.next();
            System.out.println(em);
        }*/
    }

}
