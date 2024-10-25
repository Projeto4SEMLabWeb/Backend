package com.example.demo.Service;

import com.example.demo.Model.Cliente.Tutor;
import com.example.demo.Model.Cliente.Pet;
import com.example.demo.Repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    // Obter todos os tutores
    public List<Tutor> getAllTutores() {
        return tutorRepository.findAll();
    }

    // Obter um tutor pelo ID
    public Tutor getTutorById(int id) {
        return tutorRepository.findById(id).orElse(null);
    }

    // Criar um novo tutor
    public Tutor createTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    // Adicionar um pet a um tutor existente
    public Tutor addPetToTutor(int id, Pet pet) {
        Tutor tutor = tutorRepository.findById(id).orElse(null);
        if (tutor != null) {
            tutor.getPets().add(pet);
            return tutorRepository.save(tutor);
        }
        return null;
    }
}
