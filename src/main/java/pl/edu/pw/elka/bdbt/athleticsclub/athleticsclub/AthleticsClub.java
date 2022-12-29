package pl.edu.pw.elka.bdbt.athleticsclub.athleticsclub;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Klub_lekkoatletyczny")
public class AthleticsClub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Nr_klubu")
    private Integer id;

    @NotNull
    @Column(name = "Nazwa")
    private String clubName;

    @Column(name = "Data_zalozenia")
    private Date establishedDate;

    @NotNull
    @Column(name = "Nr_telefonu")
    private String clubPhoneNumber1;

    @Column(name = "Nr_telefonu2")
    private String clubPhoneNumber2;

    @Column(name = "Email")
    private String clubEmail;

    @Column(name = "Strona_www")
    private String clubWebPage;


     public Integer getId() {
        return id;
    }

     public void setId(final Integer id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(final String clubName) {
        this.clubName = clubName;
    }

    public Date getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(final Date establishedDate) {
        this.establishedDate = establishedDate;
    }

    public String getClubPhoneNumber1() {
        return clubPhoneNumber1;
    }

    public void setClubPhoneNumber1(final String clubPhoneNumber1) {
        this.clubPhoneNumber1 = clubPhoneNumber1;
    }

    public String getClubPhoneNumber2() {
        return clubPhoneNumber2;
    }

    public void setClubPhoneNumber2(final String clubPhoneNumber2) {
        this.clubPhoneNumber2 = clubPhoneNumber2;
    }

    public String getClubEmail() {
        return clubEmail;
    }

    public void setClubEmail(final String clubEmail) {
        this.clubEmail = clubEmail;
    }

    public String getClubWebPage() {
        return clubWebPage;
    }

    public void setClubWebPage(final String clubWebPage) {
        this.clubWebPage = clubWebPage;
    }

//  method to update data in athletic club
    public void updateFormOfAthleticClub(final AthleticsClub source) {
         clubName = source.clubName;
         establishedDate = source.establishedDate;
         clubPhoneNumber1 = source.clubPhoneNumber1;
         clubPhoneNumber2 = source.clubPhoneNumber2;
         clubEmail = source.clubEmail;
         clubWebPage = source.clubWebPage;
    }
}
