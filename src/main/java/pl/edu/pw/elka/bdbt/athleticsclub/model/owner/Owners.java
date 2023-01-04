package pl.edu.pw.elka.bdbt.athleticsclub.model.owner;

import pl.edu.pw.elka.bdbt.athleticsclub.model.address.Addresses;
import pl.edu.pw.elka.bdbt.athleticsclub.model.athleticsclub.AthleticsClub;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "Wlasciciele")
public class Owners {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Nr_wlasciciela")
    private Integer ownerNumber;

    @NotNull
    @Column(name = "Imie")
    private String ownerName;

    @NotNull
    @Column(name = "Nazwisko")
    private String ownerSurname;

    @NotNull
    @Column(name = "Data_urodzenia")
    private LocalDate ownerDateOfBirth;

    @Column(name = "Pesel")
    private String ownerPESEL;

    @NotNull
    @Column(name = "Plec")
    private char sex;

    @Column(name = "Nr_konta_bankowego")
    private String bankAccountNumber;

    @Column(name = "Email")
    private String email;

    @NotNull
    @Column(name = "Nr_telefonu")
    private String ownerPhoneNumber;

    @OneToOne
    @JoinColumn(name = "Nr_adresu")
    private Addresses ownerAddressNumber;

//    sending column athletics club
    @OneToOne(mappedBy = "ownerOfAthleticsClub")
    private AthleticsClub athleticsClub;



    public Addresses getOwnerAddressNumber() {
        return ownerAddressNumber;
    }
    public void setOwnerAddressNumber(Addresses ownerAddressNumber) {
        this.ownerAddressNumber = ownerAddressNumber;
    }



    public Integer getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(Integer ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String ownerSurname) {
        this.ownerSurname = ownerSurname;
    }

    public LocalDate getOwnerDateOfBirth() {
        return ownerDateOfBirth;
    }

    public void setOwnerDateOfBirth(LocalDate ownerDateOfBirth) {
        this.ownerDateOfBirth = ownerDateOfBirth;
    }

    public String getOwnerPESEL() {
        return ownerPESEL;
    }

    public void setOwnerPESEL(String ownerPESEL) {
        this.ownerPESEL = ownerPESEL;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }


}