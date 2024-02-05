package dev.crevan.rentservice.service;

import dev.crevan.rentservice.model.Rent;
import dev.crevan.rentservice.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {

    @Value("${animal.disabled}")
    private String animalDisabled;

    private final RentRepository rentRepository;

    @Override
    public List<Rent> getRentsByAnimal(final String animal) {
        List<Rent> rents = rentRepository.findRentsByAnimal(animal);
        if (!CollectionUtils.isEmpty(rents)) {
            rents = rents.stream()
                    .filter(flight -> !animalDisabled.equals(flight.getAnimal()))
                    .toList();
        }

        return rents;
    }
}
