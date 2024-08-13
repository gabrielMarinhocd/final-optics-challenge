package br.com.gabrielmsantos.optics.domain.repository;

import br.com.gabrielmsantos.optics.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
