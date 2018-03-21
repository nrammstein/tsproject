package ru.ts.bestteam.web.restObjects;

import java.math.BigDecimal;

public class RestEmployeeSalary {
    private Long id;
    private BigDecimal salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "RestEmployeeSalary{" +
                "id=" + id +
                ", salary=" + salary +
                '}';
    }
}
