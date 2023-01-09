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

    public static PostOffice toWriteModel(final PostOfficeWriteModel writeModel){
        var toSaveModel = new PostOffice();
        toSaveModel.setZipCode(writeModel.zipCode);
        toSaveModel.setPostOfficeCity(writeModel.postOfficeCity);
        toSaveModel.setAddressSet(Collections.emptySet());
        return toSaveModel;
    }
}
