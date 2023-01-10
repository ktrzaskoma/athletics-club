package pl.edu.pw.elka.bdbt.athleticsclub.mvc.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressWriteModel {

    @NotBlank(message = "Bla bla bla")
    String country;
    String city;
    String street;
    String buildingNumber;
    String apartmentNumber;

    public static Address toEntity(final AddressWriteModel writeModel) {
        var entity = new Address();
        entity.setCountry(writeModel.getCountry());
        entity.setCity(writeModel.getCity());
        entity.setStreet(writeModel.getStreet());
        entity.setBuildingNumber(writeModel.getBuildingNumber());
        entity.setApartmentNumber(writeModel.getApartmentNumber());
        return entity;
    }
}
