package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Licencje_sportowe")
public class SportLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nr_licencji_sportowej")
    private Integer sportLicenseNumber;

    @Basic(optional = false)
    @Column(name = "data_waznosci")
    private Date expirationDate;

    @Basic(optional = false)
    @Column(name = "data_wydania")
    private Date releaseDate;

    @Basic(optional = false)
    @Column(name = "uprawnienia")
    private String permission;

    @Column(name = "kategoria_wiekowa")
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