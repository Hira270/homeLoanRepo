package com.homeloan.homeloan.repository;

import com.homeloan.homeloan.entity.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRequestRepository extends JpaRepository<LoanRequest, Long> {

}
