package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SportLicenseWriteModel {

    Date expirationDate;
    Date releaseDate;
    String permission;
    String ageCategory;

    public static SportLicense toSportLicense(final SportLicenseWriteModel sportLicenseWriteModel){
        var modelToSave = new SportLicense();
        modelToSave.setAgeCategory(sportLicenseWriteModel.ageCategory);
        modelToSave.setExpirationDate(sportLicenseWriteModel.expirationDate);
        modelToSave.setPermission(sportLicenseWriteModel.permission);
        modelToSave.setReleaseDate(sportLicenseWriteModel.releaseDate);
        return modelToSave;

    }
}
