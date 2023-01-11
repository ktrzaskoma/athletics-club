package pl.edu.pw.elka.bdbt.athleticsclub.mvc.training;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;

import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingWriteModel {

    LocalDate trainingDate;
    String discipline;
    String type;
    String forceLoad;
    AthleticsClub athleticsClub;

    public static Training toEntity(TrainingWriteModel writeModel) {
        var entity = new Training();
        entity.setTrainingDate(writeModel.getTrainingDate());
        entity.setTrainingDiscipline(writeModel.getDiscipline());
        entity.setTypeOfTraining(writeModel.getType());
        entity.setTrainingForceLoad(writeModel.getForceLoad());
        entity.setAthleticsClubTraining(new AthleticsClub());
        return entity;
    }

}
