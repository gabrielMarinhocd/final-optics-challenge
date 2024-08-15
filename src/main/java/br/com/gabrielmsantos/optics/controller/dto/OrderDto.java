package br.com.gabrielmsantos.optics.controller.dto;

import br.com.gabrielmsantos.optics.domain.model.*;

import java.util.Date;
import java.util.List;

public record OrderDto(
        Long id,
        int status,
        Date dtOrder,
        String dtDelivery,
        String timeOrder,
        int lens,
        double valueLens,
        String materialLens,
        String typeLens,
        int frame,
        double valueFrame,
        String materialFrame,
        String typeFrame,
        String esfLongOe,
        String esfCloseOd,
        String esfCloseOe,
        String cilLongOd,
        String cilLongOe,
        String cilCloseOd,
        String cilCloseOe,
        String eixoLongOd,
        String eixoLongOe,
        String eixoCloseOd,
        String eixoCloseOe,
        String dnpLongOd,
        String dnpLongOe,
        String dnpCloseOd,
        String dnpCloseOe,
        String heigthLongOd,
        String heigthLongOe,
        String heigthCloseOd,
        String heigthCloseOe,
        String dm,
        String adicao,
        String vert,
        String hor,
        String ponte,
        String obs,
        String markaLens,
        String markaFrame,
        String indication,
        double valueIndication,
        double totalLens,
        double totalFrame,
        String indicationStore,
        double valueStore,
        Employee employee,
        Custumer custumer,
        Store store,
        StatusOrder statusOrder,
        List<PaymentMethods> paymentMethods
) {

    public OrderDto(Order model) {
        this(model.getId(), model.getStatus(), model.getDtOrder(), model.getDtDelivery(), model.getTimeOrder(), model.getLens(), model.getValueLens(), model.getMaterialLens(), model.getTypeLens(), model.getFrame(), model.getValueFrame(), model.getMaterialFrame(), model.getTypeFrame(), model.getEsfLongOe(), model.getEsfCloseOd(), model.getEsfCloseOe(), model.getCilLongOd(), model.getCilLongOe(), model.getCilCloseOd(), model.getCilCloseOe(), model.getEixoLongOd(), model.getEixoLongOe(), model.getEixoCloseOd(), model.getEixoCloseOe(), model.getDnpLongOd(), model.getDnpLongOe(), model.getDnpCloseOd(), model.getDnpCloseOe(), model.getHeigthLongOd(), model.getHeigthLongOe(), model.getHeigthCloseOd(), model.getHeigthCloseOe(), model.getDm(), model.getAdicao(), model.getVert(), model.getHor(), model.getPonte(), model.getObs(), model.getMarkaLens(), model.getMarkaFrame(), model.getIndication(), model.getValueIndication(), model.getTotalLens(), model.getTotalFrame(), model.getIndicationStore(), model.getValueStore(), model.getEmployee(), model.getCustumer(), model.getStore(), model.getStatusOrder(), model.getPaymentMethods());
    }

    public Order toModel() {
        Order model = new Order();
        model.setId(this.id);
        model.setStatus(this.status);
        model.setDtOrder(this.dtOrder);
        model.setDtDelivery(this.dtDelivery);
        model.setTimeOrder(this.timeOrder);
        model.setLens(this.lens);
        model.setValueLens(this.valueLens);
        model.setMaterialLens(this.materialLens);
        model.setTypeLens(this.typeLens);
        model.setFrame(this.frame);
        model.setValueFrame(this.valueFrame);
        model.setMaterialFrame(this.materialFrame);
        model.setTypeFrame(this.typeFrame);
        model.setEsfLongOe(this.esfLongOe);
        model.setEsfCloseOd(this.esfCloseOd);
        model.setEsfCloseOe(this.esfCloseOe);
        model.setCilLongOd(this.cilLongOd);
        model.setCilLongOe(this.cilLongOe);
        model.setCilCloseOd(this.cilCloseOd);
        model.setCilCloseOe(this.cilCloseOe);
        model.setEixoLongOd(this.eixoLongOd);
        model.setEixoLongOe(this.eixoLongOe);
        model.setEixoCloseOd(this.eixoCloseOd);
        model.setEixoCloseOe(this.eixoCloseOe);
        model.setDnpLongOd(this.dnpLongOd);
        model.setDnpLongOe(this.dnpLongOe);
        model.setDnpCloseOd(this.dnpCloseOd);
        model.setDnpCloseOe(this.dnpCloseOe);
        model.setHeigthLongOd(this.heigthLongOd);
        model.setHeigthLongOe(this.heigthLongOe);
        model.setHeigthCloseOd(this.heigthCloseOd);
        model.setHeigthCloseOe(this.heigthCloseOe);
        model.setDm(this.dm);
        model.setAdicao(this.adicao);
        model.setVert(this.vert);
        model.setHor(this.hor);
        model.setPonte(this.ponte);
        model.setObs(this.obs);
        model.setMarkaLens(this.markaLens);
        model.setMarkaFrame(this.markaFrame);
        model.setIndication(this.indication);
        model.setValueIndication(this.valueIndication);
        model.setTotalLens(this.totalLens);
        model.setTotalFrame(this.totalFrame);
        model.setIndicationStore(this.indicationStore);
        model.setValueStore(this.valueStore);
        model.setEmployee(this.employee);
        model.setCustumer(this.custumer);
        model.setStore(this.store);
        model.setStatusOrder(this.statusOrder);
        model.setPaymentMethods(this.paymentMethods);
        return model;
    }
}
