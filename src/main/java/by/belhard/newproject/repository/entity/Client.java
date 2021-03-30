package by.belhard.newproject.repository.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer clientID;

    @Column(name = "client_last_name")
    String LastName;

    @Column(name = "client_first_name")
    String FirstName;

    @Column
    int age;

    @Column
    String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    List<Order> orders;

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", LastName='" + LastName + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
