package com.example.demo.Service;

import com.example.demo.Model.Cliente.Tutor;
import com.example.demo.Model.Cliente.Pet;
import com.example.demo.Repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TutorService {


    private final TutorRepository tutorRepository;


    // Obter todos os tutores
    public List<Tutor> getAllTutores() {
        return tutorRepository.findAll();
    }

    // Obter um tutor pelo ID
    public Optional<Tutor> getTutorById(Long id) {
        return tutorRepository.findById(id);
    }

    // Criar ou atualizar um tutor
    public Tutor salvarTutor(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    // Adicionar um pet a um tutor existente
    public Optional<Tutor> addPetToTutor(Long id, Pet pet) {
        return tutorRepository.findById(id).map(tutor -> {
            tutor.getPets().add(pet);
            return tutorRepository.save(tutor);
        });
    }

    public void deleteTutor(Long id) {
        tutorRepository.deleteById(id);
    }
}
