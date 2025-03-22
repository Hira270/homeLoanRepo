CREATE TABLE loan_request (
  loan_request_id BIGINT PRIMARY KEY,
  request_loan_type VARCHAR(255),
  description VARCHAR(255),
  status VARCHAR(255),
  loan_amount DOUBLE,
  loan_tenure VARCHAR(255),
  loan_interest_rate DOUBLE,
  start_date DATE,
  end_date DATE,
  approved_by VARCHAR(255),
  create_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  create_by TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modify_dt DATE,
  modify_by VARCHAR(255)
) ENGINE=InnoDB;

============
CREATE TABLE applicant (
  applicant_id BIGINT PRIMARY KEY,
  loan_request_id BIGINT,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  gender VARCHAR(255),
  age INT,
  mobile_no BIGINT,
  address VARCHAR(255),
  create_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  create_by VARCHAR(255),
  modify_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modify_by VARCHAR(255),
  FOREIGN KEY (loan_request_id) REFERENCES loan_request(loan_request_id) ON DELETE CASCADE
);
=========
CREATE TABLE nominee (
  nominee_id BIGINT PRIMARY KEY,
  applicant_id BIGINT,
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  gender VARCHAR(255),
  age INT,
  address VARCHAR(255),
  create_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  create_by VARCHAR(255),
  modify_dt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  modify_by VARCHAR(255),
  FOREIGN KEY (applicant_id) REFERENCES applicant(applicant_id) ON DELETE CASCADE
);

==========

CREATE TABLE home_loan_offer (
    home_loan_offer_id BIGINT PRIMARY KEY ,
    loan_amount DOUBLE PRECISION,
    loan_interest_rate DOUBLE PRECISION,
    valid_up_to DATE
);

INSERT INTO home_loan_offer (home_loan_offer_id, loan_amount, loan_interest_rate, loan_type, valid_up_to)
VALUES (1,500000.00, 9.5, 'CAR LOAN','2025-12-31'),
 (2,1000000.00, 9.8, 'TWO WHEELER LOAN','2026-06-30'),
 (3,200000.00, 11.5, 'PERSONAL LOAN','2026-11-30'),
 (4,1000000.00, 8.3, 'HOME LOAN','2027-07-30');

=========

CREATE TABLE home_loan_Offer_details (
  home_loan_Offer_details_id BIGINT PRIMARY KEY,
  home_loan_offer_id BIGINT,
  processing_fee DOUBLE,
  loan_tenure VARCHAR(255),
  loan_interestRate DOUBLE,
  loan_amount DOUBLE,
  start_date DATE,
  end_date DATE,
  FOREIGN KEY (home_loan_offer_id) REFERENCES home_loan_offer(home_loan_offer_id) ON DELETE CASCADE
) ENGINE=InnoDB;

INSERT INTO home_loan_Offer_details (home_loan_Offer_details_id,home_loan_offer_id,processing_fee, loan_tenure, loan_interest_rate, loan_amount, start_date, end_date)
VALUES
(1, 1, 1500.00, '20', 9.5, 250000.00, '2025-03-01', '2045-03-01'),
(2, 2, 2000.00, '25', 9.8, 350000.00, '2025-04-01', '2050-04-01'),
(3, 3, 1200.00, '15', 11.5, 150000.00, '2025-05-01', '2040-05-01'),
(4, 4, 1000.00, '30', 8.3, 500000.00, '2025-06-01', '2055-06-01');

INSERT INTO users (id, username, password, role) VALUES
(1, 'admin', 'admin@123', 'ADMIN'),
(2, 'hitendra', 'hitendra@123', 'USER'),
(3, 'naveen', 'naveen@123', 'USER'),
(4, 'hiramani', 'hiramani@123', 'USER');
