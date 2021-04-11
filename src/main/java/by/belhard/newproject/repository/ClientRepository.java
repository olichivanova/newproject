package by.belhard.newproject.repository;

import by.belhard.newproject.dto.AddressDTO;
import by.belhard.newproject.dto.ClientDTO;
import by.belhard.newproject.repository.entity.Address;
import by.belhard.newproject.repository.entity.Client;
import by.belhard.newproject.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT c FROM Client c WHERE LOWER(c.lastName)  = lower(:lastName)  and lower(c.firstName)  = lower(:firstName)  and c.age =:age")
public Client getClientByRequest ( @Param("lastName") String lastName, @Param("firstName") String firstName,@Param("age") Integer age );
    @Query("SELECT c FROM Client c WHERE LOWER(c.lastName)  = lower(:lastName) and lower(c.firstName)  = lower(:firstName) and c.age =:age and lower(c.address.city) = lower(:city)   and lower(c.address.street) = lower(:street)  and c.address.numberOfBuilding = :numberOfBuilding")
    public Client getClientByParam ( @Param("lastName") String lastName, @Param("firstName") String firstName,@Param("age") Integer age, @Param("city") String city, @Param("street") String street, @Param("numberOfBuilding") Integer numberOfBuilding );
    @Query("SELECT c FROM Client c LEFT JOIN FETCH c.orders  WHERE LOWER(c.lastName)  = lower(:lastName) and lower(c.firstName)  = lower(:firstName) and c.age =:age and lower(c.address.city) = lower(:city)   and lower(c.address.street) = lower(:street)  and c.address.numberOfBuilding = :numberOfBuilding")
    public Client getClientByParamWithOrder ( @Param("lastName") String lastName, @Param("firstName") String firstName,@Param("age") Integer age, @Param("city") String city, @Param("street") String street, @Param("numberOfBuilding") Integer numberOfBuilding );

}
