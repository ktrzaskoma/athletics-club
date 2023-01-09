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
    Date releaseDate;
    String permission;
    String ageCategory;

    public static SportLicenseReadModel toReadModel(final SportLicense sportLicense) {
        return new SportLicenseReadModel(
                sportLicense.getExpirationDate(),
                sportLicense.getReleaseDate(),
                sportLicense.getPermission(),
                sportLicense.getAgeCategory()
        );
    }
}
