package com.example.demo.Service;

import com.example.demo.Model.Cliente.Pet;
import com.example.demo.Repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public Pet salvar(Pet pet) {
        return petRepository.save(pet);
    }
}
