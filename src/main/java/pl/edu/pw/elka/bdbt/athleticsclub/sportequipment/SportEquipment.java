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


}