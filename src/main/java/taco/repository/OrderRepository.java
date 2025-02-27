package taco.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import taco.domain.TacoOrder;
import taco.domain.User;

import java.util.List;

public interface OrderRepository extends JpaRepository<TacoOrder,Long> {

}
