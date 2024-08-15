package br.com.gabrielmsantos.optics.domain.repository;

import br.com.gabrielmsantos.optics.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>  {

}
