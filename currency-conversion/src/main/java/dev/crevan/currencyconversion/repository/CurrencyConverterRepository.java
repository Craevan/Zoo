package dev.crevan.currencyconversion.repository;

import dev.crevan.currencyconversion.model.CurrencyConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyConverterRepository extends JpaRepository<CurrencyConverter, Long> {

    CurrencyConverter findFirstByCurrencyFromAndCurrencyTo(final String from, final String to);
}
