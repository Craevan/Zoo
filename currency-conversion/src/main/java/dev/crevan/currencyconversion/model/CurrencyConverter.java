package dev.crevan.currencyconversion.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "curencyconverter")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConverter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "currency_from")
    private String currencyFrom;

    @Column(name = "currency_to")
    private String currencyTo;

    @Column(name = "conversion_rate", precision = 5, scale = 3)
    private BigDecimal conversionRate;
}
