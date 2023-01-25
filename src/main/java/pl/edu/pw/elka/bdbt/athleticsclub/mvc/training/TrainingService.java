package pl.edu.pw.elka.bdbt.athleticsclub.mvc.training;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.Worker;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.WorkerReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.WorkerRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log4j2
public class TrainingService {

    private final TrainingRepository trainingRepository;
    private final AthleticsClubRepository athleticsClubRepository;
    private final WorkerRepository workerRepository;

    List<TrainingReadModel> getTrainings() {
        return trainingRepository.findAll()
                .stream().map(
                        TrainingReadModel::toReadModel
                ).toList();
    }

    TrainingReadModel getTrainingById(final String itTraining) {
        var entity = trainingRepository.getById(Integer.valueOf(itTraining));
        return TrainingReadModel.toReadModel(entity);
    }

    void addAthleteToTraining(final String idAthlete, final String idTraining) {
        var athlete = workerRepository.getById(Integer.valueOf(idAthlete));
        var training = trainingRepository.getById(Integer.valueOf(idTraining));
        var athletes = training.getWorkers();
        athletes.add(athlete);
        training.setWorkers(athletes);
        trainingRepository.save(training);
    }

    List<WorkerReadModel> getFormattedAthletesForTrainingTraining(final String idTraining) {
        var training = trainingRepository.getById(Integer.valueOf(idTraining)).getWorkers()
                .stream().map(Worker::getNumber).toList();
        var athletes = workerRepository.findAll();
        return athletes.stream().filter(entity -> training.contains(entity.getNumber())).map(
                WorkerReadModel::toReadModel).toList();
    }

    void signOffAthlete(final String idAthlete, final String idTraining) {
        var athlete = workerRepository.getById(Integer.valueOf(idAthlete));
        var trainingsForAthlete = athlete.getTrainings().stream()
                .filter(entity -> !idTraining.equals(entity.getTrainingNumber().toString()))
                .collect(Collectors.toSet());
        athlete.setTrainings(trainingsForAthlete);

        var training = trainingRepository.getById(Integer.valueOf(idTraining));
        var athletesForTraining = training.getWorkers().stream()
                .filter(entity -> !idAthlete.equals(entity.getNumber().toString()))
                .collect(Collectors.toSet());
        training.setWorkers(athletesForTraining);

        workerRepository.save(athlete);
        trainingRepository.save(training);
    }


    Map<Integer, String> getFormattedClubs() {
        return athleticsClubRepository.findAll()
                .stream().map(AthleticsClubReadModel::toReadModel)
                .collect(Collectors.toMap(AthleticsClubReadModel::getNumber, AthleticsClubReadModel::toString));
    }

    Map<Integer, String> getFormattedWorkers() {
        return workerRepository.findAll().stream().map(
                WorkerReadModel::toReadModel
        ).collect(Collectors.toMap(WorkerReadModel::getNumber, WorkerReadModel::toString));
    }

    Map<Integer, String> getFormattedWorkersAvailableForTraining(final String idTraining) {
        var training = trainingRepository.getById(Integer.valueOf(idTraining)).getWorkers()
                .stream().map(Worker::getNumber).toList();
        var athletes = workerRepository.findAll();
        return athletes.stream().filter(entity -> !training.contains(entity.getNumber())).map(
                WorkerReadModel::toReadModel
        ).collect(Collectors.toMap(WorkerReadModel::getNumber, WorkerReadModel::toString));
    }

    void saveTraining(final TrainingWriteModel writeModel) {
        var club = athleticsClubRepository.getById(writeModel.getAthleticsClub());
        trainingRepository.save(TrainingWriteModel.toEntity(writeModel, club));
    }

    public void deleteTraining(final String idTraining) {
        log.info("Delete entry in DB!");
        var trainingToDelete = trainingRepository.getById(Integer.valueOf(idTraining));
        trainingToDelete.setAthleticsClubTraining(null);
        trainingToDelete.setWorkers(null);
        var savedTraining = trainingRepository.save(trainingToDelete);
        trainingRepository.deleteById(savedTraining.getTrainingNumber());
    }

    TrainingWriteModel editTraining(final String idTraining) {
        log.info("Edit entry in DB!");
        var editEntry = trainingRepository.getById(Integer.valueOf(idTraining));

        return new TrainingWriteModel(
                editEntry.getTrainingDate(),
                editEntry.getTrainingDiscipline(),
                editEntry.getTypeOfTraining(),
                editEntry.getTrainingForceLoad(),
                editEntry.getAthleticsClubTraining().getClubNumber(),
                editEntry.getTrainingNumber()
        );
    }

    public void modifyTraining(final TrainingWriteModel writeModel) {
        log.info("Saving entry in DB!");
        var trainingToModify = trainingRepository.getById(writeModel.getNumber());
        trainingToModify.setAthleticsClubTraining(null);
        trainingToModify.setWorkers(null);
        var savedTraining = trainingRepository.save(trainingToModify);
        trainingRepository.deleteById(savedTraining.getTrainingNumber());
        saveTraining(writeModel);
    }
}
