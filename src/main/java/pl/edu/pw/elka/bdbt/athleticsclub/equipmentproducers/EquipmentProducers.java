package pl.edu.pw.elka.bdbt.athleticsclub.equipmentproducers;

import pl.edu.pw.elka.bdbt.athleticsclub.sportequipment.SportEquipment;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "PRODUCENCI_SPRZETU")
public class EquipmentProducers {
    @Id
    @Column(name = "NR_PRODUCENTA")
    private Integer producerNumber;

    @NotNull
    @Column(name = "MARKA")
    private String brand;

    @NotNull
    @Column(name = "MODEL")
    private String model;

    @NotNull
    @Column(name = "ROK_PRODUKCJI")
    private LocalDate productionYear;

    @Column(name = "PRZEZNACZENIE_DYSCYPLINOWE")
    private String destiny;

    @OneToMany(mappedBy = "producerNumber")
    private Set<SportEquipment> sportEquipment;

    public Integer getProducerNumber() {
        return producerNumber;
    }

    public void setProducerNumber(Integer producerNumber) {
        this.producerNumber = producerNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(LocalDate productionYear) {
        this.productionYear = productionYear;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public Set<SportEquipment> getSportEquipment() {
        return sportEquipment;
    }

    public void setSportEquipment(Set<SportEquipment> sportEquipment) {
        this.sportEquipment = sportEquipment;
    }

}