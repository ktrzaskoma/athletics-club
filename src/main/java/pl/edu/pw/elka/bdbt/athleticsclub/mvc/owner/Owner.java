package pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner;

import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Wlasciciele")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nr_wlasciciela")
    private Integer ownerNumber;

    @Basic(optional = false)
    @Column(name = "imie")
    private String ownerName;

    @Basic(optional = false)
    @Column(name = "nazwisko")
    private String ownerSurname;

    @Basic(optional = false)
    @Column(name = "data_urodzenia")
    private LocalDate ownerDateOfBirth;

    @Column(name = "pesel")
    private String ownerPESEL;

    @Basic(optional = false)
    @Column(name = "plec")
    private String sex;

    @Column(name = "nr_konta_bankowego")
    private String bankAccountNumber;

    @Column(name = "email")
    private String email;

    @Basic(optional = false)
    @Column(name = "nr_telefonu")
    private String ownerPhoneNumber;

    @ManyToOne
    @JoinColumn(name = "nr_adresu")
    private Address ownerAddressNumber;

//    sending column athletics club
    @OneToOne(mappedBy = "ownerOfAthleticsClub")
    private AthleticsClub athleticsClub;



    public Address getOwnerAddressNumber() {
        return ownerAddressNumber;
    }
    public void setOwnerAddressNumber(Address ownerAddressNumber) {
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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