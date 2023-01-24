package pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker;

import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense.SportLicense;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.training.Training;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


@Entity
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

    @Basic(optional = false)
    @Column(name = "pesel", unique = true)
    private String pesel;

    @Basic(optional = false)
    @Column(name = "plec")
    private String sex;

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
    @JoinColumn(name = "Nr_adresu")
    private Address workerAddressNumber;

    @Column(name = "wynagrodzenie_miesięczne")
    private String monthlySalary;

    @OneToOne
    @JoinColumn(
            name = "Nr_licencji_sportowej"
    )
    private SportLicense license;

    @ManyToMany
    private Set<Training> trainings;

    public SportLicense getLicense() {
        return license;
    }

    public void setLicense(SportLicense license) {
        this.license = license;
    }

    public String getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(String monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Address getWorkerAddressNumber() {
        return workerAddressNumber;
    }

    public void setWorkerAddressNumber(Address workerAddressNumber) {
        this.workerAddressNumber = workerAddressNumber;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String workerSex) {
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

    public Set<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(Set<Training> trainings) {
        this.trainings = trainings;
    }
}