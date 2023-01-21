package pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClubWriteModel;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class FacilityService {

    private final FacilityRepository facilityRepository;
    private final AthleticsClubRepository clubRepository;
    private final AddressRepository addressRepository;

    List<FacilityReadModel> getSportFacilities() {
        return facilityRepository.findAll()
                .stream().map(
                        FacilityReadModel::toReadModel
                ).toList();
    }

    Map<Integer, String> getFormattedAddresses() {
        return addressRepository.findAll().stream().map(
                AddressReadModel::toReadModel
        ).collect(Collectors.toMap(AddressReadModel::getNumber, AddressReadModel::toString));
    }

    Map<Integer, String> getFormattedClubs() {
        return clubRepository.findAll()
                .stream().map(AthleticsClubReadModel::toReadModel)
                .collect(Collectors.toMap(AthleticsClubReadModel::getNumber, AthleticsClubReadModel::toString));
    }

    void saveFacility(final FacilityWriteModel writeModel) {
        log.info("Saving entry in DB!");
        var address = addressRepository.getById(writeModel.getFacilityAddress());
        var club = clubRepository.getById(writeModel.getAthleticsClubFacility());
        facilityRepository.save(FacilityWriteModel.toEntity(writeModel, club, address));
    }

    void deleteFacility(final String idFacility) {
        log.info("Delete entry in DB!");
        var facilityToDelete = facilityRepository.getById(Integer.valueOf(idFacility));
        facilityToDelete.setFacilityAddressNumber(null);
        facilityToDelete.setAthleticsClubFacility(null);
        var savedFacility = facilityRepository.save(facilityToDelete);
        facilityRepository.deleteById(savedFacility.getFacilityNumber());
    }

    FacilityWriteModel editFacility(final String idFacility) {
        log.info("Edit entry in DB!");
        var editEntry = facilityRepository.getById(Integer.valueOf(idFacility));
        return new FacilityWriteModel(
                editEntry.getFacilityName(),
                editEntry.getOpenDate(),
                editEntry.getFacilityType(),
                editEntry.getCoveredFacility(),
                editEntry.getCapacityOfStands(),
                editEntry.getAthleticsClubFacility().getClubNumber(),
                editEntry.getFacilityAddressNumber().getAddressNumber(),
                editEntry.getFacilityNumber()
        );
    }

    void modifyFacility(final FacilityWriteModel writeModel) {
        log.info("Saving entry in DB!");
        var addressToSave = addressRepository.getById(writeModel.getFacilityAddress());
        var clubToSave = clubRepository.getById(writeModel.getAthleticsClubFacility());
        deleteFacility(writeModel.getNumber().toString());
        facilityRepository.save(FacilityWriteModel.toEntity(writeModel, clubToSave, addressToSave));
    }
}
