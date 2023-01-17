package pl.edu.pw.elka.bdbt.athleticsclub.mvc.owner;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressReadModel;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.AddressRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final AddressRepository addressRepository;

    List<OwnerReadModel> getOwners() {
        log.info("Finding all entries in DB!");
        return ownerRepository.findAll()
                .stream()
                .map(OwnerReadModel::toReadModel)
                .toList();
    }

    Map<Integer, String> getAddresses() {
        log.info("Finding all entries in DB!");
        return addressRepository.findAll()
                .stream()
                .map(AddressReadModel::toReadModel)
                .collect(Collectors.toMap(AddressReadModel::getNumber, AddressReadModel::toString));
    }

    void modyfiOwner(final OwnerWriteModel writeModel) {
        log.info("Saving entry in DB!");
        var addressToSave = addressRepository.getById(writeModel.getAddressNumber());
        deleteOwner(writeModel.getNumber().toString());
        ownerRepository.save(OwnerWriteModel.toEntity(writeModel, addressToSave));
    }

    void saveOwner(final OwnerWriteModel writeModel) {
        log.info("Saving entry in DB!");
        var addressToSave = addressRepository.getById(writeModel.getAddressNumber());
        ownerRepository.save(OwnerWriteModel.toEntity(writeModel, addressToSave));
    }

    void deleteOwner(final String idOwner) {
        log.info("Delete entry in DB!");
        var ownerToDelete = ownerRepository.getById(Integer.valueOf(idOwner));
        ownerToDelete.setOwnerAddressNumber(null);
        var savedOwner = ownerRepository.save(ownerToDelete);
        ownerRepository.deleteById(savedOwner.getOwnerNumber());
    }

    OwnerWriteModel editOwner(final String idOwner) {
        log.info("Edit entry in DB!");
        var editEntry = ownerRepository.getById(Integer.valueOf(idOwner));
        return new OwnerWriteModel(
                editEntry.getOwnerName(),
                editEntry.getOwnerSurname(),
                editEntry.getOwnerDateOfBirth(),
                editEntry.getOwnerPESEL(),
                editEntry.getSex(),
                editEntry.getBankAccountNumber(),
                editEntry.getEmail(),
                editEntry.getOwnerPhoneNumber(),
                editEntry.getOwnerAddressNumber().getAddressNumber(),
                editEntry.getOwnerNumber()
        );
    }
}
