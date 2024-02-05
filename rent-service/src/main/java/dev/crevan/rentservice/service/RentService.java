package dev.crevan.rentservice.service;

import dev.crevan.rentservice.model.Rent;

import java.util.List;

public interface RentService {

    List<Rent> getRentsByAnimal(final String animal);
}
