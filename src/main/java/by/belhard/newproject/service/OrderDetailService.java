package by.belhard.newproject.service;

import by.belhard.newproject.dto.OrderDetailDTO;

import java.util.List;

public interface OrderDetailService {
    public List<OrderDetailDTO> getOrder( Integer orderID);
    public void remove(OrderDetailDTO orderDetailDTO);
    public List<OrderDetailDTO> getOrderWithProduct( Integer orderID);
    public void save(OrderDetailDTO orderDetailDTO);
}
