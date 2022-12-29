package pl.edu.pw.elka.bdbt.athleticsclub.athleticsclub;

import pl.edu.pw.elka.bdbt.athleticsclub.addresses.Addresses;
import pl.edu.pw.elka.bdbt.athleticsclub.owners.Owners;
import pl.edu.pw.elka.bdbt.athleticsclub.sportfacilities.SportFacilities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "KLUB_LEKKOATLETYCZNY")
public class AthleticsClub {
    @Id
    @Column(name = "NR_KLUBU")
    private Integer clubNumber;

    @NotNull
    @Column(name = "NAZWA")
    private String clubName;

    @NotNull
    @Column(name = "DATA_ZALOZENIA")
    private Date establishedDate;

    @NotNull
    @Column(name = "NR_TELEFON")
    private String clubPhoneNumber1;

    @Column(name = "NR_TELEFON2")
    private String clubPhoneNumber2;

    @Column(name = "EMAIL")
    private String clubEmail;

    @Column(name = "STRONA_WWW")
    private String clubWebPage;

    @OneToMany(mappedBy = "clubNumber")
    private Set<SportFacilities> sportFacilities;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NR_ADRESU", nullable = false)
    private Addresses addressNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NR_WLASCICIELA", nullable = false)
    private Owners ownerNumber;



    public Integer getClubNumber() {
        return clubNumber;
    }

    public void setClubNumber(Integer clubNumber) {
        this.clubNumber = clubNumber;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Date getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(Date establishedDate) {
        this.establishedDate = establishedDate;
    }

    public String getClubPhoneNumber1() {
        return clubPhoneNumber1;
    }

    public void setClubPhoneNumber1(String clubPhoneNumber1) {
        this.clubPhoneNumber1 = clubPhoneNumber1;
    }

    public String getClubPhoneNumber2() {
        return clubPhoneNumber2;
    }

    public void setClubPhoneNumber2(String clubPhoneNumber2) {
        this.clubPhoneNumber2 = clubPhoneNumber2;
    }

    public String getClubEmail() {
        return clubEmail;
    }

    public void setClubEmail(String email) {
        this.clubEmail = email;
    }

    public String getClubWebPage() {
        return clubWebPage;
    }

    public void setClubWebPage(String clubWebPage) {
        this.clubWebPage = clubWebPage;
    }

    public Addresses getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(Addresses addressNumber) {
        this.addressNumber = addressNumber;
    }

    public Owners getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(Owners ownerNumber) {
        this.ownerNumber = ownerNumber;
    }


    public Set<SportFacilities> getSportFacilities() {
        return sportFacilities;
    }

    public void setSportFacilities(Set<SportFacilities> sportFacilities) {
        this.sportFacilities = sportFacilities;
    }
}