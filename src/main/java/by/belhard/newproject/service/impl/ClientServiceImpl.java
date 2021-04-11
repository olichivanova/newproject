package by.belhard.newproject.service.impl;

import by.belhard.newproject.dto.AddressDTO;
import by.belhard.newproject.dto.ClientDTO;
import by.belhard.newproject.dto.OrderDTO;
import by.belhard.newproject.repository.ClientRepository;
import by.belhard.newproject.repository.entity.Address;
import by.belhard.newproject.repository.entity.Client;
import by.belhard.newproject.repository.entity.Order;
import by.belhard.newproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
@Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO check( String lastName,  String firstName, Integer age) {
        ClientDTO clientDTO = convertFromEntityToDTO(clientRepository.getClientByRequest(lastName,firstName ,age));
        return clientDTO;
    }

    @Override
    public void save(ClientDTO clientDTO) {
    Client client = convertFromDTOToEntity(clientDTO);
        clientRepository.save(client);
    }

    @Override
    public ClientDTO getByParam(String lastName, String firstName, Integer age, String city, String street, Integer numberOfBuilding) {
        ClientDTO clientDTO = convertFromEntityToDTO(clientRepository.getClientByParam(lastName, firstName, age, city,street , numberOfBuilding));

        return clientDTO;
    }



    @Override
    public void save(Date date, ClientDTO clientDTO) {
        clientRepository.save(convertFromDTOToEntityWithOrder(date,clientDTO));
    }

    @Override
    public ClientDTO getClientByParamWithOrder(String lastName, String firstName, Integer age, String city, String street, Integer numberOfBuilding) {
        return convertFromEntityToDTWithOrder(clientRepository.getClientByParamWithOrder(lastName, firstName, age, city,street , numberOfBuilding));
    }


    private Client convertFromDTOToEntity (ClientDTO clientDTO) {
        Client client = new Client();
        if (clientDTO.getClientID() != null) {
            client.setClientID(clientDTO.getClientID());
        }
        client.setLastName(clientDTO.getLastName());
        client.setFirstName(clientDTO.getFirstName());
        client.setAge(clientDTO.getAge());
        client.setAddress(new Address(clientDTO.getAddress().getCity(), clientDTO.getAddress().getStreet(), clientDTO.getAddress().getNumberOfBuilding()));
    return client; }

    private Client convertFromDTOToEntityWithOrder (Date date, ClientDTO clientDTO) {
        Client client = new Client();
        if (clientDTO.getClientID() != null) {
            client.setClientID(clientDTO.getClientID());
        }
        client.setLastName(clientDTO.getLastName());
        client.setFirstName(clientDTO.getFirstName());
        client.setAge(clientDTO.getAge());
        client.setAddress(new Address(clientDTO.getAddress().getCity(), clientDTO.getAddress().getStreet(), clientDTO.getAddress().getNumberOfBuilding()));
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setOrderDate(date);
        order.setClient(client);
        orders.add(order);
        client.setOrders(orders);
        return client; }


    private ClientDTO convertFromEntityToDTO(Client client){
    ClientDTO clientDTO = new ClientDTO();
    clientDTO.setClientID(client.getClientID());
    clientDTO.setLastName(client.getLastName());
    clientDTO.setFirstName(client.getFirstName());
    clientDTO.setAge(client.getAge());
    clientDTO.setAddress(new AddressDTO(client.getAddress().getCity(), client.getAddress().getStreet(), client.getAddress().getNumberOfBuilding()));
    return clientDTO;
    }

    private ClientDTO convertFromEntityToDTWithOrder(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientID(client.getClientID());
        clientDTO.setLastName(client.getLastName());
        clientDTO.setFirstName(client.getFirstName());
        clientDTO.setAge(client.getAge());
        clientDTO.setAddress(new AddressDTO(client.getAddress().getCity(), client.getAddress().getStreet(), client.getAddress().getNumberOfBuilding()));
        List<Order> orders = client.getOrders();
        List <OrderDTO> orderDTOS = new ArrayList<>();
        for(Order x: orders){
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderID(x.getOrderID());
            orderDTO.setOrderDate(x.getOrderDate());
            orderDTOS.add(orderDTO);

        }
        clientDTO.setOrders(orderDTOS);
        return clientDTO;
    }
}
