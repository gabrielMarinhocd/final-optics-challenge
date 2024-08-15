package br.com.gabrielmsantos.optics.controller.dto;

import br.com.gabrielmsantos.optics.domain.model.PaymentMethods;

import java.util.Date;

public record PaymentMethodsDto(Long id, String nome, int plot, Date datePay, double value, int status) {

    public PaymentMethodsDto(PaymentMethods model) {
        this(model.getId(), model.getNome(), model.getPlot(), model.getDatePay(), model.getValue(), model.getStatus());
    }

    public PaymentMethods toModel() {
        PaymentMethods model = new PaymentMethods();
        model.setId(this.id);
        model.setNome(this.nome);
        model.setPlot(this.plot);
        model.setDatePay(this.datePay);
        model.setValue(this.value);
        model.setStatus(this.status);
        return model;
    }
}
