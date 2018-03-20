package ru.ts.bestteam.entityobjects;


import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name = "CERTIFICATES")
public class Certificate {

    private Long id;
    private Employee employee;
    private Date receivingDate;
    private String company;
    private String name;
    private int numberCer;
    private Blob scan;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "receiving_date")
    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }

    @Column(name = "company", length = 100)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "name", length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "number_cer", nullable = false)
    public int getNumberCer() {
        return numberCer;
    }

    public void setNumberCer(int numberCer) {
        this.numberCer = numberCer;
    }

    @Column(name = "scan")
    @Lob
    public Blob getScan() {
        return scan;
    }

    public void setScan(Blob scan) {
        this.scan = scan;
    }

}
