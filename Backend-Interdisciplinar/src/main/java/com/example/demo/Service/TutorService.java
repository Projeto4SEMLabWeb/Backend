package com.example.demo.Service;

import com.example.demo.Model.Cliente.Tutor;
import com.example.demo.Model.Cliente.Pet;
import com.example.demo.Repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TutorService {


    private final TutorRepository tutorRepository;


    // Obter todos os tutores
    public List<Tutor> listar() {
        return tutorRepository.findAll();
    }

    // Obter um tutor pelo ID
    public Optional<Tutor> getTutorById(Long id) {
        return tutorRepository.findById(id);
    }

    // Criar ou atualizar um tutor
    public Tutor salvar(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public Tutor atualizar(Long idTutor, Tutor novoTutor) throws Exception {
        Optional<Tutor> tutorExistenteOpt = tutorRepository.findById(idTutor);
        if (tutorExistenteOpt.isPresent()) {
            Tutor tutorExistente = tutorExistenteOpt.get();

            // Atualizando as informações do tutor
            tutorExistente.setNomeTutor(novoTutor.getNomeTutor());
            tutorExistente.setTelefoneTutor(novoTutor.getTelefoneTutor());
            tutorExistente.setCep(novoTutor.getCep());
            tutorExistente.setLogradouro(novoTutor.getLogradouro());
            tutorExistente.setBairro(novoTutor.getBairro());
            tutorExistente.setCidade(novoTutor.getCidade());
            tutorExistente.setEstado(novoTutor.getEstado());
            tutorExistente.setComplemento(novoTutor.getComplemento());

            // Salva o tutor atualizado
            return tutorRepository.save(tutorExistente);
        } else {
            throw new Exception("Tutor não encontrado");
        }
    }



    // Adicionar um pet a um tutor existente
    public Optional<Tutor> addPetToTutor(Long id, Pet pet) {
        Optional<Tutor> optionalTutor = getTutorById(id);
        if (optionalTutor.isPresent()) {
            Tutor tutor = optionalTutor.get();
            pet.setTutor(tutor);
            tutor.getPets().add(pet);
            salvar(tutor);
            return Optional.of(tutor);
        }
        return Optional.empty();
    }

    // Atualizar pets de um tutor
    public Optional<Tutor> updateTutorPets(Long tutorId, List<Pet> novosPets) {
        Optional<Tutor> optionalTutor = getTutorById(tutorId);
        if (optionalTutor.isPresent()) {
            Tutor tutor = optionalTutor.get();
            tutor.getPets().clear(); // Limpa os pets existentes, se necessário
            tutor.getPets().addAll(novosPets); // Adiciona novos pets
            salvar(tutor);
            return Optional.of(tutor);
        }
        return Optional.empty();
    }

    public void deleteTutor(Long id) {
        tutorRepository.deleteById(id);
    }
}
