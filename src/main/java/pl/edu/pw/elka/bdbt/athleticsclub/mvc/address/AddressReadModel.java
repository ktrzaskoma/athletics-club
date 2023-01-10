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

    Integer number;
    String country;
    String city;
    String street;
    String buildingNumber;
    String apartmentNumber;

    public static AddressReadModel toReadModel(final Address entity) {
        return new AddressReadModel(
                entity.getAddressNumber(),
                entity.getCountry(),
                entity.getCity(),
                entity.getStreet(),
                entity.getBuildingNumber(),
                entity.getApartmentNumber()
        );
    }

    @Override
    public String toString() {
        return country + ", " + city + ", " + street + ", " + buildingNumber + ", " + apartmentNumber;
    }
}
