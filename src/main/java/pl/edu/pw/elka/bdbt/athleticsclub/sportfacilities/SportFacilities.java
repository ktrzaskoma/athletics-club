package pl.edu.pw.elka.bdbt.athleticsclub.sportfacilities;

import pl.edu.pw.elka.bdbt.athleticsclub.addresses.Addresses;
import pl.edu.pw.elka.bdbt.athleticsclub.athleticsclub.AthleticsClub;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "OBIEKTY_SPORTOWE")
public class SportFacilities {
    @Id
    @NotNull
    @Column(name = "NR_OBIEKTU")
    private Integer facilityNumber;

    @NotNull
    @Column(name = "NAZWA_OBIEKTU")
    private String facilityName;

    @NotNull
    @Column(name = "DATA_ODDANIA_DO_UZYTKU")
    private Date openDate;

    @NotNull
    @Column(name = "TYP_OBIEKTU")
    private String facilityType;

    @NotNull
    @Column(name = "ZAKRYTY_OBIEKT")
    private Boolean coveredFacility = false;

    @NotNull
    @Column(name = "POJEMNOSC_TRYBUN", nullable = false)
    private Integer capacityOfStands;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NR_KLUBU", nullable = false)
    private AthleticsClub clubNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NR_ADRESU", nullable = false)
    private Addresses sportFacilityAddressNumber;

    public Integer getFacilityNumber() {
        return facilityNumber;
    }

    public void setFacilityNumber(Integer facilityNumber) {
        this.facilityNumber = facilityNumber;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public Boolean getCoveredFacility() {
        return coveredFacility;
    }

    public void setCoveredFacility(Boolean coveredFacility) {
        this.coveredFacility = coveredFacility;
    }

    public Integer getCapacityOfStands() {
        return capacityOfStands;
    }

    public void setCapacityOfStands(Integer capacityOfStands) {
        this.capacityOfStands = capacityOfStands;
    }

    public AthleticsClub getClubNumber() {
        return clubNumber;
    }

    public void setClubNumber(AthleticsClub clubNumber) {
        this.clubNumber = clubNumber;
    }

    public Addresses getSportFacilityAddressNumber() {
        return sportFacilityAddressNumber;
    }

    public void setSportFacilityAddressNumber(Addresses addressNumber) {
        this.sportFacilityAddressNumber = addressNumber;
    }

}