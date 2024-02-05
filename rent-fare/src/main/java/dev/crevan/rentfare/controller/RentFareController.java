package dev.crevan.rentfare.controller;

import dev.crevan.rentfare.model.RentFare;
import dev.crevan.rentfare.service.RentFareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.MathContext;

@RestController
@RequestMapping("/rent/{animal}/fare/{currency}")
@RequiredArgsConstructor
public class RentFareController {

    private final RentFareService rentFareService;

    @Value("${base.currency}")
    private String baseCurrency;

    @GetMapping
    public RentFare getAnimalFare(@PathVariable final String animal, @PathVariable final String currency) {
        RentFare rentFare = rentFareService.getRentFareByAnimal(animal);
        rentFare.setCurrency(currency);
        if (!baseCurrency.equals(currency)) {
            BigDecimal conversionRate = rentFareService.getConversion(currency);
            BigDecimal convertedFare = rentFare.getRentFare().multiply(conversionRate, MathContext.UNLIMITED);
            rentFare.setRentFare(convertedFare);
        }
        return rentFare;
    }
}
