package br.com.gabrielmsantos.optics.controller.dto;

import br.com.gabrielmsantos.optics.domain.model.Employee;
import br.com.gabrielmsantos.optics.domain.model.Store;

public record EmployeeDto(Long id, String name, int status, Store store) {

    public EmployeeDto(Employee model) {
        this(model.getId(), model.getName(), model.getStatus(), model.getStore());
    }

    public Employee toModel() {
        Employee model = new Employee();
        model.setId(this.id);
        model.setName(this.name);
        model.setStatus(this.status);
        model.setStore(this.store);
        return model;
    }
}
