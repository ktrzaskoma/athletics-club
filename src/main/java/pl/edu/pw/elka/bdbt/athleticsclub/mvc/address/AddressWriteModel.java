package pl.edu.pw.elka.bdbt.athleticsclub.mvc.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class AddressWriteModel {

    @NotBlank(message = "Pole Kraj nie może być puste!")
    String country;
    @NotBlank(message = "Pole Miasto nie może być puste!")
    String city;
    @NotBlank(message = "Pole Kod pocztowy nie może być puste!")
    @Size(max = 6, min = 6, message = "Podaj poprawny kod pocztowy!")
    @Pattern(regexp = "^d{2}-d{3}$", message = "Podaj kod pocztowy w poprawnym formacie!")
    String zipCode;
    @NotBlank(message = "Pole Ulica nie może być puste!")
    String street;
    @NotBlank(message = "Pole Numer budynku nie może być puste!")
    String buildingNumber;
    String apartmentNumber;
    String addressNumber;

    static Address toEntity(final AddressWriteModel writeModel) {
        var entity = new Address();
        entity.setCountry(writeModel.getCountry());
        entity.setCity(writeModel.getCity());
        entity.setZipCode(writeModel.getZipCode());
        entity.setStreet(writeModel.getStreet());
        entity.setBuildingNumber(writeModel.getBuildingNumber());
        entity.setApartmentNumber(writeModel.getApartmentNumber());
        if (Objects.nonNull(writeModel.getAddressNumber())) {
            entity.setAddressNumber(Integer.valueOf(writeModel.getAddressNumber()));
        }
        return entity;
    }
}
