package br.com.gabrielmsantos.otica.controller;


import br.com.gabrielmsantos.otica.controller.dto.StoreDto;
import br.com.gabrielmsantos.otica.service.StoreService;
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
@RequestMapping("/stores")
@Tag(name = "Stores Controller", description = "RESTFULL API for managing stores.")
public record StoreController(StoreService storeService) {

    @GetMapping
    @Operation(summary = "Get all stores", description = "Retrieve a list of all registered stores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public ResponseEntity<List<StoreDto>> findAll() {
        var stores = storeService.findAll();
        var storesDto = stores.stream().map(StoreDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(storesDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a store by ID", description = "Retrieve a specific store based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "store not found")
    })
    public ResponseEntity<StoreDto> findById(@PathVariable Long id) {
        var store = storeService.findById(id);
        return ResponseEntity.ok(new StoreDto(store));
    }

    @PostMapping
    @Operation(summary = "Create a new store", description = "Create a new store and return the created store's data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "store created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid store data provided")
    })
    public ResponseEntity<StoreDto> create(@RequestBody StoreDto storeDto) {
        var store = storeService.create(storeDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(store.getId())
                .toUri();
        return ResponseEntity.created(location).body(new StoreDto(store));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a store", description = "Update the data of an existing store based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "store updated successfully"),
            @ApiResponse(responseCode = "404", description = "store not found"),
            @ApiResponse(responseCode = "422", description = "Invalid store data provided")
    })
    public ResponseEntity<StoreDto> update(@PathVariable Long id, @RequestBody StoreDto storeDto) {
        var store = storeService.update(id, storeDto.toModel());
        return ResponseEntity.ok(new StoreDto(store));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a store", description = "Delete an existing store based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "store deleted successfully"),
            @ApiResponse(responseCode = "404", description = "store not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        storeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
