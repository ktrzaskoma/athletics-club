package pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressRepository;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner.OwnerReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner.OwnerRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class AthleticsClubService {

    private final AthleticsClubRepository athleticsClubRepository;
    private final AddressRepository addressRepository;
    private final OwnerRepository ownerRepository;

    List<AthleticsClubReadModel> getClubs() {
        log.info("Finding all entries in DB!");
        return athleticsClubRepository.findAll()
                .stream()
                .map(AthleticsClubReadModel::toReadModel)
                .toList();
    }

    void saveClub(final AthleticsClubWriteModel writeModel) {
        log.info("Saving entry in DB!");
        var address = addressRepository.getById(writeModel.getAddressNumber());
        var owner = ownerRepository.getById(writeModel.getOwnerOfAthleticsClub());
        athleticsClubRepository.save(AthleticsClubWriteModel
                .toEntity(writeModel, address, owner));
    }

    Map<Integer, String> getFormattedAddresses() {
        return addressRepository.findAll().stream().map(
                AddressReadModel::toReadModel
        ).collect(Collectors.toMap(AddressReadModel::getNumber, AddressReadModel::toString));
    }

    Map<Integer, String> getFormattedOwners() {
        return ownerRepository.findAll().stream().map(
                OwnerReadModel::toReadModel
        ).collect(Collectors.toMap(OwnerReadModel::getNumber, OwnerReadModel::toString));
    }

    void deleteClub(final String idClub) {
        log.info("Delete entry in DB!");
        var clubToDelete = athleticsClubRepository.getById(Integer.valueOf(idClub));
        clubToDelete.setClubAddressNumber(null);
        clubToDelete.setOwnerOfAthleticsClub(null);
        var savedClub = athleticsClubRepository.save(clubToDelete);
        athleticsClubRepository.deleteById(savedClub.getClubNumber());
    }

    AthleticsClubWriteModel editClub(final String idClub) {
        log.info("Edit entry in DB!");
        var editEntry = athleticsClubRepository.getById(Integer.valueOf(idClub));
        return new AthleticsClubWriteModel(
                editEntry.getClubName(),
                editEntry.getEstablishedDate(),
                editEntry.getClubPhoneNumber(),
                editEntry.getClubEmail(),
                editEntry.getClubPhoneNumber2(),
                editEntry.getClubWebPage(),
                editEntry.getClubAddressNumber().getAddressNumber(),
                editEntry.getOwnerOfAthleticsClub().getOwnerNumber(),
                editEntry.getClubNumber()
        );
    }

    void modifyClub(final AthleticsClubWriteModel writeModel) {
        log.info("Saving entry in DB!");
        var addressToSave = addressRepository.getById(writeModel.getAddressNumber());
        var ownerToSave = ownerRepository.getById(writeModel.getOwnerOfAthleticsClub());
        deleteClub(writeModel.getNumber().toString());
        athleticsClubRepository.save(AthleticsClubWriteModel.toEntity(writeModel, addressToSave, ownerToSave));
    }
}

