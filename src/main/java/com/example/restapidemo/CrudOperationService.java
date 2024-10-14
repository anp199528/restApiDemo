package com.example.restapidemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudOperationService {

    @Autowired
    private CrudOperationRepository repository;

    public List<CrudOperation> getAllEntries() {
        return repository.findAll();
    }

    public Optional<CrudOperation> getEntryById(Integer id) {
        return repository.findById(id);
    }

    public CrudOperation saveEntry(CrudOperation entry) {
        return repository.save(entry);
    }

    public void deleteEntry(Integer id) {
        repository.deleteById(id);
    }
}
