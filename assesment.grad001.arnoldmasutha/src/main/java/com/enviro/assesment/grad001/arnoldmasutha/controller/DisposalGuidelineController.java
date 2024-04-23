package com.enviro.assesment.grad001.arnoldmasutha.controller;

import com.enviro.assesment.grad001.arnoldmasutha.model.DisposalGuideline;
import com.enviro.assesment.grad001.arnoldmasutha.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;

    @Autowired
    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.disposalGuidelineService = disposalGuidelineService;
    }

    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllDisposalGuidelines() {
        List<DisposalGuideline> disposalGuidelines = disposalGuidelineService.getAllDisposalGuidelines();
        return ResponseEntity.ok(disposalGuidelines);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long id) {
        DisposalGuideline disposalGuideline = disposalGuidelineService.getDisposalGuidelineById(id);
        return disposalGuideline != null ? ResponseEntity.ok(disposalGuideline) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DisposalGuideline> createDisposalGuideline(@RequestBody DisposalGuideline disposalGuideline) {
        DisposalGuideline createdDisposalGuideline = disposalGuidelineService.createDisposalGuideline(disposalGuideline);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDisposalGuideline);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateDisposalGuideline(@PathVariable Long id, @RequestBody DisposalGuideline disposalGuideline) {
        DisposalGuideline updatedDisposalGuideline = disposalGuidelineService.updateDisposalGuideline(id, disposalGuideline);
        return updatedDisposalGuideline != null ? ResponseEntity.ok(updatedDisposalGuideline) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }
}
