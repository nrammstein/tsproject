package ru.ts.bestteam.entityobjects;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "parent_id")
    private Department department;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "head")
    private Employee employee;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "department") //need mapped
    private Set<Employee> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                ", employee=" + employee +
                ", employees=" + employees +
                '}';
    }
}
