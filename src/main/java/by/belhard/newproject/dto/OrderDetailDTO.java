package by.belhard.newproject.dto;

import by.belhard.newproject.repository.entity.Order;
import by.belhard.newproject.repository.entity.Product;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

public class OrderDetailDTO {

    private Integer orderDetailID;
    @NotNull(message = "is required")
    private float quantity;
    private float price;
    private float total;
    private OrderDTO order;
    private ProductDTO product;

    public Integer getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(Integer orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" +
                "orderDetailID=" + orderDetailID +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}



