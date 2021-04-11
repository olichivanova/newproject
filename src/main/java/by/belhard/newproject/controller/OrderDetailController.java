package by.belhard.newproject.controller;


import by.belhard.newproject.dto.OrderDetailDTO;
import by.belhard.newproject.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderDetailController {

    private OrderDetailService orderDetailService;

@Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }
    @RequestMapping(value = "/remove", method= RequestMethod.GET)
    public String removeOrder( @RequestParam("orderID") Integer orderID) {
       List<OrderDetailDTO> orderDetailDTOList = orderDetailService.getOrder(orderID);
       if(orderDetailDTOList == null){
           return "redirect:/products-home";
       }
       List<OrderDetailDTO> orderDetailDTOS = orderDetailService.getOrderWithProduct(orderID);
       for (OrderDetailDTO x: orderDetailDTOS ){
           x.getProduct().setInStock(x.getProduct().getInStock()+x.getQuantity());
           orderDetailService.save(x);
       }
       for (OrderDetailDTO x:orderDetailDTOList ){
           orderDetailService.remove(x);
       }

        return "redirect:/products-home";}

}
