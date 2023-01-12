package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SportLicenseReadModel {

    Integer number;
    LocalDate expirationDate;
    LocalDate releaseDate;
    String permission;
    String ageCategory;

    public static SportLicenseReadModel toReadModel(final SportLicense entity) {
        return new SportLicenseReadModel(
                entity.getSportLicenseNumber(),
                entity.getExpirationDate(),
                entity.getReleaseDate(),
                entity.getPermission(),
                entity.getAgeCategory()
        );
    }

    @Override
    public String toString() {
        return permission + ", " + expirationDate;
    }
}
