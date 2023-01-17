package pl.edu.pw.elka.bdbt.athleticsclub.mvc.training;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.Worker;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingWriteModel {

    @NotNull(message = "Pole Data treningu nie może być puste!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate trainingDate;
    @NotBlank(message = "Pole Dyscyplina nie może być puste!")
    String discipline;
    @NotNull(message = "Pole Liczba uczestników nie może być puste!")
    Integer numberOfParticipants;
    @NotBlank(message = "Pole Typ treningu nie może być puste!")
    String type;
    @NotBlank(message = "Pole Obciążenie treningu nie może być puste!")
    String forceLoad;
    Integer athleticsClub;

    public static Training toEntity(final TrainingWriteModel writeModel, final AthleticsClub athleticsClub) {
        var entity = new Training();
        entity.setTrainingDate(writeModel.getTrainingDate());
        entity.setTrainingDiscipline(writeModel.getDiscipline());
        entity.setNumberOfParticipants(writeModel.getNumberOfParticipants());
        entity.setTypeOfTraining(writeModel.getType());
        entity.setTrainingForceLoad(writeModel.getForceLoad());
        entity.setAthleticsClubTraining(athleticsClub);
        return entity;
    }



}
