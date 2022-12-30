package pl.edu.pw.elka.bdbt.athleticsclub.trainers;

import pl.edu.pw.elka.bdbt.athleticsclub.sportlicenses.SportLicenses;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TRENERZY")
public class Trainers {
    @Id
    @Column(name = "NR_PRACOWNIKA")
    private Integer workerNumber;

    @NotNull
    @Column(name = "DATA_ROZPOCZECIA_KARIERY_TRENERSKIEJ")
    private Date coachCareerDateStart;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "NR_LICENCJI_SPORTOWEJ", nullable = false)
    private SportLicenses sportLicenseNumber;

    public Integer getWorkerNumber() {
        return workerNumber;
    }

    public void setWorkerNumber(Integer workerNumber) {
        this.workerNumber = workerNumber;
    }

    public Date getCoachCareerDateStart() {
        return coachCareerDateStart;
    }

    public void setCoachCareerDateStart(Date coachCareerDateStart) {
        this.coachCareerDateStart = coachCareerDateStart;
    }

    public SportLicenses getSportLicenseNumber() {
        return sportLicenseNumber;
    }

    public void setSportLicenseNumber(SportLicenses sportLicenseNumber) {
        this.sportLicenseNumber = sportLicenseNumber;
    }

}