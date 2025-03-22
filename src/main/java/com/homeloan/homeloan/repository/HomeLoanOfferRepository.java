package com.homeloan.homeloan.repository;

import com.homeloan.homeloan.entity.HomeLoanOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeLoanOfferRepository extends JpaRepository<HomeLoanOffer, Long> {
}
