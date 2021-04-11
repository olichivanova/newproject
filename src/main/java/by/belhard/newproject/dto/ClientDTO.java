package by.belhard.newproject.dto;

import by.belhard.newproject.repository.entity.Address;
import by.belhard.newproject.repository.entity.Order;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Objects;

public class ClientDTO {

    private Integer clientID;
    @NotNull(message = "is required")
    @Size(min=2, max=30)
    private String lastName;
    @NotNull(message = "is required")
    @Size(min=2, max=30)
    private String firstName;
    @NotNull(message = "is required")
    @Min(18)
    //@NegativeOrZero(message = "can't be negative or zero")
    //@Pattern(regexp = "[0-9]", message = "only numbers and ")
    private int age;
    private AddressDTO address;
    private List<OrderDTO> orders;

    public ClientDTO() {
    }


    public ClientDTO(String lastName, String firstName, int age, AddressDTO address) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.address = address;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return age == clientDTO.age && Objects.equals(clientID, clientDTO.clientID) && Objects.equals(lastName, clientDTO.lastName) && Objects.equals(firstName, clientDTO.firstName) && Objects.equals(address, clientDTO.address) && Objects.equals(orders, clientDTO.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientID, lastName, firstName, age, address, orders);
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "clientID=" + clientID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", orders=" + orders +
                '}';
    }
}
