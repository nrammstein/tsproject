package ru.ts.bestteam.web.restObjects;

import java.math.BigDecimal;

public class RestEmployee {
    private String f_name;
    private String s_name;
    private String t_name;
    private Character sex;
    private Long birth_date;
    private Long department;
    private BigDecimal salary;

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public Long getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Long birth_date) {
        this.birth_date = birth_date;
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "RestEmployee{" +
                "f_name='" + f_name + '\'' +
                ", s_name='" + s_name + '\'' +
                ", t_name='" + t_name + '\'' +
                ", sex=" + sex +
                ", birth_date=" + birth_date +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
