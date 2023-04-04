package com.ecommerce.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class UserTracker {

	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    
    @Column(unique = true)
    private String email;
    
}
