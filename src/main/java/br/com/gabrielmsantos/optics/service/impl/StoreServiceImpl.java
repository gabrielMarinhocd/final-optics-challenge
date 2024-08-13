package br.com.gabrielmsantos.optics.service.impl;

import br.com.gabrielmsantos.optics.domain.model.Store;
import br.com.gabrielmsantos.optics.domain.repository.StoreRepository;
import br.com.gabrielmsantos.optics.service.StoreService;
import br.com.gabrielmsantos.optics.service.exception.BusinessException;
import br.com.gabrielmsantos.optics.service.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Transactional(readOnly = true)
    public List<Store> findAll() {
        return this.storeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Store findById(Long id) {
        return this.storeRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Store create(Store storeToCreate) {
        ofNullable(storeToCreate).orElseThrow(() -> new BusinessException("Store to create must not be null."));

        return this.storeRepository.save(storeToCreate);
    }

    @Transactional
    public Store update(Long id, Store storeToUpdate) {
        Store dbStore = this.findById(id);
        if (!dbStore.getId().equals(storeToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbStore.setTitle(storeToUpdate.getTitle());
        dbStore.setStatus(storeToUpdate.getStatus());

        return this.storeRepository.save(dbStore);
    }

    @Transactional
    public void delete(Long id) {
        Store dbStore = this.findById(id);
        this.storeRepository.delete(dbStore);
    }

}
