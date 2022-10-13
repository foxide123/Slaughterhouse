package com.example.slaughterhouse.repository;

import com.example.slaughterhouse.model.Animal;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class SlaughterhouseRepository {

    private static final Map<Long, Animal> animalMap = new HashMap<>();
    //Create
    public Animal save(Animal animal)
    {
        animalMap.put(animal.getRegistrationNr(), animal);
        return animal;
    }

    //Read
    public Optional<List<Animal>> getAllAnimals()
    {
        List<Animal> animals = new ArrayList<>();
        animalMap.forEach((k,v) -> animals.add(v));
        return Optional.ofNullable(animals);
    }



    public Optional<Animal> getById(Long id)
    {
        return Optional.ofNullable(animalMap.get(id));
    }

    public Optional<List<Animal>> getAnimalsByDate(Date date)
    {
        List<Animal> animals = animalMap.entrySet().stream()
                .filter(a ->
                        !a.getValue().getDate().after(date) &&
                            !a.getValue().getDate().before(date)
                )
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return Optional.ofNullable(animals);
    }

    public Optional<List<Animal>> getAnimalsByOrigin(String origin)
    {
        List<Animal> animals = animalMap.entrySet().stream()
                .filter(a -> a.getValue().getOrigin().equals(origin))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return Optional.ofNullable(animals);
    }

    //Update animal
    public Animal updateAnimal(Animal animal)
    {
        animalMap.put(animal.getRegistrationNr(), animal);
        return animal;
    }
    //Delete animal
    public void deleteAnimal(Long id)
    {
        animalMap.remove(id);
    }

}














