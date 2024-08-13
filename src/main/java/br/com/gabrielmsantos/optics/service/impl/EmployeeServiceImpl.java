package br.com.gabrielmsantos.optics.service.impl;

import br.com.gabrielmsantos.optics.domain.model.Employee;
import br.com.gabrielmsantos.optics.domain.repository.EmployeeRepository;
import br.com.gabrielmsantos.optics.service.EmployeeService;
import br.com.gabrielmsantos.optics.service.exception.BusinessException;
import br.com.gabrielmsantos.optics.service.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee findById(Long id) {
        return this.employeeRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Employee create(Employee EmployeeToCreate) {
        ofNullable(EmployeeToCreate).orElseThrow(() -> new BusinessException("Employee to create must not be null."));

        return this.employeeRepository.save(EmployeeToCreate);
    }

    @Transactional
    public Employee update(Long id, Employee employeeToUpdate) {
        Employee dbEmployee = this.findById(id);
        if (!dbEmployee.getId().equals(employeeToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbEmployee.setName(employeeToUpdate.getName());
        dbEmployee.setStatus(employeeToUpdate.getStatus());
        dbEmployee.setStore(employeeToUpdate.getStore());

        return this.employeeRepository.save(dbEmployee);
    }

    @Transactional
    public void delete(Long id) {
        Employee dbEmployee = this.findById(id);
        this.employeeRepository.delete(dbEmployee);
    }

}
