package pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility;

import pl.edu.pw.elka.bdbt.athleticsclub.mvc.address.Address;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipment.Equipment;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Obiekty_sportowe")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nr_obiektu")
    private Integer facilityNumber;

    @Basic(optional = false)
    @Column(name = "nazwa_obiektu")
    private String facilityName;

    @Basic(optional = false)
    @Column(name = "data_oddania_do_uzytku")
    private LocalDate openDate;

    @Basic(optional = false)
    @Column(name = "typ_obiektu")
    private String facilityType;

    @Basic(optional = false)
    @Column(name = "zakryty_obiekt")
    private Boolean coveredFacility;

    @Basic(optional = false)
    @Column(name = "pojemnosc_trybun")
    private String capacityOfStands;

    @ManyToOne
    @JoinColumn(name = "nr_klubu")
    private AthleticsClub athleticsClubFacility;

    @ManyToOne
    @JoinColumn(name = "nr_adresu")
    private Address facilityAddressNumber;

    @OneToMany(mappedBy = "equipmentStorage")
    private Set<Equipment> equipment;

    private Set<Equipment> getSportEquipment() {
        return equipment;
    }

    private void setSportEquipment(Set<Equipment> equipment) {
        this.equipment = equipment;
    }

    public AthleticsClub getAthleticsClubFacility() {
        return athleticsClubFacility;
    }

    public void setAthleticsClubFacility(AthleticsClub athleticsClubFacility) {
        this.athleticsClubFacility = athleticsClubFacility;
    }

    public Address getFacilityAddressNumber() {
        return facilityAddressNumber;
    }

    public void setFacilityAddressNumber(Address facilityAddressNumber) {
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

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
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

    public String getCapacityOfStands() {
        return capacityOfStands;
    }

    public void setCapacityOfStands(String capacityOfStands) {
        this.capacityOfStands = capacityOfStands;
    }
}