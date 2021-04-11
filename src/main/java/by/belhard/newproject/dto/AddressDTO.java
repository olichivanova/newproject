package by.belhard.newproject.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AddressDTO {
    @NotNull(message = "is required")
    @Size(min=2, max=30)
        private String city;
    @NotNull(message = "is required")
    @Size(min=2, max=30)
        private String street;
    @NotNull(message = "is required")
    @Pattern(regexp = "")
        private Integer numberOfBuilding;

    public AddressDTO() {
    }

    public AddressDTO(String city, String street, Integer numberOfBuilding) {
        this.city = city;
        this.street = street;
        this.numberOfBuilding = numberOfBuilding;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumberOfBuilding() {
        return numberOfBuilding;
    }

    public void setNumberOfBuilding(Integer numberOfBuilding) {
        this.numberOfBuilding = numberOfBuilding;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numberOfBuilding=" + numberOfBuilding +
                '}';
    }
}
