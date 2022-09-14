package com.MovieOrderManagement.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MovieOrder")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;
    @CreationTimestamp
    private Date startDate;
    private String endDatePlanned;
    private String endDateActual;
}
