package pl.edu.pw.elka.bdbt.athleticsclub.model.dto;

import pl.edu.pw.elka.bdbt.athleticsclub.model.SportFacility;

public class SportFacilityDTO {

    int number;
    String description;

    public SportFacilityDTO(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public static SportFacilityDTO toSportFaciltiesDTO(final SportFacility sportFacility){
        return new SportFacilityDTO(sportFacility.getFacilityNumber(), sportFacility.getFacilityName());
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
