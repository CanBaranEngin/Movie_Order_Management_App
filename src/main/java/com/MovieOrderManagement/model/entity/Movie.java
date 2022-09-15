package com.MovieOrderManagement.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Movie")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Long length;
    private Double rentalPrice;
    private String releaseYear;
}
