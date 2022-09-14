package com.MovieOrderManagement.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "UserAccount")
@Data
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double accountBalance;
    private Long userCredit=0L;
    @OneToOne
    private User user;
}
