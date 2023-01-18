package pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipment;

import pl.edu.pw.elka.bdbt.athleticsclub.mvc.athleticsclub.AthleticsClub;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.producer.Producer;
import pl.edu.pw.elka.bdbt.athleticsclub.mvc.facility.Facility;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Sprzet_sportowy")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nr_sprzetu")
    private Integer sportEquipmentNumber;

    @Basic(optional = false)
    @Column(name = "data_zakupu")
    private LocalDate dateOfPurchase;

    @Basic(optional = false)
    @Column(name = "liczba_sprzetu")
    private Integer numberOfEquipment;

    @Basic(optional = false)
    @Column(name = "wartosc_sprzetu", precision = 10, scale = 2)
    private BigDecimal valueOfEquipment;

    @Basic(optional = false)
    @Column(name = "stan")
    private String condition;

    @Basic(optional = false)
    @Column(name = "w_uzyciu")
    private Boolean inUse;

    @ManyToOne
    @JoinColumn(name = "nr_klubu")
    private AthleticsClub athleticsClubEquipment;

    @ManyToOne
    @JoinColumn(name = "nr_obiektu")
    private Facility equipmentStorage;

    @ManyToOne
    @JoinColumn(name = "nr_producenta")
    private Producer producer;


    public AthleticsClub getAthleticsClubEquipment() {
        return athleticsClubEquipment;
    }

    public void setAthleticsClubEquipment(AthleticsClub athleticsClubEquipment) {
        this.athleticsClubEquipment = athleticsClubEquipment;
    }

    public Facility getEquipmentStorage() {
        return equipmentStorage;
    }

    public void setEquipmentStorage(Facility equipmentStorage) {
        this.equipmentStorage = equipmentStorage;
    }

    public Producer getEquipmentProducer() {
        return producer;
    }

    public void setEquipmentProducer(Producer producer) {
        this.producer = producer;
    }

    public Integer getSportEquipmentNumber() {
        return sportEquipmentNumber;
    }

    public void setSportEquipmentNumber(Integer sportEquipmentNumber) {
        this.sportEquipmentNumber = sportEquipmentNumber;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
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