package taco.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import taco.domain.TacoOrder;
import taco.domain.User;

import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder,Long> {

  List<TacoOrder> findAllByDeliveryZip(String deliveryZip);

  List<TacoOrder> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);

}
