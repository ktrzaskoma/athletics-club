package pl.edu.pw.elka.bdbt.athleticsclub.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.model.Training;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class TrainingDTO {

    Integer number;
    Date trainingDate;
    String discipline;
    String typeOfTraining;
    String trainingForce;
    String athleticsClubTraining;

    public static TrainingDTO toTrainingDTO(final Training training) {
        return new TrainingDTO(
                training.getTrainingNumber(),
                training.getTrainingDate(),
                training.getTrainingDiscipline(),
                training.getTypeOfTraining(),
                training.getTrainingForceLoad(),
                training.getAthleticsClubTraining().getClubName());
    }
}
