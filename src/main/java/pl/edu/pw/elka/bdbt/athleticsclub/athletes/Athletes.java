package pl.edu.pw.elka.bdbt.athleticsclub.athletes;

import pl.edu.pw.elka.bdbt.athleticsclub.sportlicenses.SportLicenses;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ZAWODNICY")
public class Athletes {

    @Id
    @NotNull
    @Column(name = "NR_PRACOWNIKA")
    private Integer workerNumber;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "NR_LICENCJI_SPORTOWEJ")
    private SportLicenses sportLicenseNumber;

    public Integer getWorkerNumber() {
        return workerNumber;
    }

    public void setWorkerNumber(Integer workerNumber) {
        this.workerNumber = workerNumber;
    }

    public SportLicenses getSportLicenseNumber() {
        return sportLicenseNumber;
    }

    public void setSportLicenseNumber(SportLicenses sportLicenseNumber) {
        this.sportLicenseNumber = sportLicenseNumber;
    }

}