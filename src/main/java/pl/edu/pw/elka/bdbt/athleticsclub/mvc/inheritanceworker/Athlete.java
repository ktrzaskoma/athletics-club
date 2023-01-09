package pl.edu.pw.elka.bdbt.athleticsclub.mvc.inheritanceworker;

import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense.SportLicense;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.Worker;

import javax.persistence.*;

@Entity
@Table(name = "Zawodnicy")
@PrimaryKeyJoinColumn(name = "nr_pracownika")
public class Athlete extends Worker {

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "nr_licencji_sportowej")
    private SportLicense sportLicenseNumber;

    public SportLicense getSportLicenseNumber() {
        return sportLicenseNumber;
    }

    public void setSportLicenseNumber(SportLicense sportLicenseNumber) {
        this.sportLicenseNumber = sportLicenseNumber;
    }

}