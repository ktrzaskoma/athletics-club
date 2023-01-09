package pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker;

import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.salary.Salary;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Pracownicy")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nr_pracownika")
    private Integer number;

    @Basic(optional = false)
    @Column(name = "imie")
    private String name;

    @Basic(optional = false)
    @Column(name = "nazwisko")
    private String surname;

    @Basic(optional = false)
    @Column(name = "data_urodzenia")
    private LocalDate dateOfBirth;

    @Column(name = "pesel", unique = true)
    private String pesel;

    @Basic(optional = false)
    @Column(name = "plec")
    private char sex;

    @Basic(optional = false)
    @Column(name = "data_zatrudnienia")
    private LocalDate dateOfEmployment;

    @Column(name = "nr_konta_bankowego")
    private String bankAccount;

    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @Column(name = "nr_telefonu")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "Nr_klubu")
    private AthleticsClub athleticsClubWorker;

    @ManyToOne
    @JoinColumn(name = "Nr_wynagrodzenia")
    private Salary workerSalary;

    @OneToOne
    @JoinColumn(name = "Nr_adresu")
    private Address workerAddressNumber;

    public Address getWorkerAddressNumber() {
        return workerAddressNumber;
    }

    public void setWorkerAddressNumber(Address workerAddressNumber) {
        this.workerAddressNumber = workerAddressNumber;
    }

    public Salary getWorkerSalary() {
        return workerSalary;
    }

    public void setWorkerSalary(Salary workerSalary) {
        this.workerSalary = workerSalary;
    }

    public AthleticsClub getAthleticsClubWorker() {
        return athleticsClubWorker;
    }

    public void setAthleticsClubWorker(AthleticsClub athleticsClubWorker) {
        this.athleticsClubWorker = athleticsClubWorker;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer workerNumber) {
        this.number = workerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String workerName) {
        this.name = workerName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String workerSurname) {
        this.surname = workerSurname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate workerDateOfBirth) {
        this.dateOfBirth = workerDateOfBirth;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String workerPESEL) {
        this.pesel = workerPESEL;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char workerSex) {
        this.sex = workerSex;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String workerBankAccount) {
        this.bankAccount = workerBankAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String workerEmail) {
        this.email = workerEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String workerPhoneNumber) {
        this.phoneNumber = workerPhoneNumber;
    }
}