package pl.edu.pw.elka.bdbt.athleticsclub.mvc.producer;

import pl.edu.pw.elka.bdbt.athleticsclub.mvc.equipment.Equipment;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Producenci_sprzetu")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nr_producenta")
    private Integer producerNumber;

    @Basic(optional = false)
    @Column(name = "marka")
    private String brand;

    @Basic(optional = false)
    @Column(name = "model")
    private String model;

    @Basic(optional = false)
    @Column(name = "rok_produkcji")
    private LocalDate productionYear;

    @Column(name = "przeznaczenie_dyscyplinowe")
    private String destiny;

    @OneToMany(mappedBy = "producer")
    private Set<Equipment> equipment;

    public Set<Equipment> getSportEquipment() {
        return equipment;
    }

    public void setSportEquipment(Set<Equipment> equipment) {
        this.equipment = equipment;
    }

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
}