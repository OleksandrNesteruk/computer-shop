package com.example.computer_shop.repository;

import com.example.computer_shop.model.Order;
import com.example.computer_shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    String ORDER_HISTORY = "SELECT DISTINCT o FROM Order o "
            + "left join fetch o.computers c "
            + "WHERE o.user = ?1";

    @Query(ORDER_HISTORY)
    List<Order> getOrdersHistory(User user);
}
