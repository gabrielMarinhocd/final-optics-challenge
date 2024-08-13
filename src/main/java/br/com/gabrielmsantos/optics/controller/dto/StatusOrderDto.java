package br.com.gabrielmsantos.optics.controller.dto;

import br.com.gabrielmsantos.optics.domain.model.StatusOrder;

public record StatusOrderDto(Long id, String title, int status) {

    public StatusOrderDto(StatusOrder model) {
        this(model.getId(), model.getTitle(), model.getStatus());
    }

    public StatusOrder toModel() {
        StatusOrder model = new StatusOrder();
        model.setId(this.id);
        model.setTitle(this.title);
        model.setStatus(this.status);
        return model;
    }
}
