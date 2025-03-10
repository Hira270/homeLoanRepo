package com.homeloan.homeloan.controller;


import com.homeloan.homeloan.entity.HomeLoanOfferDetails;
import com.homeloan.homeloan.service.HomeLoanOfferDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loans")
@Slf4j
public class HomeLoanDashboardController {
    @Autowired
    private HomeLoanOfferDetailsService homeLoanOfferDetailsService;

    @GetMapping
    public List<HomeLoanOfferDetails> getAllHomeLoanOffers() {
        return homeLoanOfferDetailsService.getAllHomeLoanOffers();
    }

    @GetMapping("/{offerId}")
    public Optional<HomeLoanOfferDetails> getHomeLoanOfferDetailsById(@PathVariable Long offerId) {

        log.info("this is else part getHomeLoanOfferDetailsById");

        return homeLoanOfferDetailsService.getHomeLoanOfferDetailsById(offerId);
    }

}