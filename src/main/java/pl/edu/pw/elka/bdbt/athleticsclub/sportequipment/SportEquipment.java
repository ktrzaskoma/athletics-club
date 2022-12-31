package pl.edu.pw.elka.bdbt.athleticsclub.sportequipment;

import pl.edu.pw.elka.bdbt.athleticsclub.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.equipmentproducers.EquipmentProducers;
import pl.edu.pw.elka.bdbt.athleticsclub.sportfacilities.SportFacilities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Sprzet_sportowy")
public class SportEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Nr_sprzetu")
    private Integer sportEquipmentNumber;

    @NotNull
    @Column(name = "Data_zakupu")
    private Date dateOfPurchase;

    @NotNull
    @Column(name = "Liczba_sprzetu")
    private Integer numberOfEquipment;

    @NotNull
    @Column(name = "Wartosc_sprzetu", precision = 10, scale = 2)
    private BigDecimal valueOfEquipment;

    @NotNull
    @Column(name = "Stan")
    private String condition;

    @NotNull
    @Column(name = "W_uzyciu")
    private Boolean inUse;

    @ManyToOne
    @JoinColumn(name = "Nr_klubu")
    private AthleticsClub athleticsClubEquipment;

    @ManyToOne
    @JoinColumn(name = "Nr_obiektu")
    private SportFacilities equipmentStorage;

    @ManyToOne
    @JoinColumn(name = "Nr_producenta")
    private EquipmentProducers equipmentProducer;


    public AthleticsClub getAthleticsClubEquipment() {
        return athleticsClubEquipment;
    }

    public void setAthleticsClubEquipment(AthleticsClub athleticsClubEquipment) {
        this.athleticsClubEquipment = athleticsClubEquipment;
    }

    public SportFacilities getEquipmentStorage() {
        return equipmentStorage;
    }

    public void setEquipmentStorage(SportFacilities equipmentStorage) {
        this.equipmentStorage = equipmentStorage;
    }

    public EquipmentProducers getEquipmentProducer() {
        return equipmentProducer;
    }

    public void setEquipmentProducer(EquipmentProducers equipmentProducer) {
        this.equipmentProducer = equipmentProducer;
    }

    public Integer getSportEquipmentNumber() {
        return sportEquipmentNumber;
    }

    public void setSportEquipmentNumber(Integer sportEquipmentNumber) {
        this.sportEquipmentNumber = sportEquipmentNumber;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Integer getNumberOfEquipment() {
        return numberOfEquipment;
    }

    public void setNumberOfEquipment(Integer numberOfEquipment) {
        this.numberOfEquipment = numberOfEquipment;
    }

    public BigDecimal getValueOfEquipment() {
        return valueOfEquipment;
    }

    public void setValueOfEquipment(BigDecimal valueOfEquipment) {
        this.valueOfEquipment = valueOfEquipment;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Boolean getInUse() {
        return inUse;
    }

    public void setInUse(Boolean inUse) {
        this.inUse = inUse;
    }
}