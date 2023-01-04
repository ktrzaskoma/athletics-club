package pl.edu.pw.elka.bdbt.athleticsclub.model.sportlicense;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Licencje_sportowe")
public class SportLicenses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Nr_licencji_sportowej")
    private Integer sportLicenseNumber;

    @NotNull
    @Column(name = "Data_waznosci")
    private Date expirationDate;

    @NotNull
    @Column(name = "Data_wydania")
    private Date releaseDate;

    @NotNull
    @Column(name = "Uprawnienia")
    private String permission;

    @Column(name = "Kategoria_wiekowa")
    private String ageCategory;

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

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }
}