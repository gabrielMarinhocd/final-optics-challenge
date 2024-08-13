package br.com.gabrielmsantos.optics.service.impl;

import br.com.gabrielmsantos.optics.domain.model.Custumer;
import br.com.gabrielmsantos.optics.domain.repository.CustumerRepository;
import br.com.gabrielmsantos.optics.service.CustumerService;
import br.com.gabrielmsantos.optics.service.exception.BusinessException;
import br.com.gabrielmsantos.optics.service.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class CustumerServiceImpl implements CustumerService {
    private final CustumerRepository custumerRepository;

    public CustumerServiceImpl(CustumerRepository custumerRepository) {
        this.custumerRepository = custumerRepository;
    }

    @Transactional(readOnly = true)
    public List<Custumer> findAll() {
        return this.custumerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Custumer findById(Long id) {
        return this.custumerRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Custumer create(Custumer custumerToCreate) {
        ofNullable(custumerToCreate).orElseThrow(() -> new BusinessException("Custumer to create must not be null."));

        return this.custumerRepository.save(custumerToCreate);
    }

    @Transactional
    public Custumer update(Long id, Custumer custumerToUpdate) {
        Custumer dbCustumer = this.findById(id);
        if (!dbCustumer.getId().equals(custumerToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbCustumer.setCpf(custumerToUpdate.getCpf());
        dbCustumer.setNome(custumerToUpdate.getNome());
        dbCustumer.setTelefone(custumerToUpdate.getTelefone());
        dbCustumer.setStatus(custumerToUpdate.getStatus());

        return this.custumerRepository.save(dbCustumer);
    }

    @Transactional
    public void delete(Long id) {
        Custumer dbCustumer = this.findById(id);
        this.custumerRepository.delete(dbCustumer);
    }

}
