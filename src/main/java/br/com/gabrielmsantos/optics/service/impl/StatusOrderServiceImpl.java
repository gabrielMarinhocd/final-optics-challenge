package br.com.gabrielmsantos.optics.service.impl;



import br.com.gabrielmsantos.optics.domain.model.StatusOrder;
import br.com.gabrielmsantos.optics.domain.repository.StatusOrderRepository;
import br.com.gabrielmsantos.optics.service.StatusOrderService;
import br.com.gabrielmsantos.optics.service.exception.BusinessException;
import br.com.gabrielmsantos.optics.service.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class StatusOrderServiceImpl implements StatusOrderService {
    private final StatusOrderRepository statusOrderRepository;

    public StatusOrderServiceImpl(StatusOrderRepository statusOrderRepository) {
        this.statusOrderRepository = statusOrderRepository;
    }

    @Transactional(readOnly = true)
    public List<StatusOrder> findAll() {
        return this.statusOrderRepository.findAll();
    }

    @Transactional(readOnly = true)
    public StatusOrder findById(Long id) {
        return this.statusOrderRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public StatusOrder create(StatusOrder statusOrderToCreate) {
        ofNullable(statusOrderToCreate).orElseThrow(() -> new BusinessException("statusOrder to create must not be null."));

        return this.statusOrderRepository.save(statusOrderToCreate);
    }

    @Transactional
    public StatusOrder update(Long id, StatusOrder statusOrderToUpdate) {
        StatusOrder dbstatusOrder = this.findById(id);
        if (!dbstatusOrder.getId().equals(statusOrderToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbstatusOrder.setTitle(statusOrderToUpdate.getTitle());
        dbstatusOrder.setStatus(statusOrderToUpdate.getStatus());

        return this.statusOrderRepository.save(dbstatusOrder);
    }

    @Transactional
    public void delete(Long id) {
        StatusOrder dbstatusOrder = this.findById(id);
        this.statusOrderRepository.delete(dbstatusOrder);
    }

}
