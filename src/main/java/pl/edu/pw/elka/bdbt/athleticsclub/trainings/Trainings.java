package pl.edu.pw.elka.bdbt.athleticsclub.trainings;

import pl.edu.pw.elka.bdbt.athleticsclub.athleticsclub.AthleticsClub;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "Treningi")
public class Trainings {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Nr_treningu")
    private Integer trainingNumber;

    @NotNull
    @Column(name = "Data_treningu")
    private Date trainingDate;

    @NotNull
    @Column(name = "Dyscyplina_treningu")
    private String trainingDiscipline;

    @NotNull
    @Column(name = "Rodzaj_treningu")
    private String typeOfTraining;

    @NotNull
    @Column(name = "Obciazenie_treningu")
    private String trainingForceLoad;

    @ManyToOne
    @JoinColumn(name = "Nr_klubu")
    private AthleticsClub athleticsClubTraining;

    public AthleticsClub getAthleticsClubTraining() {
        return athleticsClubTraining;
    }

    public void setAthleticsClubTraining(AthleticsClub athleticsClubTraining) {
        this.athleticsClubTraining = athleticsClubTraining;
    }

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
}