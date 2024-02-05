package dev.crevan.currencyconversion.controller;

import dev.crevan.currencyconversion.model.CurrencyConverter;
import dev.crevan.currencyconversion.repository.CurrencyConverterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyConverterController {

    private final CurrencyConverterRepository currencyConverterRepository;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyConverter currencyConverter(@PathVariable final String from, @PathVariable final String to) {
        return currencyConverterRepository.findFirstByCurrencyFromAndCurrencyTo(from, to);
    }
}
