package pl.edu.pw.elka.bdbt.athleticsclub.mvc.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressWriteModel {

    String country;
    String city;
    String street;
    String buildingNumber;
    String apartmentNumber;

    public static Address toAddress(final AddressWriteModel addressWriteModel) {
        var addressToSave = new Address();
        addressToSave.setCountry(addressWriteModel.country);
        addressToSave.setCity(addressWriteModel.city);
        addressToSave.setStreet(addressWriteModel.street);
        addressToSave.setBuildingNumber(addressWriteModel.buildingNumber);
        addressToSave.setApartmentNumber(addressWriteModel.apartmentNumber);
        return addressToSave;
    }
}
