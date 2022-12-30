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



}