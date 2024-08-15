package br.com.gabrielmsantos.optics.controller;

import br.com.gabrielmsantos.optics.controller.dto.StatusOrderDto;
import br.com.gabrielmsantos.optics.service.StatusOrderService;
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
@RequestMapping("/status-orders")
@Tag(name = "Status Orders Controller", description = "RESTFULL API for managing statusOrders.")
public record StatusOrderController(StatusOrderService statusOrderService) {

    @GetMapping
    @Operation(summary = "Get all statusOrders", description = "Retrieve a list of all registered statusOrders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public ResponseEntity<List<StatusOrderDto>> findAll() {
        var statusOrders = statusOrderService.findAll();
        var statusOrdersDto = statusOrders.stream().map(StatusOrderDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(statusOrdersDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a statusOrder by ID", description = "Retrieve a specific statusOrder based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "statusOrder not found")
    })
    public ResponseEntity<StatusOrderDto> findById(@PathVariable Long id) {
        var statusOrder = statusOrderService.findById(id);
        return ResponseEntity.ok(new StatusOrderDto(statusOrder));
    }

    @PostMapping
    @Operation(summary = "Create a new statusOrder", description = "Create a new statusOrder and return the created statusOrder's data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "StatusOrder created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid statusOrder data provided")
    })
    public ResponseEntity<StatusOrderDto> create(@RequestBody StatusOrderDto statusOrderDto) {
        var statusOrder = statusOrderService.create(statusOrderDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(statusOrder.getId())
                .toUri();
        return ResponseEntity.created(location).body(new StatusOrderDto(statusOrder));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a statusOrder", description = "Update the data of an existing statusOrder based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "StatusOrder updated successfully"),
            @ApiResponse(responseCode = "404", description = "StatusOrder not found"),
            @ApiResponse(responseCode = "422", description = "Invalid statusOrder data provided")
    })
    public ResponseEntity<StatusOrderDto> update(@PathVariable Long id, @RequestBody StatusOrderDto statusOrderDto) {
        var statusOrder = statusOrderService.update(id, statusOrderDto.toModel());
        return ResponseEntity.ok(new StatusOrderDto(statusOrder));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a statusOrder", description = "Delete an existing statusOrder based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "StatusOrder deleted successfully"),
            @ApiResponse(responseCode = "404", description = "StatusOrder not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        statusOrderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
