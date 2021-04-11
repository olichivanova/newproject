package by.belhard.newproject.repository;

import by.belhard.newproject.repository.entity.OrderDetail;
import by.belhard.newproject.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

    @Query("SELECT DISTINCT o FROM OrderDetail o LEFT JOIN FETCH o.order WHERE o.order.orderID =:orderID")
    public List<OrderDetail> getOrder(@Param("orderID") Integer orderID);
    @Query("SELECT DISTINCT o FROM OrderDetail o LEFT JOIN FETCH o.order LEFT JOIN FETCH o.product p LEFT JOIN FETCH p.category WHERE o.order.orderID =:orderID")
    public List<OrderDetail> getOrderWithProduct(@Param("orderID") Integer orderID);

}
