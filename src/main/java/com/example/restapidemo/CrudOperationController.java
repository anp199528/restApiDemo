package com.example.restapidemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/crudOperations")
public class CrudOperationController {

    @Autowired
    private CrudOperationService service;

    // Get all entries
    @GetMapping
    public List<CrudOperation> getAllEntries() {
        return service.getAllEntries();
    }

    // Get an entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<CrudOperation> getEntryById(@PathVariable Integer id) {
        Optional<CrudOperation> entry = service.getEntryById(id);
        return entry.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new entry
    @PostMapping
    public CrudOperation createEntry(@RequestBody CrudOperation entry) {
        return service.saveEntry(entry);
    }

    // Update an entry
    @PutMapping("/{id}")
    public ResponseEntity<CrudOperation> updateEntry(@PathVariable Integer id, @RequestBody CrudOperation entryDetails) {
        Optional<CrudOperation> optionalEntry = service.getEntryById(id);
        if (!optionalEntry.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        CrudOperation entry = optionalEntry.get();
        entry.setName(entryDetails.getName());
        entry.setClassName(entryDetails.getClassName());
        entry.setMarks(entryDetails.getMarks());
        entry.setYear(entryDetails.getYear());
        CrudOperation updatedEntry = service.saveEntry(entry);
        return ResponseEntity.ok(updatedEntry);
    }

    // Delete an entry
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Integer id) {
        Optional<CrudOperation> optionalEntry = service.getEntryById(id);
        if (!optionalEntry.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteEntry(id);
        return ResponseEntity.noContent().build();
    }
}
