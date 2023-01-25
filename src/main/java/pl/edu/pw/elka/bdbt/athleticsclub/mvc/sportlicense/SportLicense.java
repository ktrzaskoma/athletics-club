package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense;

import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.Worker;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Licencje_sportowe")
public class SportLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nr_licencji_sportowej")
    private Integer sportLicenseNumber;

    @Basic(optional = false)
    @Column(name = "data_waznosci")
    private LocalDate expirationDate;

    @Basic(optional = false)
    @Column(name = "data_wydania")
    private LocalDate releaseDate;

    @Basic(optional = false)
    @Column(name = "uprawnienia")
    private String permission;

    @Column(name = "kategoria_wiekowa")
    private String ageCategory;

    @OneToOne(mappedBy = "license")
    private Worker worker;

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Integer getSportLicenseNumber() {
        return sportLicenseNumber;
    }

    public void setSportLicenseNumber(Integer sportLicenseNumber) {
        this.sportLicenseNumber = sportLicenseNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
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