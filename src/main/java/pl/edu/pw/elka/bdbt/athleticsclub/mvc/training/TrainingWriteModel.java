package pl.edu.pw.elka.bdbt.athleticsclub.mvc.training;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TrainingWriteModel {

    Date trainingDate;
    String discipline;
    String type;
    String forceLoad;
    AthleticsClub athleticsClub;

    public static Training toTraining(TrainingWriteModel toSaveModel){
        var trainingToSave = new Training();
        trainingToSave.setTrainingDate(toSaveModel.trainingDate.toLocalDate());
        trainingToSave.setTrainingDiscipline(toSaveModel.discipline);
        trainingToSave.setTypeOfTraining(toSaveModel.type);
        trainingToSave.setTrainingForceLoad(toSaveModel.forceLoad);
        trainingToSave.setAthleticsClubTraining(toSaveModel.athleticsClub);
        return trainingToSave;
    }

}
