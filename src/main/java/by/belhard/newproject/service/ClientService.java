package by.belhard.newproject.service;


import by.belhard.newproject.dto.ClientDTO;


import java.sql.Date;

public interface ClientService {
    public ClientDTO check(String lastName,  String firstName, Integer age);
    public void save (ClientDTO clientDTO);
    public ClientDTO getByParam (String lastName,  String firstName, Integer age, String city, String street, Integer numberOfBuilding);
   public void save (Date date, ClientDTO clientDTO);
   ClientDTO getClientByParamWithOrder(String lastName, String firstName, Integer age, String city, String street, Integer numberOfBuilding);
}
