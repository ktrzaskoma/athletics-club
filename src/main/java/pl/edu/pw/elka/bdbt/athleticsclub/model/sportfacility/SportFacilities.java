package pl.edu.pw.elka.bdbt.athleticsclub.model.sportfacility;

import pl.edu.pw.elka.bdbt.athleticsclub.model.address.Addresses;
import pl.edu.pw.elka.bdbt.athleticsclub.model.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.model.sportequipment.SportEquipment;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Obiekty_sportowe")
public class SportFacilities {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Nr_obiektu")
    private Integer facilityNumber;

    @NotNull
    @Column(name = "Nazwa_obiektu")
    private String facilityName;

    @NotNull
    @Column(name = "Data_oddania_do_uzytku")
    private Date openDate;

    @NotNull
    @Column(name = "Typ_obiektu")
    private String facilityType;

    @NotNull
    @Column(name = "Zakryty_obiekt")
    private Boolean coveredFacility;

    @NotNull
    @Column(name = "Pojemnosc_trybun")
    private int capacityOfStands;


    @ManyToOne
    @JoinColumn(name = "Nr_klubu")
    private AthleticsClub athleticsClubFacility;

    @OneToOne
    @JoinColumn(name = "Nr_adresu")
    private Addresses facilityAddressNumber;

    @OneToMany(mappedBy = "equipmentStorage")
    private Set<SportEquipment> sportEquipment;

    private Set<SportEquipment> getSportEquipment() {
        return sportEquipment;
    }

    private void setSportEquipment(Set<SportEquipment> sportEquipment) {
        this.sportEquipment = sportEquipment;
    }

    public AthleticsClub getAthleticsClubFacility() {
        return athleticsClubFacility;
    }

    public void setAthleticsClubFacility(AthleticsClub athleticsClubFacility) {
        this.athleticsClubFacility = athleticsClubFacility;
    }

    public Addresses getFacilityAddressNumber() {
        return facilityAddressNumber;
    }

    public void setFacilityAddressNumber(Addresses facilityAddressNumber) {
        this.facilityAddressNumber = facilityAddressNumber;
    }

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

    public int getCapacityOfStands() {
        return capacityOfStands;
    }

    public void setCapacityOfStands(int capacityOfStands) {
        this.capacityOfStands = capacityOfStands;
    }
}