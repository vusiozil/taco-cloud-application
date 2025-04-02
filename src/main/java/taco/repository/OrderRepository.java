package taco.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taco.domain.Order;
import taco.domain.User;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

  List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);

}
