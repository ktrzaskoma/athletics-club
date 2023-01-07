package pl.edu.pw.elka.bdbt.athleticsclub.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Obiekty_sportowe")
public class SportFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nr_obiektu")
    private Integer facilityNumber;

    @Basic(optional = false)
    @Column(name = "nazwa_obiektu")
    private String facilityName;

    @Basic(optional = false)
    @Column(name = "data_oddania_do_uzytku")
    private Date openDate;

    @Basic(optional = false)
    @Column(name = "typ_obiektu")
    private String facilityType;

    @Basic(optional = false)
    @Column(name = "zakryty_obiekt")
    private Boolean coveredFacility;

    @Basic(optional = false)
    @Column(name = "pojemnosc_trybun")
    private int capacityOfStands;


    @ManyToOne
    @JoinColumn(name = "nr_klubu")
    private AthleticsClub athleticsClubFacility;

    @OneToOne
    @JoinColumn(name = "nr_adresu")
    private Address facilityAddressNumber;

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