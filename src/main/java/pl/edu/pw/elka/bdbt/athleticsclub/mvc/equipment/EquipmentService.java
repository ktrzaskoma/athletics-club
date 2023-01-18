package pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipment;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubWriteModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility.FacilityReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility.FacilityRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.producer.ProducerReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.producer.ProducerRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final ProducerRepository producerRepository;
    private final AthleticsClubRepository athleticsClubRepository;
    private final FacilityRepository facilityRepository;

    List<EquipmentReadModel> getEquipments() {
        return equipmentRepository.findAll()
                .stream().map(
                        EquipmentReadModel::toReadModel
                ).toList();
    }

    Map<Integer, String> getFormattedClubs() {
        return athleticsClubRepository.findAll()
                .stream().map(AthleticsClubReadModel::toReadModel)
                .collect(Collectors.toMap(AthleticsClubReadModel::getNumber, AthleticsClubReadModel::toString));
    }

    Map<Integer, String> getFormattedProducers() {
        return producerRepository.findAll()
                .stream().map(ProducerReadModel::toReadModel)
                .collect(Collectors.toMap(ProducerReadModel::getNumber, ProducerReadModel::toString));
    }

    Map<Integer, String> getFormattedFacilities() {
        return facilityRepository.findAll()
                .stream().map(FacilityReadModel::toReadModel)
                .collect(Collectors.toMap(FacilityReadModel::getNumber, FacilityReadModel::toString));
    }

    void saveEquipment(final EquipmentWriteModel writeModel) {
        var club = athleticsClubRepository.getById(writeModel.getAthleticsClubEquipment());
        var facility = facilityRepository.getById(writeModel.getEquipmentStorage());
        var producer = producerRepository.getById(writeModel.getEquipmentProducer());
        equipmentRepository.save(EquipmentWriteModel.toEntity(writeModel, club, facility, producer));
    }

    void deleteEquipment(final String idClub) {
        log.info("Delete entry in DB!");
        var equipmentToDelete = equipmentRepository.getById(Integer.valueOf(idClub));
        equipmentToDelete.setEquipmentProducer(null);
        equipmentToDelete.setAthleticsClubEquipment(null);
        equipmentToDelete.setEquipmentStorage(null);
        var savedEquipment = equipmentRepository.save(equipmentToDelete);
        equipmentRepository.deleteById(savedEquipment.getSportEquipmentNumber());
    }

    EquipmentWriteModel editEquipment(final String idEquipment) {
        log.info("Edit entry in DB!");
        var editEntry = equipmentRepository.getById(Integer.valueOf(idEquipment));
        return new EquipmentWriteModel(
                editEntry.getDateOfPurchase(),
                editEntry.getNumberOfEquipment(),
                editEntry.getValueOfEquipment(),
                editEntry.getCondition(),
                editEntry.getInUse(),
                editEntry.getAthleticsClubEquipment().getClubNumber(),
                editEntry.getEquipmentStorage().getFacilityNumber(),
                editEntry.getEquipmentProducer().getProducerNumber(),
                editEntry.getSportEquipmentNumber()
        );
    }

    public void modifyEquipment(final EquipmentWriteModel writeModel) {
        log.info("Saving entry in DB!");
        var equipmentToModify = equipmentRepository.getById(writeModel.getNumber());
        equipmentToModify.setEquipmentStorage(null);
        equipmentToModify.setEquipmentProducer(null);
        equipmentToModify.setAthleticsClubEquipment(null);
        var savedEquipment = equipmentRepository.save(equipmentToModify);
        equipmentRepository.deleteById(savedEquipment.getSportEquipmentNumber());
        saveEquipment(writeModel);
    }
}
