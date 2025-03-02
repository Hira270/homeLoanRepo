package com.homeloan.homeloan.service;

import com.homeloan.homeloan.entity.HomeLoanOfferDetails;

import java.util.List;
import java.util.Optional;

public interface HomeLoanOfferDetailsService  {

    Optional<HomeLoanOfferDetails> getHomeLoanOfferDetailsById(Long homeLoanOfferDetailsId);

    List<HomeLoanOfferDetails> getAllHomeLoanOffers();

}
