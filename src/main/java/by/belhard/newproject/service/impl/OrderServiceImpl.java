package by.belhard.newproject.service.impl;

import by.belhard.newproject.dto.*;
import by.belhard.newproject.repository.OrderRepository;
import by.belhard.newproject.repository.entity.*;
import by.belhard.newproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }




    @Override
    public OrderDTO getOrderByOrderIDWithClient(Integer orderID) {
       return convertFromEntityToDTOWithClient(orderRepository.getOrderByOrderIDWithClient(orderID)) ;

    }

   @Override
    public void save(OrderDTO orderDTO, OrderDetailDTO orderDetailDTO, ProductDTO productDTO, CategoryDTO categoryDTO) {

        orderRepository.save(convertFromDTOToEntityWithOrderDetail(orderDTO, orderDetailDTO, productDTO, categoryDTO)) ;
    }

    @Override
    public void remove(OrderDTO orderDTO) {
        orderRepository.delete( convertFromDTOToEntityWithOrderDetailAndClient(orderDTO));
    }

    @Override
    public OrderDTO getOrderByOrderIDWithClientAndOrderDetails(Integer orderID) {
        return convertFromEntityToDTOWithOrderDetailAndClient(orderRepository.getOrderByOrderIDWithClientAndOrderDetails(orderID));

    }

    public Order convertFromDTOToEntityWithClient(OrderDTO orderDTO){
        Order order = new Order();
        if(orderDTO.getOrderID() != null)
        {  order.setOrderID(orderDTO.getOrderID());}
        order.setOrderDate(orderDTO.getOrderDate());
        Client client = new Client();
        client.setClientID(orderDTO.getClient().getClientID());
        client.setLastName(orderDTO.getClient().getLastName());
        client.setFirstName(orderDTO.getClient().getFirstName());
        client.setAge(orderDTO.getClient().getAge());
        client.setAddress(new Address(orderDTO.getClient().getAddress().getCity(), orderDTO.getClient().getAddress().getStreet(), orderDTO.getClient().getAddress().getNumberOfBuilding()));
        order.setClient(client);
        return order;
    }

    public OrderDTO convertFromEntityToDTOWithClient(Order order){
        OrderDTO orderDTO = new OrderDTO();
        if (order!=null){
            orderDTO.setOrderID(order.getOrderID());}
            orderDTO.setOrderDate(order.getOrderDate());
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setClientID(order.getClient().getClientID());
            clientDTO.setFirstName(order.getClient().getFirstName());
            clientDTO.setLastName(order.getClient().getLastName());
            clientDTO.setAge(order.getClient().getAge());
            clientDTO.setAddress(new AddressDTO(order.getClient().getAddress().getCity(), order.getClient().getAddress().getStreet(), order.getClient().getAddress().getNumberOfBuilding()));
            orderDTO.setClient(clientDTO);



        return orderDTO;
    }

    public Order convertFromDTOToEntityWithOrderDetail(OrderDTO orderDTO, OrderDetailDTO orderDetailDTO, ProductDTO productDTO, CategoryDTO categoryDTO){
        Order order = new Order();
        if(orderDTO.getOrderID() != null)
        {  order.setOrderID(orderDTO.getOrderID());}
        order.setOrderDate(orderDTO.getOrderDate());
        Client client = new Client();
        client.setClientID(orderDTO.getClient().getClientID());
        client.setLastName(orderDTO.getClient().getLastName());
        client.setFirstName(orderDTO.getClient().getFirstName());
        client.setAge(orderDTO.getClient().getAge());
        client.setAddress(new Address(orderDTO.getClient().getAddress().getCity(), orderDTO.getClient().getAddress().getStreet(), orderDTO.getClient().getAddress().getNumberOfBuilding()));
        order.setClient(client);
        OrderDetail orderDetail = new OrderDetail();
        if (orderDetailDTO.getOrderDetailID() !=null){
            orderDetail.setOrderDetailID(orderDetailDTO.getOrderDetailID());
        }
        orderDetail.setPrice(orderDetailDTO.getPrice());
        orderDetail.setQuantity(orderDetailDTO.getQuantity());
        orderDetail.setTotal(orderDetailDTO.getTotal());

        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(orderDetail);
        order.setOrderDetails(orderDetails);
        orderDetail.setOrder(order);
        Product product = new Product();
        if (productDTO.getProductID() != null){
            product.setProductID(productDTO.getProductID());
        }
        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        product.setUnit(productDTO.getUnit());
        product.setInStock(productDTO.getInStock());
        product.setCategory(new Category(categoryDTO.getCategoryID(), categoryDTO.getCategoryName(), categoryDTO.getDescription() ));
        orderDetail.setProduct(product);

        return order;
    }

   public Order convertFromDTOToEntityWithOrder(OrderDTO orderDTO, OrderDetailDTO orderDetailDTO ) {
       Order order = new Order();
       if(orderDTO.getOrderID() != null)
       {  order.setOrderID(orderDTO.getOrderID());}
       order.setOrderDate(orderDTO.getOrderDate());
       Client client = new Client();
       client.setClientID(orderDTO.getClient().getClientID());
       client.setLastName(orderDTO.getClient().getLastName());
       client.setFirstName(orderDTO.getClient().getFirstName());
       client.setAge(orderDTO.getClient().getAge());
       client.setAddress(new Address(orderDTO.getClient().getAddress().getCity(), orderDTO.getClient().getAddress().getStreet(), orderDTO.getClient().getAddress().getNumberOfBuilding()));
       order.setClient(client);
       OrderDetail orderDetail = new OrderDetail();
       if (orderDetailDTO.getOrderDetailID() !=null){
           orderDetail.setOrderDetailID(orderDetailDTO.getOrderDetailID());
       }
       orderDetail.setPrice(orderDetailDTO.getPrice());
       orderDetail.setQuantity(orderDetailDTO.getQuantity());
       orderDetail.setTotal(orderDetailDTO.getTotal());
       orderDetail.setOrder(order);

   return  order;}

    public OrderDTO convertFromEntityToDTOWithOrderDetailAndClient(Order order ){
        OrderDTO orderDTO = new OrderDTO();
        if(order.getOrderID() != null)
        {  orderDTO.setOrderID(order.getOrderID());}
        orderDTO.setOrderDate(order.getOrderDate());
        ClientDTO client = new ClientDTO();
        client.setClientID(order.getClient().getClientID());
        client.setLastName(order.getClient().getLastName());
        client.setFirstName(order.getClient().getFirstName());
        client.setAge(order.getClient().getAge());
        client.setAddress(new AddressDTO(order.getClient().getAddress().getCity(), order.getClient().getAddress().getStreet(), order.getClient().getAddress().getNumberOfBuilding()));
        orderDTO.setClient(client);
        List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
        for (OrderDetail x: order.getOrderDetails() ){
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setOrderDetailID(x.getOrderDetailID());
            orderDetailDTO.setPrice(x.getPrice());
            orderDetailDTO.setQuantity(x.getQuantity());
            orderDetailDTO.setTotal(x.getTotal());
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductID(x.getProduct().getProductID());
            productDTO.setProductName(x.getProduct().getProductName());
            productDTO.setPrice(x.getProduct().getPrice());
            productDTO.setUnit(x.getProduct().getUnit());
            productDTO.setInStock(x.getProduct().getInStock());
            orderDetailDTO.setProduct(productDTO);
            orderDetailDTOS.add(orderDetailDTO);


        }
        orderDTO.setOrderDetailDTOS(orderDetailDTOS);
        return orderDTO;
    }

    public Order convertFromDTOToEntityWithOrderDetailAndClient(OrderDTO orderDTO ){
        Order order = new Order();
        if(orderDTO.getOrderID() != null)
        {  order.setOrderID(orderDTO.getOrderID());}
        order.setOrderDate(orderDTO.getOrderDate());
        Client client = new Client();
        client.setClientID(orderDTO.getClient().getClientID());
        client.setLastName(orderDTO.getClient().getLastName());
        client.setFirstName(orderDTO.getClient().getFirstName());
        client.setAge(orderDTO.getClient().getAge());
        client.setAddress(new Address(orderDTO.getClient().getAddress().getCity(), orderDTO.getClient().getAddress().getStreet(), orderDTO.getClient().getAddress().getNumberOfBuilding()));
        order.setClient(client);
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (OrderDetailDTO x: orderDTO.getOrderDetailDTOS() ){
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderDetailID(x.getOrderDetailID());
            orderDetail.setPrice(x.getPrice());
            orderDetail.setQuantity(x.getQuantity());
            orderDetail.setTotal(x.getTotal());
            Product product = new Product();
            product.setProductID(x.getProduct().getProductID());
            product.setProductName(x.getProduct().getProductName());
            product.setPrice(x.getProduct().getPrice());
            product.setUnit(x.getProduct().getUnit());
            product.setInStock(x.getProduct().getInStock());
            orderDetail.setProduct(product);
            orderDetails.add(orderDetail);


        }
        order.setOrderDetails(orderDetails);
        return order;
    }
   }

