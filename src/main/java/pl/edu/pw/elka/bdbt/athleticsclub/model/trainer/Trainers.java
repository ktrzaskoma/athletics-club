package pl.edu.pw.elka.bdbt.athleticsclub.model.trainer;

import pl.edu.pw.elka.bdbt.athleticsclub.model.worker.Worker;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Inheritance
@Table(name = "Trenerzy")
public class Trainers {

    @Id
    @Column(name = "Nr_trenera")
    private Integer workerNumber;

    @NotNull
    @Column(name = "Data_Rozpoczecia_Kariery_Trenerskiej")
    private Date coachCareerDateStart;




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

}