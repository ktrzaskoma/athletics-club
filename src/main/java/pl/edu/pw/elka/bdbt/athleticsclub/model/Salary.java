package pl.edu.pw.elka.bdbt.athleticsclub.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Wynagrodzenia")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nr_wynagrodzenia")
    private Integer salaryNumber;

    @Basic(optional = false)
    @Column(name = "stawka_godzinowa", precision = 10, scale = 2)
    private BigDecimal hourlyRate;

    @OneToMany(mappedBy = "workerSalary")
    private Set<Worker> workers;

    public Integer getSalaryNumber() {
        return salaryNumber;
    }

    public void setSalaryNumber(Integer salaryNumber) {
        this.salaryNumber = salaryNumber;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}