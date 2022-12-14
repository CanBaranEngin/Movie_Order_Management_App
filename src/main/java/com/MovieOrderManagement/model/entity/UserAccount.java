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
    @OneToOne
    private User user;
}
