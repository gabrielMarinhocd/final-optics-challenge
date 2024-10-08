package br.com.gabrielmsantos.optics.domain.repository;

import br.com.gabrielmsantos.optics.domain.model.StatusOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusOrderRepository extends JpaRepository<StatusOrder, Long>  {

}
