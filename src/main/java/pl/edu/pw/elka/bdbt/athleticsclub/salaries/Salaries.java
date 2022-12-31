package pl.edu.pw.elka.bdbt.athleticsclub.salaries;

import pl.edu.pw.elka.bdbt.athleticsclub.workers.Workers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Wynagrodzenia")
public class Salaries {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Nr_wynagrodzenia")
    private Integer salaryNumber;

    @NotNull
    @Column(name = "Stawka_godzinowa", precision = 10, scale = 2)
    private BigDecimal hourlyRate;

    @OneToMany(mappedBy = "workerSalary")
    private Set<Workers> workers;

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