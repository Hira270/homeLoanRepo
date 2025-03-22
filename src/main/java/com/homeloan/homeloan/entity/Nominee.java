package com.homeloan.homeloan.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nominee")
public class Nominee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nomineeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "address")
    private String address;

    @Column(name = "create_dt")
    @CreationTimestamp
    private Timestamp createDt;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "modify_dt")
    @CreationTimestamp
    private Timestamp modifyDt;

    @Column(name = "modify_by")
    private String modifyBy;

    @OneToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

}