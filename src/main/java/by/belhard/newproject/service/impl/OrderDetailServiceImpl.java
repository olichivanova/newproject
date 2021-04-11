package by.belhard.newproject.service.impl;

import by.belhard.newproject.dto.CategoryDTO;
import by.belhard.newproject.dto.OrderDTO;
import by.belhard.newproject.dto.OrderDetailDTO;
import by.belhard.newproject.dto.ProductDTO;
import by.belhard.newproject.repository.OrderDetailRepository;
import by.belhard.newproject.repository.entity.*;
import by.belhard.newproject.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailRepository orderDetailRepository;
@Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetailDTO> getOrder(Integer orderID) {

        return convertListFromEntityToDTO(orderDetailRepository.getOrder(orderID));
    }

    @Override
    public void remove(OrderDetailDTO orderDetailDTO) {
       orderDetailRepository.delete(convertFromDTOToEntity(orderDetailDTO) );
    }

    @Override
    public List<OrderDetailDTO> getOrderWithProduct(Integer orderID) {
        return convertListFromEntityToDTOWithProduct(orderDetailRepository.getOrderWithProduct(orderID));
    }

    @Override
    public void save(OrderDetailDTO orderDetailDTO) {
     orderDetailRepository.save(convertListFromDTOToEntityWithProduct(orderDetailDTO))  ;
    }

    public List<OrderDetailDTO> convertListFromEntityToDTO(List<OrderDetail> orderDetails){
    List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
    for (OrderDetail x: orderDetails){
        OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
        if (x.getOrderDetailID() !=null){
            orderDetailDTO.setOrderDetailID(x.getOrderDetailID());
        }
        orderDetailDTO.setPrice(x.getPrice());
        orderDetailDTO.setQuantity(x.getQuantity());
        orderDetailDTO.setTotal(x.getTotal());
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderID(x.getOrder().getOrderID());
        orderDTO.setOrderDate(x.getOrder().getOrderDate());
        orderDetailDTO.setOrder(orderDTO);
        orderDetailDTOS.add(orderDetailDTO);}
return orderDetailDTOS; }

    public OrderDetail convertFromDTOToEntity (OrderDetailDTO orderDetailDTO){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail. setOrderDetailID(orderDetailDTO.getOrderDetailID());
        orderDetail.setQuantity(orderDetailDTO.getQuantity());
        orderDetail.setPrice(orderDetailDTO.getPrice());
        orderDetail.setTotal(orderDetailDTO.getTotal());
    return orderDetail;
    }

    public List<OrderDetailDTO> convertListFromEntityToDTOWithProduct(List<OrderDetail> orderDetails){
        List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
        for (OrderDetail x: orderDetails){
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            if (x.getOrderDetailID() !=null){
                orderDetailDTO.setOrderDetailID(x.getOrderDetailID());
            }
            orderDetailDTO.setPrice(x.getPrice());
            orderDetailDTO.setQuantity(x.getQuantity());
            orderDetailDTO.setTotal(x.getTotal());
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderID(x.getOrder().getOrderID());
            orderDTO.setOrderDate(x.getOrder().getOrderDate());
            orderDetailDTO.setOrder(orderDTO);
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductID(x.getProduct().getProductID());
            productDTO.setProductName(x.getProduct().getProductName());
            productDTO.setPrice(x.getProduct().getPrice());
            productDTO.setInStock(x.getProduct().getInStock());
            productDTO.setUnit(x.getProduct().getUnit());
            productDTO.setCategory(new CategoryDTO(x.getProduct().getCategory().getCategoryID(), x.getProduct().getCategory().getCategoryName(), x.getProduct().getCategory().getDescription()));
            orderDetailDTO.setProduct(productDTO);
            orderDetailDTOS.add(orderDetailDTO);}
        return orderDetailDTOS; }

    public OrderDetail convertListFromDTOToEntityWithProduct(OrderDetailDTO orderDetailDTO){
       OrderDetail orderDetail = new OrderDetail();
       if (orderDetailDTO.getOrderDetailID()!=null)
       {orderDetail. setOrderDetailID(orderDetailDTO.getOrderDetailID());}
        orderDetail.setQuantity(orderDetailDTO.getQuantity());
        orderDetail.setPrice(orderDetailDTO.getPrice());
        orderDetail.setTotal(orderDetailDTO.getTotal());
           Order order = new Order();
        order.setOrderID(orderDetailDTO.getOrder().getOrderID());
        order.setOrderDate(orderDetailDTO.getOrder().getOrderDate());
        orderDetail.setOrder(order);
        Product product = new Product();
        product.setProductID(orderDetailDTO.getProduct().getProductID());
        product.setProductName(orderDetailDTO.getProduct().getProductName());
        product.setPrice(orderDetailDTO.getProduct().getPrice());
        product.setInStock(orderDetailDTO.getProduct().getInStock());
        product.setUnit(orderDetailDTO.getProduct().getUnit());
        product.setCategory(new Category(orderDetailDTO.getProduct().getCategory().getCategoryID(), orderDetailDTO.getProduct().getCategory().getCategoryName(), orderDetailDTO.getProduct().getCategory().getDescription()));
        orderDetail.setProduct(product);

        return orderDetail; }
}
