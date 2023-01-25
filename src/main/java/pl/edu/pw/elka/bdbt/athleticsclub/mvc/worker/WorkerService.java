package pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense.SportLicenseRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense.SportLicenseWriteModel;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
class WorkerService {

    private final WorkerRepository workerRepository;
    private final AthleticsClubRepository athleticsClubRepository;
    private final AddressRepository addressRepository;
    private final SportLicenseRepository sportLicenseRepository;

    List<WorkerReadModel> getWorkers() {
        log.info("Finding all entries in DB!");
        return workerRepository.findAll()
                .stream()
                .map(WorkerReadModel::toReadModel)
                .toList();
    }

    void saveWorker(final WorkerWriteModel workerWriteModel, final SportLicenseWriteModel sportLicenseWriteModel) {
        log.info("Saving entry in DB!");
        var club = athleticsClubRepository.getById(workerWriteModel.getAthleticsClubWorker());
        var address = addressRepository.getById(workerWriteModel.getWorkerAddressNumber());
        var savedLicense = sportLicenseRepository.save(SportLicenseWriteModel.toEntity(
                sportLicenseWriteModel
        ));
        workerRepository.save(WorkerWriteModel.toEntity(workerWriteModel, club, savedLicense, address));
    }

    void modifyWorker(final WorkerWriteModel workerWriteModel, final SportLicenseWriteModel sportLicenseWriteModel) {
        log.info("Saving entry in DB!");
        var club = athleticsClubRepository.getById(workerWriteModel.getAthleticsClubWorker());
        var address = addressRepository.getById(workerWriteModel.getWorkerAddressNumber());
        var savedLicense = sportLicenseRepository.save(SportLicenseWriteModel.toEntity(
                sportLicenseWriteModel
        ));

        var workerToModify = workerRepository.getById(workerWriteModel.getNumber());
        var licenseNumber = workerToModify.getLicense().getSportLicenseNumber();
        workerToModify.setWorkerAddressNumber(null);
        workerToModify.setAthleticsClubWorker(null);
        workerToModify.setLicense(null);
        workerRepository.save(workerToModify);
        sportLicenseRepository.deleteById(licenseNumber);
        workerRepository.save(WorkerWriteModel.toEntity(workerWriteModel, club, savedLicense, address));
    }

    Map<Integer, String> getFormattedAddresses() {
        return addressRepository.findAll().stream().map(
                AddressReadModel::toReadModel
        ).collect(Collectors.toMap(AddressReadModel::getNumber, AddressReadModel::toString));
    }

    Map<Integer, String> getFormattedClubs() {
        return athleticsClubRepository.findAll().stream().map(
                AthleticsClubReadModel::toReadModel
        ).collect(Collectors.toMap(AthleticsClubReadModel::getNumber, AthleticsClubReadModel::toString));
    }

    WorkerWriteModel editWorker(final String idWorker) {
        log.info("Edit entry in DB!");
        var editEntry = workerRepository.getById(Integer.valueOf(idWorker));

        var clubNumber = Objects.nonNull(editEntry.getAthleticsClubWorker()) ?
                editEntry.getAthleticsClubWorker().getClubNumber() : null;

        var addressNumber = Objects.nonNull(editEntry.getWorkerAddressNumber()) ?
                editEntry.getWorkerAddressNumber().getAddressNumber() : null;

        return new WorkerWriteModel(
                editEntry.getName(),
                editEntry.getSurname(),
                editEntry.getDateOfBirth(),
                editEntry.getPesel(),
                editEntry.getSex(),
                editEntry.getDateOfEmployment(),
                editEntry.getBankAccount(),
                editEntry.getEmail(),
                editEntry.getPhoneNumber(),
                clubNumber,
                addressNumber,
                editEntry.getMonthlySalary(),
                editEntry.getLicense(),
                editEntry.getNumber()
        );
    }

    SportLicenseWriteModel editLicense(final String idLicense) {
        log.info("Edit entry in DB!");
        var editEntry = sportLicenseRepository.getById(Integer.valueOf(idLicense));
        return new SportLicenseWriteModel(
                editEntry.getExpirationDate(),
                editEntry.getReleaseDate(),
                editEntry.getPermission(),
                editEntry.getAgeCategory(),
                Collections.emptySet()
        );
    }

    void deleteWorker(final String idWorker) {
        log.info("Delete entry in DB!");
        var workerToDelete = workerRepository.getById(Integer.valueOf(idWorker));
        var licenseIdToDelete = workerToDelete.getLicense().getSportLicenseNumber();
        workerToDelete.setAthleticsClubWorker(null);
        workerToDelete.setWorkerAddressNumber(null);
        workerToDelete.setLicense(null);
        var savedWorker = workerRepository.save(workerToDelete);
        workerRepository.deleteById(savedWorker.getNumber());
        sportLicenseRepository.deleteById(licenseIdToDelete);
    }
}
