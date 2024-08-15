package br.com.gabrielmsantos.optics.service.impl;

import br.com.gabrielmsantos.optics.domain.model.Order;
import br.com.gabrielmsantos.optics.domain.repository.OrderRepository;
import br.com.gabrielmsantos.optics.service.OrderService;
import br.com.gabrielmsantos.optics.service.exception.BusinessException;
import br.com.gabrielmsantos.optics.service.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository OrderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.OrderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return this.OrderRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Order findById(Long id) {
        return this.OrderRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Order create(Order OrderToCreate) {
        ofNullable(OrderToCreate).orElseThrow(() -> new BusinessException("Order to create must not be null."));

        return this.OrderRepository.save(OrderToCreate);
    }

    @Transactional
    public Order update(Long id, Order OrderToUpdate) {
        Order dbOrder = this.findById(id);
        if (!dbOrder.getId().equals(OrderToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbOrder.setDtOrder(OrderToUpdate.getDtOrder());
        dbOrder.setDtDelivery(OrderToUpdate.getDtDelivery());
        dbOrder.setTimeOrder(OrderToUpdate.getTimeOrder());
        dbOrder.setLens(OrderToUpdate.getLens());
        dbOrder.setValueLens(OrderToUpdate.getValueLens());
        dbOrder.setMaterialLens(OrderToUpdate.getMaterialLens());
        dbOrder.setTypeLens(OrderToUpdate.getTypeLens());
        dbOrder.setFrame(OrderToUpdate.getFrame());
        dbOrder.setValueFrame(OrderToUpdate.getValueFrame());
        dbOrder.setMaterialFrame(OrderToUpdate.getMaterialFrame());
        dbOrder.setTypeFrame(OrderToUpdate.getTypeFrame());
        dbOrder.setEsfLongOe(OrderToUpdate.getEsfLongOe());
        dbOrder.setEsfCloseOd(OrderToUpdate.getEsfCloseOd());
        dbOrder.setEsfCloseOe(OrderToUpdate.getEsfCloseOe());
        dbOrder.setCilLongOd(OrderToUpdate.getCilLongOd());
        dbOrder.setCilLongOe(OrderToUpdate.getCilLongOe());
        dbOrder.setCilCloseOd(OrderToUpdate.getCilCloseOd());
        dbOrder.setCilCloseOe(OrderToUpdate.getCilCloseOe());
        dbOrder.setEixoLongOd(OrderToUpdate.getEixoLongOd());
        dbOrder.setEixoLongOe(OrderToUpdate.getEixoLongOe());
        dbOrder.setEixoCloseOd(OrderToUpdate.getEixoCloseOd());
        dbOrder.setEixoCloseOe(OrderToUpdate.getEixoCloseOe());
        dbOrder.setDnpLongOd(OrderToUpdate.getDnpLongOd());
        dbOrder.setDnpLongOe(OrderToUpdate.getDnpLongOe());
        dbOrder.setDnpCloseOd(OrderToUpdate.getDnpCloseOd());
        dbOrder.setDnpCloseOe(OrderToUpdate.getDnpCloseOe());
        dbOrder.setHeigthLongOd(OrderToUpdate.getHeigthLongOd());
        dbOrder.setHeigthLongOe(OrderToUpdate.getHeigthLongOe());
        dbOrder.setHeigthCloseOd(OrderToUpdate.getHeigthCloseOd());
        dbOrder.setHeigthCloseOe(OrderToUpdate.getHeigthCloseOe());
        dbOrder.setDm(OrderToUpdate.getDm());
        dbOrder.setAdicao(OrderToUpdate.getAdicao());
        dbOrder.setVert(OrderToUpdate.getVert());
        dbOrder.setHor(OrderToUpdate.getHor());
        dbOrder.setPonte(OrderToUpdate.getPonte());
        dbOrder.setObs(OrderToUpdate.getObs());
        dbOrder.setMarkaLens(OrderToUpdate.getMarkaLens());
        dbOrder.setMarkaFrame(OrderToUpdate.getMarkaFrame());
        dbOrder.setIndication(OrderToUpdate.getIndication());
        dbOrder.setValueIndication(OrderToUpdate.getValueIndication());
        dbOrder.setTotalLens(OrderToUpdate.getTotalLens());
        dbOrder.setTotalFrame(OrderToUpdate.getTotalFrame());
        dbOrder.setIndicationStore(OrderToUpdate.getIndicationStore());
        dbOrder.setValueStore(OrderToUpdate.getValueStore());
        dbOrder.setEmployee(OrderToUpdate.getEmployee());
        dbOrder.setCustumer(OrderToUpdate.getCustumer());
        dbOrder.setStore(OrderToUpdate.getStore());
        dbOrder.setStatusOrder(OrderToUpdate.getStatusOrder());
        dbOrder.setPaymentMethods(OrderToUpdate.getPaymentMethods());
        dbOrder.setStatus(OrderToUpdate.getStatus());

        return this.OrderRepository.save(dbOrder);
    }

    @Transactional
    public void delete(Long id) {
        Order dbOrder = this.findById(id);
        this.OrderRepository.delete(dbOrder);
    }

}
