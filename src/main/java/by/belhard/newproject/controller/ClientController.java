package by.belhard.newproject.controller;



import by.belhard.newproject.dto.ClientDTO;
import by.belhard.newproject.dto.OrderDTO;
import by.belhard.newproject.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.sql.Date;



@Controller
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/new-client")
    public String addNewClientForm(ModelMap modelMap) {
        ClientDTO client = new ClientDTO();
        modelMap.addAttribute("client", client);
        return "new-client";
    }
    @RequestMapping(value = "/save-client", method= RequestMethod.POST)
    public String chechAndSaveClient (@Valid @ModelAttribute("client") ClientDTO client, BindingResult result){
      if (result.hasErrors()) {
           return "redirect:/new-client";

        }
        ClientDTO clientDTO = null;
        try {
          clientDTO = clientService.getByParam(client.getLastName(), client.getFirstName(), client.getAge(), client.getAddress().getCity(), client.getAddress().getStreet(), client.getAddress().getNumberOfBuilding());
        }
        catch (NullPointerException e){}
        java.util.Date date = new java.util.Date();
        Date datenow = new Date(date.getTime());
     if (clientDTO != null)
     { client.setClientID(clientDTO.getClientID());
          clientService.save(datenow, client);
     } else {
         clientService.save(datenow, client);
     }
         ClientDTO clientDTO1 =clientService.getClientByParamWithOrder(client.getLastName(), client.getFirstName(), client.getAge(), client.getAddress().getCity(), client.getAddress().getStreet(), client.getAddress().getNumberOfBuilding());
        OrderDTO orderDTO  = new OrderDTO();
        for (OrderDTO x: clientDTO1.getOrders()){
            if(x.getOrderDate().equals(datenow))
            {orderDTO = x;
                break;}

            }


        return "redirect:/products?orderID=" + orderDTO.getOrderID();}




}


