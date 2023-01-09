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

    public static TrainingReadModel toTrainingDTO(final Training training) {
        return new TrainingReadModel(
                training.getTrainingNumber(),
                training.getTrainingDate(),
                training.getTrainingDiscipline(),
                training.getTypeOfTraining(),
                training.getTrainingForceLoad(),
                training.getAthleticsClubTraining().getClubName());
    }
}
