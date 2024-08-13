package br.com.gabrielmsantos.optics.domain.repository;

import br.com.gabrielmsantos.optics.domain.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>  {

}
