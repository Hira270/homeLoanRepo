package com.homeloan.homeloan.controller;


import com.homeloan.homeloan.entity.HomeLoanOffer;
import com.homeloan.homeloan.entity.HomeLoanOfferDetails;
import com.homeloan.homeloan.exception.HomeLoanOfferNotFoundException;
import com.homeloan.homeloan.exception.IdNotFoundException;
import com.homeloan.homeloan.service.HomeLoanOfferDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/offer")
@Slf4j
public class HomeLoanDashboardController {

    private final HomeLoanOfferDetailsService homeLoanOfferDetailsService;

    public HomeLoanDashboardController(HomeLoanOfferDetailsService homeLoanOfferDetailsService) {
        this.homeLoanOfferDetailsService = homeLoanOfferDetailsService;
    }

    @GetMapping
    public List<HomeLoanOffer> getAllHomeLoanOffers() {
        List<HomeLoanOffer> offerDetails = homeLoanOfferDetailsService.getAllHomeLoanOffers();
        log.debug("Fetching all available home loan offers.");
        if (offerDetails.isEmpty()) {
            throw new HomeLoanOfferNotFoundException("No Home loan offers found:");
        }
        return offerDetails;
    }

    @GetMapping("/{offerId}")
    public Optional<HomeLoanOfferDetails> getHomeLoanOfferDetailsById(@PathVariable Long offerId) {
        log.debug("Fetching home loan offer details for offerId: {}", offerId);
        try {
            return homeLoanOfferDetailsService.getHomeLoanOfferDetailsById(offerId);

        } catch (Exception ex) {
            throw new IdNotFoundException("given OfferId is not available");
        }
    }
}