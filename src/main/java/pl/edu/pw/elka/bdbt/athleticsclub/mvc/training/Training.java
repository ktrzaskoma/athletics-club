package pl.edu.pw.elka.bdbt.athleticsclub.mvc.training;

import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Treningi")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nr_treningu")
    private Integer trainingNumber;

    @Basic(optional = false)
    @Column(name = "data_treningu")
    private LocalDate trainingDate;

    @Basic(optional = false)
    @Column(name = "dyscyplina_treningu")
    private String trainingDiscipline;

    @Basic(optional = false)
    @Column(name = "rodzaj_treningu")
    private String typeOfTraining;

    @Basic(optional = false)
    @Column(name = "obciazenie_treningu")
    private String trainingForceLoad;

    @ManyToOne
    @JoinColumn(name = "nr_klubu")
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

    public LocalDate getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(LocalDate trainingDate) {
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