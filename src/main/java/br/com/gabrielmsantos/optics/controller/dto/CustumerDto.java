package br.com.gabrielmsantos.optics.controller.dto;

import br.com.gabrielmsantos.optics.domain.model.Custumer;

public record CustumerDto(Long id, String cpf, String nome, String telefone, int status) {

    public CustumerDto(Custumer model) {
        this(model.getId(), model.getCpf(), model.getNome(), model.getTelefone(), model.getStatus());
    }

    public Custumer toModel() {
        Custumer model = new Custumer();
        model.setId(this.id);
        model.setNome(this.nome);
        model.setCpf(this.cpf);
        model.setTelefone(this.telefone);
        model.setStatus(this.status);
        return model;
    }
}
