package com.MovieOrderManagement.model.entity;

import com.MovieOrderManagement.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5, max = 25, message = "username length should be between 5 and 25 characters")
    @Column(unique = true,nullable = false)
    private String userName;
    @Column(unique = true,nullable = false)
    private String email;
    @Size(min = 5, message = "Minimum password length: 5 characters")
    @Column(nullable = false)
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserAccount_id",referencedColumnName = "id")
    private UserAccount userAccount;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscription_id",referencedColumnName = "id")
    private Subscription subscription;
    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }


}
