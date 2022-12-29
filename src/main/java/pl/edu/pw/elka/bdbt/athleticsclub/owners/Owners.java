package pl.edu.pw.elka.bdbt.athleticsclub.owners;

import pl.edu.pw.elka.bdbt.athleticsclub.addresses.Addresses;
import pl.edu.pw.elka.bdbt.athleticsclub.athleticsclub.AthleticsClub;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "Wlasciciele")
public class Owners {
    @Id
    @Column(name = "NR_WLASCICIELA")
    private Integer ownerNumber;

    @NotNull
    @Column(name = "IMIE")
    private String ownerName;

    @NotNull
    @Column(name = "NAZWISKO")
    private String ownerSurname;

    @NotNull
    @Column(name = "DATA_URODZENIA")
    private LocalDate ownerDateOfBirth;

    @Column(name = "PESEL")
    private String ownerPESEL;

    @NotNull
    @Column(name = "PLEC")
    private Boolean sex = false;

    @Column(name = "NR_KONTA_BANKOWEGO")
    private String bankAccountNumber;

    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Column(name = "NR_TELEFONU")
    private String ownerPhoneNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NR_ADRESU", nullable = false)
    private Addresses addressNumber;

    @OneToMany(mappedBy = "ownerNumber")
    private Set<AthleticsClub> athleticsClub = new LinkedHashSet<>();

    public Integer getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(Integer id) {
        this.ownerNumber = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String imie) {
        this.ownerName = imie;
    }

    public String getOwnerSurname() {
        return ownerSurname;
    }

    public void setOwnerSurname(String nazwisko) {
        this.ownerSurname = nazwisko;
    }

    public LocalDate getOwnerDateOfBirth() {
        return ownerDateOfBirth;
    }

    public void setOwnerDateOfBirth(LocalDate dataUrodzenia) {
        this.ownerDateOfBirth = dataUrodzenia;
    }

    public String getOwnerPESEL() {
        return ownerPESEL;
    }

    public void setOwnerPESEL(String ownerPESEL) {
        this.ownerPESEL = ownerPESEL;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean plec) {
        this.sex = plec;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String nrKontaBankowego) {
        this.bankAccountNumber = nrKontaBankowego;
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

    public void setOwnerPhoneNumber(String nrTelefonu) {
        this.ownerPhoneNumber = nrTelefonu;
    }

    public Addresses getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(Addresses nrAdresu) {
        this.addressNumber = nrAdresu;
    }

    public Set<AthleticsClub> getAthleticsClub() {
        return athleticsClub;
    }

    public void setAthleticsClub(Set<AthleticsClub> klubLekkoatletycznies) {
        this.athleticsClub = klubLekkoatletycznies;
    }

}