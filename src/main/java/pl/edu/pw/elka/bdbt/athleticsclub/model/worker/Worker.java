package pl.edu.pw.elka.bdbt.athleticsclub.model.worker;

import pl.edu.pw.elka.bdbt.athleticsclub.model.address.Addresses;
import pl.edu.pw.elka.bdbt.athleticsclub.model.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.model.salary.Salaries;
import pl.edu.pw.elka.bdbt.athleticsclub.model.trainer.Trainers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "Pracownicy")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Nr_pracownika")
    private Integer workerNumber;

//    @NotNull
    @Column(name = "Imie")
    private String workerName;

//    @NotNull
    @Column(name = "Nazwisko")
    private String workerSurname;

//    @NotNull
    @Column(name = "Data_urodzenia")
    private LocalDate workerDateOfBirth;

    @Column(name = "Pesel")
    private String workerPESEL;

//    @NotNull
    @Column(name = "Plec")
    private char workerSex;

//    @NotNull
    @Column(name = "Data_zatrudnienia")
    private LocalDate dateOfEmployment;

    @Column(name = "Nr_konta_bankowego")
    private String workerBankAccount;

    @Column(name = "Email")
    private String workerEmail;

//    @NotNull
    @Column(name = "Nr_telefonu")
    private String workerPhoneNumber;


    @ManyToOne
    @JoinColumn(name = "Nr_klubu")
    private AthleticsClub athleticsClubWorker;

    @ManyToOne
    @JoinColumn(name = "Nr_wynagrodzenia")
    private Salaries workerSalary;

    @OneToOne
    @JoinColumn(name = "Nr_adresu")
    private Addresses workerAddressNumber;

    public Addresses getWorkerAddressNumber() {
        return workerAddressNumber;
    }

    public void setWorkerAddressNumber(Addresses workerAddressNumber) {
        this.workerAddressNumber = workerAddressNumber;
    }

    public Salaries getWorkerSalary() {
        return workerSalary;
    }

    public void setWorkerSalary(Salaries workerSalary) {
        this.workerSalary = workerSalary;
    }

    public AthleticsClub getAthleticsClubWorker() {
        return athleticsClubWorker;
    }

    public void setAthleticsClubWorker(AthleticsClub athleticsClubWorker) {
        this.athleticsClubWorker = athleticsClubWorker;
    }

    public Integer getWorkerNumber() {
        return workerNumber;
    }

    public void setWorkerNumber(Integer workerNumber) {
        this.workerNumber = workerNumber;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerSurname() {
        return workerSurname;
    }

    public void setWorkerSurname(String workerSurname) {
        this.workerSurname = workerSurname;
    }

    public LocalDate getWorkerDateOfBirth() {
        return workerDateOfBirth;
    }

    public void setWorkerDateOfBirth(LocalDate workerDateOfBirth) {
        this.workerDateOfBirth = workerDateOfBirth;
    }

    public String getWorkerPESEL() {
        return workerPESEL;
    }

    public void setWorkerPESEL(String workerPESEL) {
        this.workerPESEL = workerPESEL;
    }

    public char getWorkerSex() {
        return workerSex;
    }

    public void setWorkerSex(char workerSex) {
        this.workerSex = workerSex;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public String getWorkerBankAccount() {
        return workerBankAccount;
    }

    public void setWorkerBankAccount(String workerBankAccount) {
        this.workerBankAccount = workerBankAccount;
    }

    public String getWorkerEmail() {
        return workerEmail;
    }

    public void setWorkerEmail(String workerEmail) {
        this.workerEmail = workerEmail;
    }

    public String getWorkerPhoneNumber() {
        return workerPhoneNumber;
    }

    public void setWorkerPhoneNumber(String workerPhoneNumber) {
        this.workerPhoneNumber = workerPhoneNumber;
    }
}