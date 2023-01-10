package pl.edu.pw.elka.bdbt.athleticsclub.mvc.training;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TrainingReadModel {

    Integer number;
    LocalDate trainingDate;
    String discipline;
    String typeOfTraining;
    String trainingForce;
    String athleticsClubTraining;

    public static TrainingReadModel toReadModel(final Training entity) {
        return new TrainingReadModel(
                entity.getTrainingNumber(),
                entity.getTrainingDate(),
                entity.getTrainingDiscipline(),
                entity.getTypeOfTraining(),
                entity.getTrainingForceLoad(),
                entity.getAthleticsClubTraining().getClubName());
    }
}
