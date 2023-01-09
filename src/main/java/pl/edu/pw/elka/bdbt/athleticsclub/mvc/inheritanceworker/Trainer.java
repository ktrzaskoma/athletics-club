package pl.edu.pw.elka.bdbt.athleticsclub.mvc.inheritanceworker;

import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.Worker;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Trenerzy")
@PrimaryKeyJoinColumn(name = "nr_pracownika")
public class Trainer extends Worker {

    @Basic(optional = false)
    @Column(name = "data_rozpoczecia_kariery_trenerskiej")
    private Date coachCareerDateStart;

    public Date getCoachCareerDateStart() {
        return coachCareerDateStart;
    }

    public void setCoachCareerDateStart(Date coachCareerDateStart) {
        this.coachCareerDateStart = coachCareerDateStart;
    }

}