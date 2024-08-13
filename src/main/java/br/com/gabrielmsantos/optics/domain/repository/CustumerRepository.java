package br.com.gabrielmsantos.optics.domain.repository;

import br.com.gabrielmsantos.optics.domain.model.Custumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustumerRepository extends JpaRepository<Custumer, Long> {
}
