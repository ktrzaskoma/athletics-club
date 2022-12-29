package pl.edu.pw.elka.bdbt.athleticsclub.sportequipment;

import pl.edu.pw.elka.bdbt.athleticsclub.equipmentproducers.EquipmentProducers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "SPRZET_SPORTOWY")
public class SportEquipment {
    @Id
    @NotNull
    @Column(name = "NR_SPRZETU")
    private Integer sportEquipmentNumber;

    @NotNull
    @Column(name = "DATA_ZAKUPU")
    private Date dateOfPurchase;

    @NotNull
    @Column(name = "LICZBA_SPRZETU")
    private Integer numberOfEquipment;

    @NotNull
    @Column(name = "WARTOSC_SPRZETU", precision = 10, scale = 2)
    private BigDecimal valueOfEquipment;

    @NotNull
    @Column(name = "STAN")
    private String condition;

    @NotNull
    @Column(name = "W_UZYCIU")
    private Boolean inUse;

/*
there are annotations that I don't know what to do
 */
    @NotNull
    @Column(name = "NR_KLUBU", nullable = false)
    private Long nrKlubu;

    @Column(name = "NR_OBIEKTU")
    private Long nrObiektu;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NR_PRODUCENTA", nullable = false)
    private EquipmentProducers producerNumber;

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

    public void setInUse(Boolean wUzyciu) {
        this.inUse = wUzyciu;
    }

    public Long getNrKlubu() {
        return nrKlubu;
    }

    public void setNrKlubu(Long nrKlubu) {
        this.nrKlubu = nrKlubu;
    }

    public Long getNrObiektu() {
        return nrObiektu;
    }

    public void setNrObiektu(Long nrObiektu) {
        this.nrObiektu = nrObiektu;
    }

    public EquipmentProducers getProducerNumber() {
        return producerNumber;
    }

    public void setProducerNumber(EquipmentProducers producerNumber) {
        this.producerNumber = producerNumber;
    }

}