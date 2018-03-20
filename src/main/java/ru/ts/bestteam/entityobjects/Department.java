package ru.ts.bestteam.entityobjects;

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "departments")
public class Department {

    private Long id;
    private Department parentDepartment;
    private String name;
    private Employee headEmployee;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    public Department getParentDepartment() {
        return parentDepartment;
    }

    public void setParentDepartment(Department parentDepartment) {
        this.parentDepartment = parentDepartment;
    }

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "head")
    public Employee getHeadEmployee() {
        return headEmployee;
    }

    public void setHeadEmployee(Employee headEmployee) {
        this.headEmployee = headEmployee;
    }
}
