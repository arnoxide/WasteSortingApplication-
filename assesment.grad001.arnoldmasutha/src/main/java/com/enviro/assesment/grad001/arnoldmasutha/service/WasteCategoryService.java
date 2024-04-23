package com.enviro.assesment.grad001.arnoldmasutha.service;

import com.enviro.assesment.grad001.arnoldmasutha.model.WasteCategory;
import com.enviro.assesment.grad001.arnoldmasutha.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {
    private final WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    public WasteCategoryService(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    public WasteCategory getWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id).orElse(null);
    }

    public WasteCategory createWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    public WasteCategory updateWasteCategory(Long id, WasteCategory wasteCategory) {
        WasteCategory existingCategory = wasteCategoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(wasteCategory.getName());
            existingCategory.setDescription(wasteCategory.getDescription());
            return wasteCategoryRepository.save(existingCategory);
        }
        return null;
    }

    public void deleteWasteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}
