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
public class SportLicenseReadModel {

    Date expirationDate;
    //format + date wydania można uznać, że to jest moment tworzenia wpisu
    Date releaseDate;
    String permission;
    String ageCategory;

    public static SportLicenseReadModel toReadModel(final SportLicense entity) {
        return new SportLicenseReadModel(
                entity.getExpirationDate(),
                entity.getReleaseDate(),
                entity.getPermission(),
                entity.getAgeCategory()
        );
    }
}
