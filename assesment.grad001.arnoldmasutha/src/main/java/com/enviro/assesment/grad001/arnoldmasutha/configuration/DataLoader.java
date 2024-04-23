package com.enviro.assesment.grad001.arnoldmasutha.configuration;


import com.enviro.assesment.grad001.arnoldmasutha.model.DisposalGuideline;
import com.enviro.assesment.grad001.arnoldmasutha.model.RecyclingTip;
import com.enviro.assesment.grad001.arnoldmasutha.model.WasteCategory;
import com.enviro.assesment.grad001.arnoldmasutha.repository.DisposalGuidelineRepository;
import com.enviro.assesment.grad001.arnoldmasutha.repository.RecyclingTipRepository;
import com.enviro.assesment.grad001.arnoldmasutha.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final WasteCategoryRepository wasteCategoryRepository;
    private final DisposalGuidelineRepository disposalGuidelineRepository;
    private final RecyclingTipRepository recyclingTipRepository;

    // Constructors
    @Autowired
    public DataLoader(WasteCategoryRepository wasteCategoryRepository,
                      DisposalGuidelineRepository disposalGuidelineRepository,
                      RecyclingTipRepository recyclingTipRepository) {
        this.wasteCategoryRepository = wasteCategoryRepository;
        this.disposalGuidelineRepository = disposalGuidelineRepository;
        this.recyclingTipRepository = recyclingTipRepository;
    }

    // Default constructor (required by Spring)
    public DataLoader() {
        this(null, null, null);
    }

    @Override
    public void run(String... args) throws Exception {
        // Load waste categories
        WasteCategory plastics = new WasteCategory("Plastics", "Waste made from plastic materials");
        WasteCategory paper = new WasteCategory("Paper", "Waste made from paper materials");
        WasteCategory glass = new WasteCategory("Glass", "Waste made from glass materials");

        wasteCategoryRepository.save(plastics);
        wasteCategoryRepository.save(paper);
        wasteCategoryRepository.save(glass);

        // Load disposal guidelines
        DisposalGuideline plasticBottleDisposal = new DisposalGuideline("Plastic Bottle Disposal", "Rinse and remove caps before recycling plastic bottles.", plastics);
        DisposalGuideline paperRecycling = new DisposalGuideline("Paper Recycling", "Remove any non-paper materials before recycling paper.", paper);
        DisposalGuideline glassRecycling = new DisposalGuideline("Glass Recycling", "Remove any non-glass materials before recycling glass items.", glass);

        disposalGuidelineRepository.save(plasticBottleDisposal);
        disposalGuidelineRepository.save(paperRecycling);
        disposalGuidelineRepository.save(glassRecycling);

        // Load recycling tips
        RecyclingTip plasticBagTip = new RecyclingTip("Plastic Bag Recycling", "Take plastic bags to designated recycling centers or drop-off locations.", plastics);
        RecyclingTip newspaperTip = new RecyclingTip("Newspaper Recycling", "Bundle newspapers and magazines for recycling pickup or drop-off.", paper);
        RecyclingTip bottleTip = new RecyclingTip("Glass Bottle Recycling", "Separate glass bottles by color for efficient recycling.", glass);

        recyclingTipRepository.save(plasticBagTip);
        recyclingTipRepository.save(newspaperTip);
        recyclingTipRepository.save(bottleTip);
    }
}
