package pl.edu.pw.elka.bdbt.athleticsclub.workers;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Pracownicy")
public class Workers {

    @Id
    @Column(name = "Nr_pracownika")
    private Integer id;

    @NotNull
    @Column(name = "Imie")
    private String workerName;

    @NotNull
    @Column(name = "Nazwisko")
    private String workerSurname;

    @NotNull
    @Column(name = "Data_urodzenia")
    private Date dateOfBirth;

    @Column(name = "PESEL")
    private String socialSecurityNumber;

    @Column(name = "Plec")
    private char sex;

    @NotNull
    @Column(name = "Data_zatrudnienia")
    private Date firstDayAtWork;

    @NotNull
    @Column(name = "Nr_konta_bankowego")
    private String bankAccountNumber;

    @Column(name = "Email")
    private String workerEmail;

    @NotNull
    @Column(name = "Nr_telefonu")
    private String workerPhoneNumber;


    Integer getId() {
        return id;
    }

    void setId(final Integer id) {
        this.id = id;
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

    Date getDateOfBirth() {
        return dateOfBirth;
    }

    void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    void setSocialSecurityNumber(final String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    char getSex() {
        return sex;
    }

    void setSex(final char sex) {
        this.sex = sex;
    }

    Date getFirstDayAtWork() {
        return firstDayAtWork;
    }

    void setFirstDayAtWork(final Date firstDayAtWork) {
        this.firstDayAtWork = firstDayAtWork;
    }

    String getBankAccountNumber() {
        return bankAccountNumber;
    }

    void setBankAccountNumber(final String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    String getWorkerEmail() {
        return workerEmail;
    }

    void setWorkerEmail(final String workerEmail) {
        this.workerEmail = workerEmail;
    }

    String getWorkerPhoneNumber() {
        return workerPhoneNumber;
    }

    void setWorkerPhoneNumber(final String workerPhoneNumber) {
        this.workerPhoneNumber = workerPhoneNumber;
    }
}
