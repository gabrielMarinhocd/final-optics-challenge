package br.com.gabrielmsantos.optics.controller;

import br.com.gabrielmsantos.optics.controller.dto.EmployeeDto;
import br.com.gabrielmsantos.optics.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/employees")
@Tag(name = "Employees Controller", description = "RESTFULL API for managing employees.")
public record EmployeeController(EmployeeService employeeService) {

    @GetMapping
    @Operation(summary = "Get all employees", description = "Retrieve a list of all registered employees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public ResponseEntity<List<EmployeeDto>> findAll() {
        var employees = employeeService.findAll();
        var employeesDto = employees.stream().map(EmployeeDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(employeesDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a employee by ID", description = "Retrieve a specific employee based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "employee not found")
    })
    public ResponseEntity<EmployeeDto> findById(@PathVariable Long id) {
        var employee = employeeService.findById(id);
        return ResponseEntity.ok(new EmployeeDto(employee));
    }

    @PostMapping
    @Operation(summary = "Create a new employee", description = "Create a new employee and return the created employee's data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "employee created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid employee data provided")
    })
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employeeDto) {
        var employee = employeeService.create(employeeDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();
        return ResponseEntity.created(location).body(new EmployeeDto(employee));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a employee", description = "Update the data of an existing employee based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "employee updated successfully"),
            @ApiResponse(responseCode = "404", description = "employee not found"),
            @ApiResponse(responseCode = "422", description = "Invalid employee data provided")
    })
    public ResponseEntity<EmployeeDto> update(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {
        var employee = employeeService.update(id, employeeDto.toModel());
        return ResponseEntity.ok(new EmployeeDto(employee));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a employee", description = "Delete an existing employee based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "employee deleted successfully"),
            @ApiResponse(responseCode = "404", description = "employee not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
