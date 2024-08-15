package br.com.gabrielmsantos.optics.controller;


import br.com.gabrielmsantos.optics.controller.dto.OrderDto;
import br.com.gabrielmsantos.optics.service.OrderService;
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
@RequestMapping("/orders")
@Tag(name = "Orders Controller", description = "RESTFULL API for managing orders.")
public record OrderController(OrderService orderService) {

    @GetMapping
    @Operation(summary = "Get all orders", description = "Retrieve a list of all registered orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public ResponseEntity<List<OrderDto>> findAll() {
        var orders = orderService.findAll();
        var ordersDto = orders.stream().map(OrderDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(ordersDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a order by ID", description = "Retrieve a specific order based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "order not found")
    })
    public ResponseEntity<OrderDto> findById(@PathVariable Long id) {
        var order = orderService.findById(id);
        return ResponseEntity.ok(new OrderDto(order));
    }

    @PostMapping
    @Operation(summary = "Create a new order", description = "Create a new order and return the created order's data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "order created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid order data provided")
    })
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto orderDto) {
        var order = orderService.create(orderDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId())
                .toUri();
        return ResponseEntity.created(location).body(new OrderDto(order));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a order", description = "Update the data of an existing order based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "order updated successfully"),
            @ApiResponse(responseCode = "404", description = "order not found"),
            @ApiResponse(responseCode = "422", description = "Invalid order data provided")
    })
    public ResponseEntity<OrderDto> update(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        var order = orderService.update(id, orderDto.toModel());
        return ResponseEntity.ok(new OrderDto(order));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a order", description = "Delete an existing order based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "order deleted successfully"),
            @ApiResponse(responseCode = "404", description = "order not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
