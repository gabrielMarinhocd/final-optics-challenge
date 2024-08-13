package br.com.gabrielmsantos.optics.controller.dto;

import br.com.gabrielmsantos.optics.domain.model.Store;

public record StoreDto(Long id, String titulo, int status) {

    public StoreDto(Store model) {
        this(model.getId(), model.getTitulo(), model.getStatus());
    }

    public Store toModel() {
        Store model = new Store();
        model.setId(this.id);
        model.setTitulo(this.titulo);
        model.setStatus(this.status);
        return model;
    }
}