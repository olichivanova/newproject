package by.belhard.newproject.dto;

import by.belhard.newproject.repository.entity.Client;
import by.belhard.newproject.repository.entity.Order;
import by.belhard.newproject.repository.entity.OrderDetail;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class OrderDTO {

    private Integer orderID;
    private Date orderDate;
    private ClientDTO client;
    private List<OrderDetailDTO> orderDetailDTOS;

    public OrderDTO() {
    }

    public OrderDTO(Integer orderID) {
        this.orderID = orderID;
    }

    public OrderDTO(Date orderDate, ClientDTO client) {
        this.orderDate = orderDate;
        this.client = client;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public List<OrderDetailDTO> getOrderDetailDTOS() {
        return orderDetailDTOS;
    }

    public void setOrderDetailDTOS(List<OrderDetailDTO> orderDetailDTOS) {
        this.orderDetailDTOS = orderDetailDTOS;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderID=" + orderID +
                ", orderDate=" + orderDate +
                ", client=" + client +
                ", orderDetailDTOS=" + orderDetailDTOS +
                '}';
    }
}
