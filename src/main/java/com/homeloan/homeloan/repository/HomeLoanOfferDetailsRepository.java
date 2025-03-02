package com.homeloan.homeloan.repository;

import com.homeloan.homeloan.entity.HomeLoanOfferDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeLoanOfferDetailsRepository extends JpaRepository<HomeLoanOfferDetails, Long> {
}
