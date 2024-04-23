package com.enviro.assesment.grad001.arnoldmasutha.service;

import com.enviro.assesment.grad001.arnoldmasutha.model.WasteCategory;
import com.enviro.assesment.grad001.arnoldmasutha.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasteCategoryService {

   //This is injected into the service class using constructor injection.
    private final WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    public WasteCategoryService(WasteCategoryRepository wasteCategoryRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    //Returns a list of all waste
    public List<WasteCategory> getAllWasteCategories() {
        return wasteCategoryRepository.findAll();
    }

    //Returns a specific waste category by its ID
    public WasteCategory getWasteCategoryById(Long id) {
        return wasteCategoryRepository.findById(id).orElse(null);
    }

    //Saves a new waste category to the database
    public WasteCategory createWasteCategory(WasteCategory wasteCategory) {
        return wasteCategoryRepository.save(wasteCategory);
    }

    // Updates an existing waste category with the provided data
    public WasteCategory updateWasteCategory(Long id, WasteCategory wasteCategory) {
        WasteCategory existingCategory = wasteCategoryRepository.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(wasteCategory.getName());
            existingCategory.setDescription(wasteCategory.getDescription());
            return wasteCategoryRepository.save(existingCategory);
        }
        return null;
    }

    //Deletes a waste category by its ID
    public void deleteWasteCategory(Long id) {
        wasteCategoryRepository.deleteById(id);
    }
}
