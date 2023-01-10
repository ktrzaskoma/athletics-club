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
    //format + date wydania można uznać, że to jest moment tworzenia wpisu
    Date releaseDate;
    String permission;
    String ageCategory;

    public static SportLicense toEntity(final SportLicenseWriteModel writeModel){
        var entity = new SportLicense();
        entity.setAgeCategory(writeModel.getAgeCategory());
        entity.setExpirationDate(writeModel.getExpirationDate());
        entity.setPermission(writeModel.getPermission());
        //LocalDateTime.now()
        entity.setReleaseDate(writeModel.getReleaseDate());
        return entity;

    }
}
