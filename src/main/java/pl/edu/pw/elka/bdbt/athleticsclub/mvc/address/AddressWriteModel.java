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

    @NotBlank(message = "Pole Kraj nie może być puste!")
    String country;
    @NotBlank(message = "Pole Miasto nie może być puste!")
    String city;
    @NotBlank(message = "Pole Kod pocztowy nie może być puste!")
    String zipCode;
    @NotBlank(message = "Pole Ulica nie może być puste!")
    String street;
    @NotBlank(message = "Pole Numer budynku nie może być puste!")
    String buildingNumber;
    String apartmentNumber;

    public static Address toEntity(final AddressWriteModel writeModel) {
        var entity = new Address();
        entity.setCountry(writeModel.getCountry());
        entity.setCity(writeModel.getCity());
        entity.setZipCode(writeModel.getZipCode());
        entity.setStreet(writeModel.getStreet());
        entity.setBuildingNumber(writeModel.getBuildingNumber());
        entity.setApartmentNumber(writeModel.getApartmentNumber());
        return entity;
    }
}
