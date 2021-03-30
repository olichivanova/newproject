package by.belhard.newproject.repository;

import by.belhard.newproject.repository.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
