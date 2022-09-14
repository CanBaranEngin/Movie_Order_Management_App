package com.MovieOrderManagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private String title;
    private String description;
    private Long length;
    private Double rentalPrice;
    private String releaseYear;
}
