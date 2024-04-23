package com.enviro.assesment.grad001.arnoldmasutha.controller;

import com.enviro.assesment.grad001.arnoldmasutha.model.RecyclingTip;
import com.enviro.assesment.grad001.arnoldmasutha.service.RecyclingTipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//The @PathVariable annotation is used to extract the ID from the URL path for the GET, PUT, and DELETE methods.
@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipController {

    //inject the recycling service by constructor
    private final RecyclingTipService recyclingTipService;

    @Autowired
    public RecyclingTipController(RecyclingTipService recyclingTipService) {
        this.recyclingTipService = recyclingTipService;
    }

    //get all recycling tips
    @GetMapping
    public ResponseEntity<List<RecyclingTip>> getAllRecyclingTips() {
        List<RecyclingTip> recyclingTips = recyclingTipService.getAllRecyclingTips();
        return ResponseEntity.ok(recyclingTips);
    }

    //get all recycling tips by ID
    @GetMapping("/{id}")
    public ResponseEntity<RecyclingTip> getRecyclingTipById(@PathVariable Long id) {
        RecyclingTip recyclingTip = recyclingTipService.getRecyclingTipById(id);
        return recyclingTip != null ? ResponseEntity.ok(recyclingTip) : ResponseEntity.notFound().build();
    }

    //create new recycling tip
    @PostMapping
    public ResponseEntity<RecyclingTip> createRecyclingTip(@RequestBody RecyclingTip recyclingTip) {
        RecyclingTip createdRecyclingTip = recyclingTipService.createRecyclingTip(recyclingTip);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRecyclingTip);
    }

    //update recycling tip by id

    @PutMapping("/{id}")
    public ResponseEntity<RecyclingTip> updateRecyclingTip(@PathVariable Long id, @RequestBody RecyclingTip recyclingTip) {
        RecyclingTip updatedRecyclingTip = recyclingTipService.updateRecyclingTip(id, recyclingTip);
        return updatedRecyclingTip != null ? ResponseEntity.ok(updatedRecyclingTip) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecyclingTip(@PathVariable Long id) {
        recyclingTipService.deleteRecyclingTip(id);
        return ResponseEntity.noContent().build();
    }
}
