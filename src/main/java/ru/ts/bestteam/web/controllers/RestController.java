package ru.ts.bestteam.web.controllers;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ts.bestteam.entityobjects.Employee;
import ru.ts.bestteam.interfaces.dao.EmployeeDao;
import ru.ts.bestteam.web.restObjects.RestEmployee;
import ru.ts.bestteam.web.restObjects.RestEmployeeHistory;
import ru.ts.bestteam.web.restObjects.RestResponse;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/api")
public class RestController {
    private static final Logger logger = Logger.getLogger(RestController.class);

    @Autowired
    EmployeeDao employeeDao;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<RestEmployee> employees(){
        Collection<Employee> employees=null;
        ArrayList<RestEmployee> list = new ArrayList<>();
        try {
            employees=employeeDao.getEmployees();
            Iterator<Employee> iterator = employees.iterator();
            while (iterator.hasNext()){
                Employee employee = iterator.next();
                RestEmployee restEmployee = new RestEmployee();
                restEmployee.setfName(employee.getFirstName());
                restEmployee.setsName(employee.getSecondName());
                restEmployee.settName(employee.getThirdName());
                restEmployee.setSex(employee.getSex());
                restEmployee.setBirthDate(employee.getBirthDate());
                if (employee.getDepartment()!=null) {
                    restEmployee.setDepartmentId(employee.getDepartment().getId());
                }
                restEmployee.setSalary(employee.getSalary());
                list.add(restEmployee);
            }
        } catch (SQLException e) {
            logger.error(e);
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public RestEmployee employee(@PathVariable("id") Long id){
        RestEmployee restEmployee = new RestEmployee();
        Employee employee = null;
        try {
            employee = employeeDao.getEmployee(id);
            restEmployee.setfName(employee.getFirstName());
            restEmployee.setsName(employee.getSecondName());
            restEmployee.settName(employee.getThirdName());
            restEmployee.setSex(employee.getSex());
            restEmployee.setBirthDate(employee.getBirthDate());
            if (employee.getDepartment() != null) {
                restEmployee.setDepartmentId(employee.getDepartment().getId());
            }
            restEmployee.setSalary(employee.getSalary());
        } catch (SQLException e) {
            logger.error(e);
            e.printStackTrace();
        }
        return restEmployee;
    }

    @RequestMapping(value = "/employee/{id}/history", method = RequestMethod.GET)
    public List<RestEmployeeHistory> employeeHistory(@PathVariable("id") Long id){
        List<RestEmployeeHistory> list = new ArrayList<>();
        try {
            Employee employee = employeeDao.getEmployee(id);
            Collection<Employee> collection = employeeDao.getHistory(employee);
            Iterator<Employee> iterator = collection.iterator();
            while (iterator.hasNext()){
                Employee e = iterator.next();
                RestEmployeeHistory history = new RestEmployeeHistory();
                history.setF_name(e.getFirstName());
                history.setS_name(e.getSecondName());
                history.setT_name(e.getThirdName());
                history.setSex(e.getSex());
                history.setBirth_date(e.getBirthDate());
                if (e.getDepartment() != null) {
                    history.setDepartment(e.getDepartment().getId());
                }
                if (e.getPosition() != null) {
                    history.setPosition(e.getPosition().getId());
                }
                if (e.getGrade() != null) {
                    history.setGrade(e.getGrade().getId());
                }
                history.setSalary(e.getSalary());
                history.setStart_date(e.getFromDate());
                history.setEnd_date(e.getToDate());
                list.add(history);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }

        return list;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public RestResponse employee(
           @RequestParam(value ="f_name") String firstName,
           @RequestParam(value = "s_name") String secondName,
           @RequestParam(value = "t_name", required = false) String thirdName,
           @RequestParam(value = "sex") Character sex,
           @RequestParam(value = "birth_date", required = false) Date birth_date,
           @RequestParam(value = "department", required = false) Long department,
           @RequestParam(value = "position", required = false) Long position,
           @RequestParam(value = "grade", required = false) Long grade,
           @RequestParam(value = "salary") BigDecimal salary
    ){
        RestResponse response = new RestResponse();
        response.setMessage("ok");
        response.setResponse("200");
        return response;
    }

}
