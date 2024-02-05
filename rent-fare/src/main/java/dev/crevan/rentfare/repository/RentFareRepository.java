package dev.crevan.rentfare.repository;

import dev.crevan.rentfare.model.RentFare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentFareRepository extends JpaRepository<RentFare, Long> {

    RentFare findFirstByAnimal(final String animal);
}
