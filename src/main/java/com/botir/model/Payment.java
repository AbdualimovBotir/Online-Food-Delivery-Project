package com.botir.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Payment {
    private String method; // e.g., "Credit Card", "PayPal"
    private String status; // e.g., "Completed", "Pending"
}
