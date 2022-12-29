package pl.edu.pw.elka.bdbt.athleticsclub.workers;

import pl.edu.pw.elka.bdbt.athleticsclub.addresses.Addresses;
import pl.edu.pw.elka.bdbt.athleticsclub.salaries.Salaries;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @Column(name = "NR_KLUBU", nullable = false)
    private Long nrKlubu;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NR_ADRESU", nullable = false)
    private Addresses addressNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NR_WYNAGRODZENIA", nullable = false)
    private Salaries salaryNumber;

    Integer getWorkerNumber() {
        return workerNumber;
    }

    void setWorkerNumber(final Integer workerNumber) {
        this.workerNumber = workerNumber;
    }

    String getWorkerName() {
        return workerName;
    }

    void setWorkerName(final String workerName) {
        this.workerName = workerName;
    }

    String getWorkerSurname() {
        return workerSurname;
    }

    void setWorkerSurname(final String workerSurname) {
        this.workerSurname = workerSurname;
    }

    LocalDate getWorkerDateOfBirth() {
        return workerDateOfBirth;
    }

    void setWorkerDateOfBirth(final LocalDate workerDateOfBirth) {
        this.workerDateOfBirth = workerDateOfBirth;
    }

    String getWorkerPESEL() {
        return workerPESEL;
    }

    void setWorkerPESEL(final String workerPESEL) {
        this.workerPESEL = workerPESEL;
    }

    Boolean getSex() {
        return sex;
    }

    void setSex(final Boolean sex) {
        this.sex = sex;
    }

    LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    void setDateOfEmployment(final LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    String getWorkerBankAccount() {
        return workerBankAccount;
    }

    void setWorkerBankAccount(final String workerBankAccount) {
        this.workerBankAccount = workerBankAccount;
    }

    String getEmail() {
        return email;
    }

    void setEmail(final String email) {
        this.email = email;
    }

    String getWorkerPhoneNumber() {
        return workerPhoneNumber;
    }

    void setWorkerPhoneNumber(final String workerPhoneNumber) {
        this.workerPhoneNumber = workerPhoneNumber;
    }

    Long getNrKlubu() {
        return nrKlubu;
    }

    void setNrKlubu(final Long nrKlubu) {
        this.nrKlubu = nrKlubu;
    }

    Addresses getAddressNumber() {
        return addressNumber;
    }

    void setAddressNumber(final Addresses addressNumber) {
        this.addressNumber = addressNumber;
    }

    Salaries getSalaryNumber() {
        return salaryNumber;
    }

    void setSalaryNumber(final Salaries salaryNumber) {
        this.salaryNumber = salaryNumber;
    }
}