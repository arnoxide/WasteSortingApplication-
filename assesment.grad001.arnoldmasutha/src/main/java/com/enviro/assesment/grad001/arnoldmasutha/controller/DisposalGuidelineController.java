package com.enviro.assesment.grad001.arnoldmasutha.controller;

import com.enviro.assesment.grad001.arnoldmasutha.model.DisposalGuideline;
import com.enviro.assesment.grad001.arnoldmasutha.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//The @PathVariable annotation is used to extract the ID from the URL path for the GET, PUT, and DELETE methods.
@RestController
//api to get all disposal guidelines
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {

    //inject the service to get functionality methods
    private final DisposalGuidelineService disposalGuidelineService;

    @Autowired
    public DisposalGuidelineController(DisposalGuidelineService disposalGuidelineService) {
        this.disposalGuidelineService = disposalGuidelineService;
    }

    //Returns a list of all DisposalGuideline
    @GetMapping
    public ResponseEntity<List<DisposalGuideline>> getAllDisposalGuidelines() {
        List<DisposalGuideline> disposalGuidelines = disposalGuidelineService.getAllDisposalGuidelines();
        return ResponseEntity.ok(disposalGuidelines);
    }

    //Returns a list of all DisposalGuideline by id
    @GetMapping("/{id}")
    public ResponseEntity<DisposalGuideline> getDisposalGuidelineById(@PathVariable Long id) {
        DisposalGuideline disposalGuideline = disposalGuidelineService.getDisposalGuidelineById(id);
        return disposalGuideline != null ? ResponseEntity.ok(disposalGuideline) : ResponseEntity.notFound().build();
    }

    //create a disposalGuidlines
    @PostMapping
    public ResponseEntity<DisposalGuideline> createDisposalGuideline(@RequestBody DisposalGuideline disposalGuideline) {
        DisposalGuideline createdDisposalGuideline = disposalGuidelineService.createDisposalGuideline(disposalGuideline);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDisposalGuideline);
    }

    //update the guideline by id
    @PutMapping("/{id}")
    public ResponseEntity<DisposalGuideline> updateDisposalGuideline(@PathVariable Long id, @RequestBody DisposalGuideline disposalGuideline) {
        DisposalGuideline updatedDisposalGuideline = disposalGuidelineService.updateDisposalGuideline(id, disposalGuideline);
        return updatedDisposalGuideline != null ? ResponseEntity.ok(updatedDisposalGuideline) : ResponseEntity.notFound().build();
    }

    //delete disposal guideline by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisposalGuideline(@PathVariable Long id) {
        disposalGuidelineService.deleteDisposalGuideline(id);
        return ResponseEntity.noContent().build();
    }
}
