package pl.edu.pw.elka.bdbt.athleticsclub.athleticsclub;

import pl.edu.pw.elka.bdbt.athleticsclub.addresses.Addresses;
import pl.edu.pw.elka.bdbt.athleticsclub.owners.Owners;
import pl.edu.pw.elka.bdbt.athleticsclub.sportfacilities.SportFacilities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Klub_lekkoatletyczny")
public class AthleticsClub {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Nr_klubu")
    private Integer clubNumber;

    @NotNull
    @Column(name = "Nazwa")
    private String clubName;

    @NotNull
    @Column(name = "Data_zalozenia")
    private Date establishedDate;

    @NotNull
    @Column(name = "Nr_telefonu")
    private String clubPhoneNumber;

    @Column(name = "Email")
    private String clubEmail;

    @Column(name = "Nr_telefonu2")
    private String clubPhoneNumber2;

    @Column(name = "Strona_www")
    private String clubWebPage;


    @OneToOne
    @JoinColumn(name = "Nr_adresu")
    private Addresses clubAddressNumber;

    @OneToOne
    @JoinColumn(name = "Nr_wlasciciela")
    private Owners ownerOfAthleticsClub;

    @OneToMany(mappedBy = "athleticsClubFacility")
    private Set<SportFacilities> sportFacilities;


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

    public String getClubPhoneNumber() {
        return clubPhoneNumber;
    }

    public void setClubPhoneNumber(String clubPhoneNumber) {
        this.clubPhoneNumber = clubPhoneNumber;
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

    public void setClubEmail(String clubEmail) {
        this.clubEmail = clubEmail;
    }

    public String getClubWebPage() {
        return clubWebPage;
    }

    public void setClubWebPage(String clubWebPage) {
        this.clubWebPage = clubWebPage;
    }

    public Addresses getClubAddressNumber() {
        return clubAddressNumber;
    }

    public void setClubAddressNumber(Addresses clubAddressNumber) {
        this.clubAddressNumber = clubAddressNumber;
    }

    public Owners getOwnerOfAthleticsClub() {
        return ownerOfAthleticsClub;
    }

    public void setOwnerOfAthleticsClub(Owners ownerOfAthleticsClub) {
        this.ownerOfAthleticsClub = ownerOfAthleticsClub;
    }

    private Set<SportFacilities> getSportFacilities() {
        return sportFacilities;
    }

    private void setSportFacilities(Set<SportFacilities> sportFacilities) {
        this.sportFacilities = sportFacilities;
    }
}