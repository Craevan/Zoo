package dev.crevan.rentfare.service;

import dev.crevan.rentfare.model.CurrencyConversionVO;
import dev.crevan.rentfare.model.RentFare;
import dev.crevan.rentfare.repository.RentFareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RentFareService {

    private final RentFareRepository rentFareRepository;

    private final RestTemplate restTemplate;

    @Value("${base.currency}")
    private String baseCurrency;

    public RentFare getRentFareByAnimal(final String animal) {
        return rentFareRepository.findFirstByAnimal(animal);
    }

    public BigDecimal getConversion(final String toCurrency) {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> urlPathVariables = new HashMap<>();
        urlPathVariables.put("from", baseCurrency);
        urlPathVariables.put("to", toCurrency);
        ResponseEntity<CurrencyConversionVO> responseEntity = restTemplate.getForEntity(
                "http://localhost:7101/currency/from/{from}/to/{to}", CurrencyConversionVO.class, urlPathVariables
        );
        CurrencyConversionVO converter = responseEntity.getBody();
        return converter.getConversionRate();
    }
}
