package by.belhard.newproject.repository.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer orderID;

    @Column(name = "client_id", insertable = false, updatable = false)
    Integer clientID;

    @Column(name = "order_date")
    Date orderDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id",  nullable = false)
    Client client;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    List<OrderDetail> orderDetails;
    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", clientID=" + clientID +
                ", orderDate=" + orderDate +
                ", client=" + client +

                '}';
    }
}
