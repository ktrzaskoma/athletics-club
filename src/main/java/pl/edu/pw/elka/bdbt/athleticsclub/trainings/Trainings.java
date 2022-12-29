package pl.edu.pw.elka.bdbt.athleticsclub.trainings;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "TRENINGI")
public class Trainings {
    @Id
    @NotNull
    @Column(name = "NR_TRENINGU")
    private Integer trainingNumber;

    @NotNull
    @Column(name = "DATA_TRENINGU")
    private Date trainingDate;

    @NotNull
    @Column(name = "DYSCYPLINA_TRENINGU")
    private String trainingDiscipline;

    @NotNull
    @Column(name = "RODZAJ_TRENINGU")
    private String typeOfTraining;

    @NotNull
    @Column(name = "OBCIAZENIE_TRENINGU", nullable = false, length = 50)
    private String trainingForceLoad;

    @NotNull
    @Column(name = "NR_KLUBU", nullable = false)
    private Integer clubNumber;

    public Integer getTrainingNumber() {
        return trainingNumber;
    }

    public void setTrainingNumber(Integer trainingNumber) {
        this.trainingNumber = trainingNumber;
    }

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }

    public String getTrainingDiscipline() {
        return trainingDiscipline;
    }

    public void setTrainingDiscipline(String trainingDiscipline) {
        this.trainingDiscipline = trainingDiscipline;
    }

    public String getTypeOfTraining() {
        return typeOfTraining;
    }

    public void setTypeOfTraining(String typeOfTraining) {
        this.typeOfTraining = typeOfTraining;
    }

    public String getTrainingForceLoad() {
        return trainingForceLoad;
    }

    public void setTrainingForceLoad(String trainingForceLoad) {
        this.trainingForceLoad = trainingForceLoad;
    }

    public Integer getClubNumber() {
        return clubNumber;
    }

    public void setClubNumber(Integer clubNumber) {
        this.clubNumber = clubNumber;
    }

}