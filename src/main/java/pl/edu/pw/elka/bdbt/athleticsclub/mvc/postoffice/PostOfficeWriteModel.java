package pl.edu.pw.elka.bdbt.athleticsclub.mvc.postoffice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostOfficeWriteModel {

    String zipCode;
    String postOfficeCity;
    String addressSet;

    public static PostOffice toEntity(final PostOfficeWriteModel writeModel){
        var entity = new PostOffice();
        entity.setZipCode(writeModel.getZipCode());
        entity.setPostOfficeCity(writeModel.getPostOfficeCity());
        //tu trzeba podać zbiór tych adresów, chociaż dla mnie to trochę nielogiczne
        entity.setAddressSet(Collections.emptySet());
        return entity;
    }
}
