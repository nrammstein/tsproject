package ru.ts.bestteam.web.controllers;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ts.bestteam.entityobjects.Employee;
import ru.ts.bestteam.interfaces.dao.DepartmentDao;
import ru.ts.bestteam.interfaces.dao.EmployeeDao;
import ru.ts.bestteam.web.restObjects.RestEmployee;
import ru.ts.bestteam.web.restObjects.RestEmployeeHistory;
import ru.ts.bestteam.web.restObjects.RestEmployeeSalary;
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

    @Autowired
    DepartmentDao departmentDao;

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
                restEmployee.setF_name(employee.getFirstName());
                restEmployee.setS_name(employee.getSecondName());
                restEmployee.setT_name(employee.getThirdName());
                restEmployee.setSex(employee.getSex());
                restEmployee.setBirth_date(employee.getBirthDate().getTime());
                if (employee.getDepartment()!=null) {
                    restEmployee.setDepartment(employee.getDepartment().getId());
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
            restEmployee.setF_name(employee.getFirstName());
            restEmployee.setS_name(employee.getSecondName());
            restEmployee.setT_name(employee.getThirdName());
            restEmployee.setSex(employee.getSex());
            restEmployee.setBirth_date(employee.getBirthDate().getTime());
            if (employee.getDepartment() != null) {
                restEmployee.setDepartment(employee.getDepartment().getId());
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

    @RequestMapping(value = "/employee/test", method = RequestMethod.GET)
    public ResponseEntity<Employee> test(){
        Employee employee=null;
        try {
            employee = employeeDao.getEmployee(13L);
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> employee(@RequestBody() RestEmployee employee){
        RestResponse response = new RestResponse();
        if (employee.getF_name() == null){
            response.setResponse(employee.toString());
            response.setMessage("parametr f_name is required");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        if (employee.getS_name() == null){
            response.setResponse(employee.toString());
            response.setMessage("parametr s_name is required");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        if (employee.getSex()==null){
            response.setResponse(employee.toString());
            response.setMessage("parametr sex is required");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        if(employee.getSalary()==null){
            response.setResponse(employee.toString());
            response.setMessage("parametr salary is required");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        if(employee.getBirth_date()==null){
            response.setMessage("parametr birth_date is required");
            response.setResponse(employee.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        Employee entytiEmployee = new Employee();
        entytiEmployee.setFirstName(employee.getF_name());
        entytiEmployee.setSecondName(employee.getS_name());
        entytiEmployee.setThirdName(employee.getT_name());
        entytiEmployee.setSex(employee.getSex());
        entytiEmployee.setBirthDate(new Date(employee.getBirth_date()));
        if (employee.getDepartment()!= null) {
            try {
                entytiEmployee.setDepartment(departmentDao.getDepartment(employee.getDepartment()));
            } catch (SQLException e) {
                logger.error(e);
                e.printStackTrace();
            }
        }
        //POSITION AND GRADE NOT SUPPORTET YET :todo

        entytiEmployee.setSalary(employee.getSalary());
        try {
            employeeDao.addEmployee(entytiEmployee);
        } catch (SQLException e) {
            logger.error(e);
            e.printStackTrace();
            response.setMessage("something goes wrong " + "\n" + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        response.setResponse("200 ok");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @RequestMapping(value = "/employee/salary", method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> employeeSalary(@RequestBody()RestEmployeeSalary restEmployeeSalary){
        Employee employee = null;
        RestResponse response = new RestResponse();
        if (restEmployeeSalary.getId()== null){
            response.setMessage("parametr id is required");
            response.setResponse(restEmployeeSalary.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        if (restEmployeeSalary.getSalary() == null){
            response.setMessage("parametr salary is required");
            response.setResponse(restEmployeeSalary.toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            employee = employeeDao.getEmployee(restEmployeeSalary.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }
        employee.setSalary(restEmployeeSalary.getSalary());
        try {
            employeeDao.updateEmployee(employee);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
            response.setMessage("something goes wrong... not modifier " + "\n" + e.getMessage());
            System.out.println(response);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        response.setResponse("200 ok");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
