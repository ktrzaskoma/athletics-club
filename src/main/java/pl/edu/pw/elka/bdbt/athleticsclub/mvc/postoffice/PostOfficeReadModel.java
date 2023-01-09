package pl.edu.pw.elka.bdbt.athleticsclub.mvc.postoffice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostOfficeReadModel {

    String zipCode;
    String postOfficeCity;
    String addressSet;

    public static PostOfficeReadModel toReadModel(final PostOffice postOffice) {
        return new PostOfficeReadModel(
                postOffice.getZipCode(),
                postOffice.getPostOfficeCity(),
                postOffice.getAddressSet().stream().map(Address::getAddressNumber).toList().toString()
        );
    }
}
