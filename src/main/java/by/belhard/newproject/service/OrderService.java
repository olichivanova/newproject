package by.belhard.newproject.service;

import by.belhard.newproject.dto.CategoryDTO;
import by.belhard.newproject.dto.OrderDTO;
import by.belhard.newproject.dto.OrderDetailDTO;
import by.belhard.newproject.dto.ProductDTO;



public interface OrderService {


    public OrderDTO getOrderByOrderIDWithClient(Integer orderID);

   public void save(OrderDTO orderDTO, OrderDetailDTO orderDetailDTO, ProductDTO productDTO, CategoryDTO categoryDTO);
   public OrderDTO getOrderByOrderIDWithClientAndOrderDetails(Integer orderID);
   public void remove(OrderDTO orderDTO);
}
