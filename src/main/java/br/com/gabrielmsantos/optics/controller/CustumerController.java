package br.com.gabrielmsantos.optics.controller;

import br.com.gabrielmsantos.optics.controller.dto.CustumerDto;
import br.com.gabrielmsantos.optics.service.CustumerService;
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
@RequestMapping("/custumers")
@Tag(name = "Custumers Controller", description = "RESTFULL API for managing custumers.")
public record CustumerController(CustumerService custumerService) {

    @GetMapping
    @Operation(summary = "Get all custumers", description = "Retrieve a list of all registered custumers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public ResponseEntity<List<CustumerDto>> findAll() {
        var custumers = custumerService.findAll();
        var custumersDto = custumers.stream().map(CustumerDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(custumersDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a custumer by ID", description = "Retrieve a specific custumer based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "Custumer not found")
    })
    public ResponseEntity<CustumerDto> findById(@PathVariable Long id) {
        var custumer = custumerService.findById(id);
        return ResponseEntity.ok(new CustumerDto(custumer));
    }

    @PostMapping
    @Operation(summary = "Create a new custumer", description = "Create a new custumer and return the created custumer's data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Custumer created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid custumer data provided")
    })
    public ResponseEntity<CustumerDto> create(@RequestBody CustumerDto custumerDto) {
        var custumer = custumerService.create(custumerDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(custumer.getId())
                .toUri();
        return ResponseEntity.created(location).body(new CustumerDto(custumer));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a custumer", description = "Update the data of an existing custumer based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Custumer updated successfully"),
            @ApiResponse(responseCode = "404", description = "Custumer not found"),
            @ApiResponse(responseCode = "422", description = "Invalid custumer data provided")
    })
    public ResponseEntity<CustumerDto> update(@PathVariable Long id, @RequestBody CustumerDto custumerDto) {
        var custumer = custumerService.update(id, custumerDto.toModel());
        return ResponseEntity.ok(new CustumerDto(custumer));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a custumer", description = "Delete an existing custumer based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Custumer deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Custumer not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        custumerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
