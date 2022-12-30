package pl.edu.pw.elka.bdbt.athleticsclub.equipmentproducers;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Producenci_sprzetu")
public class EquipmentProducers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Nr_producenta")
    private Integer producerNumber;

    @NotNull
    @Column(name = "Marka")
    private String brand;

    @NotNull
    @Column(name = "Model")
    private String model;

    @NotNull
    @Column(name = "Rok_proEquidukcji")
    private Date productionYear;

    @Column(name = "Przeznaczenie_dyscyplinowe")
    private String destiny;

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

    public Date getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Date productionYear) {
        this.productionYear = productionYear;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }
}