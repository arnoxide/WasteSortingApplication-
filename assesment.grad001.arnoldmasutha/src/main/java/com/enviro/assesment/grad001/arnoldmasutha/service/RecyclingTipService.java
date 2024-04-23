package com.enviro.assesment.grad001.arnoldmasutha.service;

import com.enviro.assesment.grad001.arnoldmasutha.model.RecyclingTip;
import com.enviro.assesment.grad001.arnoldmasutha.repository.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipService {
    private final RecyclingTipRepository recyclingTipRepository;

    @Autowired
    public RecyclingTipService(RecyclingTipRepository recyclingTipRepository) {
        this.recyclingTipRepository = recyclingTipRepository;
    }

    public List<RecyclingTip> getAllRecyclingTips() {
        return recyclingTipRepository.findAll();
    }

    public RecyclingTip getRecyclingTipById(Long id) {
        return recyclingTipRepository.findById(id).orElse(null);
    }

    public RecyclingTip createRecyclingTip(RecyclingTip recyclingTip) {
        return recyclingTipRepository.save(recyclingTip);
    }

    public RecyclingTip updateRecyclingTip(Long id, RecyclingTip recyclingTip) {
        RecyclingTip existingTip = recyclingTipRepository.findById(id).orElse(null);
        if (existingTip != null) {
            existingTip.setTitle(recyclingTip.getTitle());
            existingTip.setDescription(recyclingTip.getDescription());
            existingTip.setWasteCategory(recyclingTip.getWasteCategory());
            return recyclingTipRepository.save(existingTip);
        }
        return null;
    }

    public void deleteRecyclingTip(Long id) {
        recyclingTipRepository.deleteById(id);
    }
}
