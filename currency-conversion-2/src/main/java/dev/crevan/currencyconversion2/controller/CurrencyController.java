package dev.crevan.currencyconversion2.controller;

import dev.crevan.currencyconversion2.model.CurrencyConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyConverter convertCurrency(@PathVariable final String from, @PathVariable final String to) {
        return new CurrencyConverter(1L, from, to, BigDecimal.valueOf(2L));
    }
}
