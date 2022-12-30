package pl.edu.pw.elka.bdbt.athleticsclub.sportlicenses;

import pl.edu.pw.elka.bdbt.athleticsclub.athletes.Athletes;
import pl.edu.pw.elka.bdbt.athleticsclub.trainers.Trainers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "LICENCJE_SPORTOWE")
public class SportLicenses {
    @Id
    @Column(name = "NR_LICENCJI_SPORTOWEJ")
    private Integer sportLicenseNumber;

    @NotNull
    @Column(name = "DATA_WAZNOSCI")
    private Date expirationDate;

    @NotNull
    @Column(name = "DATA_WYDANIA")
    private Date releaseDate;

    @NotNull
    @Column(name = "UPRAWNIENIA")
    private String permissions;

    @Column(name = "KATEGORIA_WIEKOWA")
    private String ageCategory;

    @OneToOne(mappedBy = "sportLicenseNumber")
    @PrimaryKeyJoinColumn
    private Trainers trainers;

    @OneToOne(mappedBy = "sportLicenseNumber")
    @PrimaryKeyJoinColumn
    private Athletes athletes;

    public Integer getSportLicenseNumber() {
        return sportLicenseNumber;
    }

    public void setSportLicenseNumber(Integer sportLicenseNumber) {
        this.sportLicenseNumber = sportLicenseNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    public Trainers getTrainers() {
        return trainers;
    }

    public void setTrainers(final Trainers trainers) {
        this.trainers = trainers;
    }

    public Athletes getAthletes() {
        return athletes;
    }

    public void setAthletes(final Athletes athletes) {
        this.athletes = athletes;
    }
}