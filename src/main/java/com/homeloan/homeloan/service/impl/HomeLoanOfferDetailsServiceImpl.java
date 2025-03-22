package com.homeloan.homeloan.service.impl;

import com.homeloan.homeloan.entity.HomeLoanOffer;
import com.homeloan.homeloan.entity.HomeLoanOfferDetails;
import com.homeloan.homeloan.repository.HomeLoanOfferDetailsRepository;
import com.homeloan.homeloan.repository.HomeLoanOfferRepository;
import com.homeloan.homeloan.service.HomeLoanOfferDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeLoanOfferDetailsServiceImpl implements HomeLoanOfferDetailsService {

    private final HomeLoanOfferDetailsRepository homeLoanOfferDetailsRepository;
    private final HomeLoanOfferRepository homeLoanOfferRepository;

    @Autowired
    public HomeLoanOfferDetailsServiceImpl(HomeLoanOfferDetailsRepository homeLoanOfferDetailsRepository, HomeLoanOfferRepository homeLoanOfferRepository) {
        this.homeLoanOfferDetailsRepository = homeLoanOfferDetailsRepository;
        this.homeLoanOfferRepository = homeLoanOfferRepository;
    }

    @Override
    public Optional<HomeLoanOfferDetails> getHomeLoanOfferDetailsById(Long homeLoanOfferDetailsId) {
        return homeLoanOfferDetailsRepository.findById(homeLoanOfferDetailsId);
    }

    @Override
    public List<HomeLoanOffer> getAllHomeLoanOffers() {
        return homeLoanOfferRepository.findAll();
    }
}

