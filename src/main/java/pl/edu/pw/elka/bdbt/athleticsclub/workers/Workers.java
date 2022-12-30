package pl.edu.pw.elka.bdbt.athleticsclub.workers;

import pl.edu.pw.elka.bdbt.athleticsclub.addresses.Addresses;
import pl.edu.pw.elka.bdbt.athleticsclub.athletes.Athletes;
import pl.edu.pw.elka.bdbt.athleticsclub.officeworkers.OfficeWorkers;
import pl.edu.pw.elka.bdbt.athleticsclub.salaries.Salaries;
import pl.edu.pw.elka.bdbt.athleticsclub.trainers.Trainers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "PRACOWNICY")
public class Workers {
    @Id
    @Column(name = "NR_PRACOWNIKA", nullable = false)
    private Integer workerNumber;

    @NotNull
    @Column(name = "IMIE")
    private String workerName;

    @NotNull
    @Column(name = "NAZWISKO")
    private String workerSurname;

    @NotNull
    @Column(name = "DATA_URODZENIA")
    private LocalDate workerDateOfBirth;

    @Column(name = "PESEL")
    private String workerPESEL;

    @NotNull
    @Column(name = "PLEC")
    private Boolean sex = false;

    @NotNull
    @Column(name = "DATA_ZATRUDNIENIA")
    private LocalDate dateOfEmployment;

    @Column(name = "NR_KONTA_BANKOWEGO")
    private String workerBankAccount;

    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Column(name = "NR_TELEFONU")
    private String workerPhoneNumber;


}