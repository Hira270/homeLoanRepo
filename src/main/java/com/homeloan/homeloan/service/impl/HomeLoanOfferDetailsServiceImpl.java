package com.homeloan.homeloan.service.impl;

import com.homeloan.homeloan.entity.HomeLoanOfferDetails;
import com.homeloan.homeloan.repository.HomeLoanOfferDetailsRepository;
import com.homeloan.homeloan.service.HomeLoanOfferDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HomeLoanOfferDetailsServiceImpl implements HomeLoanOfferDetailsService {

    private final HomeLoanOfferDetailsRepository homeLoanOfferDetailsRepository;

    @Autowired
    public HomeLoanOfferDetailsServiceImpl(HomeLoanOfferDetailsRepository homeLoanOfferDetailsRepository) {
        this.homeLoanOfferDetailsRepository = homeLoanOfferDetailsRepository;
    }

    @Override
    public Optional<HomeLoanOfferDetails> getHomeLoanOfferDetailsById(Long homeLoanOfferDetailsId) {
        return homeLoanOfferDetailsRepository.findById(homeLoanOfferDetailsId);
    }

    @Override
    public List<HomeLoanOfferDetails> getAllHomeLoanOffers() {
        return homeLoanOfferDetailsRepository.findAll();
    }
}

