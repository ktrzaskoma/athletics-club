package pl.edu.pw.elka.bdbt.athleticsclub.mvc.sportlicense;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.worker.WorkerWriteModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SportLicenseWriteModel {

    @NotNull(message = "Pole Data ważności nie może być puste!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate expirationDate;
    @NotNull(message = "Pole Data wydania nie może być puste!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate releaseDate;
    @NotBlank(message = "Pole Uprawnienia nie może być puste!")
    String permission;
    String ageCategory;

    Set<WorkerWriteModel> worker = new HashSet<>();

    public static SportLicense toEntity(final SportLicenseWriteModel writeModel){
        var entity = new SportLicense();
        entity.setAgeCategory(writeModel.getAgeCategory());
        entity.setExpirationDate(writeModel.getExpirationDate());
        entity.setPermission(writeModel.getPermission());
        entity.setReleaseDate(writeModel.getReleaseDate());
        return entity;

    }
}
