package pl.edu.pw.elka.bdbt.athleticsclub.mvc.address;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
class AddressService {

    private final AddressRepository addressRepository;

    AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    List<AddressReadModel> getAddresses() {
        log.info("Finding all entries in DB!");
        return addressRepository.findAll()
                .stream()
                .map(AddressReadModel::toReadModel)
                .toList();
    }

    void saveAddress(final AddressWriteModel writeModel) {
        log.info("Saving entry in DB!");
        addressRepository.save(AddressWriteModel.toEntity(writeModel));
    }

    void deleteAddress(final String idAddress) {
        log.info("Delete entry in DB!");
        addressRepository.deleteById(Integer.valueOf(idAddress));
    }

    AddressWriteModel editAddress(final String idAddress) {
        log.info("Edit entry in DB!");
        var editEntry = addressRepository.getById(Integer.valueOf(idAddress));
        return new AddressWriteModel(
                editEntry.getCountry(),
                editEntry.getCity(),
                editEntry.getZipCode(),
                editEntry.getStreet(),
                editEntry.getBuildingNumber(),
                editEntry.getApartmentNumber(),
                editEntry.getAddressNumber().toString()
        );
    }

}
