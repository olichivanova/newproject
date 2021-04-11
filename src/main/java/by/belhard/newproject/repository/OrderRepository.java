package by.belhard.newproject.repository;

import by.belhard.newproject.repository.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.client WHERE o.orderID= :orderID")
    public Order getOrderByOrderIDWithClient(@Param( "orderID") Integer orderID);
    @Query("SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.client  LEFT JOIN FETCH o.orderDetails od LEFT JOIN FETCH od.product WHERE o.orderID= :orderID")
   public Order getOrderByOrderIDWithClientAndOrderDetails(@Param( "orderID") Integer orderID);
    @Query("SELECT DISTINCT o FROM Order o   LEFT JOIN FETCH o.orderDetails od LEFT JOIN FETCH od.product WHERE o.orderID= :orderID")
    public Order getOrderByOrderIDWithProduct(@Param( "orderID") Integer orderID);
}
