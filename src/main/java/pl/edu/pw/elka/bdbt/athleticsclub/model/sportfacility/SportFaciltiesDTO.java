package pl.edu.pw.elka.bdbt.athleticsclub.model.sportfacility;

public class SportFaciltiesDTO {

    int number;
    String description;

    public SportFaciltiesDTO(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public static SportFaciltiesDTO toSportFaciltiesDTO(final SportFacilities sportFacilities){
        return new SportFaciltiesDTO(sportFacilities.getFacilityNumber(), sportFacilities.getFacilityName());
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
