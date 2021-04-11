package by.belhard.newproject.controller;

import by.belhard.newproject.dto.*;
import by.belhard.newproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class OrderController {

    private OrderService orderService;

@Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @RequestMapping(value = "/buy", method= RequestMethod.POST)
    public String saveOrder(@ModelAttribute("productDTO") ProductDTO productDTO, @RequestParam("orderID") Integer orderID, @RequestParam("quantity") String quantity, @ModelAttribute("category") CategoryDTO categoryDTO, ModelMap modelMap) {
       if (orderID == null)
       {return "redirect:/products-home";}
        if (quantity == null)
        {return "redirect:products/open?orderID=" +orderID + "&productID=" + productDTO.getProductID();}
        float quantity1= Float.parseFloat(quantity);
       if (productDTO.getInStock()<quantity1 || (productDTO.getUnit().equals("шт.") && quantity1%1!=0)){

           return "redirect:products/open?orderID=" +orderID + "&productID=" + productDTO.getProductID();
       }
        ProductDTO productDTO1 = productDTO;

        productDTO1.setInStock(productDTO.getInStock()-quantity1);
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        orderDetailDTO.setQuantity(quantity1);
        orderDetailDTO.setPrice(productDTO1.getPrice());
        orderDetailDTO.setTotal(orderDetailDTO.getPrice()*orderDetailDTO.getQuantity());
        OrderDTO orderDTO = orderService.getOrderByOrderIDWithClient(orderID);
        orderService.save(orderDTO, orderDetailDTO, productDTO1, categoryDTO);
        return "redirect:/products?orderID=" + orderID;
    }

    @RequestMapping(value = "/confirmation", method= RequestMethod.GET)
    public String confirmOrder( @RequestParam("orderID") Integer orderID, ModelMap modelMap) {
        OrderDTO orderDTO = orderService.getOrderByOrderIDWithClientAndOrderDetails(orderID);
        modelMap.addAttribute("orderDTO",orderDTO);
            return "confirmation";}


}

