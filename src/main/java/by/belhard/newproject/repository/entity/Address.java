package by.belhard.newproject.repository.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String street;
    private Integer numberOfBuilding;

    public Address() {
    }

    public Address(String city, String street, Integer numberOfBuilding) {
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
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numberOfBuilding=" + numberOfBuilding +
                '}';
    }
}
