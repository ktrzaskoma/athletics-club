package pl.edu.pw.elka.bdbt.athleticsclub.salaries;

import pl.edu.pw.elka.bdbt.athleticsclub.workers.Workers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "WYNAGRODZENIA")
public class Salaries {
    @Id
    @Column(name = "NR_WYNAGRODZENIA")
    private Integer salaryNumber;

    @NotNull
    @Column(name = "STAWKA_GODZINOWA", precision = 10, scale = 2)
    private BigDecimal hourlyRate;

    @OneToMany(mappedBy = "salaryNumber")
    private Set<Workers> workers = new LinkedHashSet<>();

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

    public Set<Workers> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Workers> workers) {
        this.workers = workers;
    }

}