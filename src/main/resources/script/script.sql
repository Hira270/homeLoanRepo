CREATE TABLE loan_request (
  loan_request_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  request_loanType VARCHAR(255),
  description VARCHAR(255),
  status VARCHAR(255),
  loan_amount DOUBLE,
  loan_tenure VARCHAR(255),
  loan_interestRate DOUBLE,
  start_date DATE,
  end_date DATE,
  approved_by VARCHAR(255),
  create_dt DATE,
  create_by VARCHAR(255),
  modify_dt DATE,
  modify_by VARCHAR(255)
) ENGINE=InnoDB;

============
CREATE TABLE applicant (
  applicant_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  loan_request_id BIGINT,
  nominee_id INT,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  gender VARCHAR(255),
  age INT,
  mobile_no BIGINT,
  address VARCHAR(255),
  create_dt DATE,
  create_by VARCHAR(255),
  modify_dt DATE,
  modify_by VARCHAR(255),
  FOREIGN KEY (loan_request_id) REFERENCES loan_request(loan_request_id) ON DELETE CASCADE
);
=========
CREATE TABLE nominee_Details (
  nominee_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  applicant_id BIGINT,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  gender VARCHAR(255),
  age INT,
  address VARCHAR(255),
  create_dt DATE,
  create_by VARCHAR(255),
  modify_dt DATE,
  modify_by VARCHAR(255),
  FOREIGN KEY (applicant_id) REFERENCES applicant(applicant_id) ON DELETE CASCADE
);

=====
CREATE TABLE loan_Details (
  loan_details_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  loan_type VARCHAR(255),
  loan_tenure VARCHAR(255),
  loan_amount DOUBLE
) ENGINE=InnoDB;

==========

CREATE TABLE home_loan_Offer_details (
  home_loan_Offer_details_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  processing_fee DOUBLE,
  loan_tenure VARCHAR(255),
  loan_interestRate DOUBLE,
  loan_amount DOUBLE,
  start_date DATE,
  end_date DATE
) ENGINE=InnoDB;

INSERT INTO home_loan_Offer_details (processing_fee, loan_tenure, loan_interestRate, loan_amount, start_date, end_date)
VALUES
(1500.00, '20 years', 4.5, 250000.00, '2025-03-01', '2045-03-01'),
(2000.00, '25 years', 5.0, 350000.00, '2025-04-01', '2050-04-01'),
(1200.00, '15 years', 4.2, 150000.00, '2025-05-01', '2040-05-01'),
(1000.00, '30 years', 3.8, 500000.00, '2025-06-01', '2055-06-01'),
(1800.00, '20 years', 4.7, 200000.00, '2025-07-01', '2045-07-01');
