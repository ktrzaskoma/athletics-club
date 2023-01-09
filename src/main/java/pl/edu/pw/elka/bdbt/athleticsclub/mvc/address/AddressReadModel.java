package pl.edu.pw.elka.bdbt.athleticsclub.mvc.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressReadModel {

    String country;
    String city;
    String street;
    String buildingNumber;
    String apartmentNumber;

    public static AddressReadModel toReadModel(final Address address) {
        return new AddressReadModel(
                address.getCountry(),
                address.getCity(),
                address.getStreet(),
                address.getBuildingNumber(),
                address.getApartmentNumber()
        );
    }

}
