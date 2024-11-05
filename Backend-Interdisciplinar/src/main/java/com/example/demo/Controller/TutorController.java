package com.example.demo.Controller;

import com.example.demo.Model.Cliente.Pet;
import com.example.demo.Model.Cliente.Tutor;
import com.example.demo.Service.PetService;
import com.example.demo.Service.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutores")
@RequiredArgsConstructor
public class TutorController {

    private final TutorService tutorService;
    private final PetService petService;


    // LISTAR TODOS OS CLIENTES
    @GetMapping
    public List<Tutor> listar() {
        return tutorService.listar();
    }

    // LISTAR TUTOR PELO ID
    @GetMapping("/{id}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable Long id) {
        Optional<Tutor> tutor = tutorService.getTutorById(id);
        return tutor.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // CADASTRAR TUTOR
    @PostMapping
    public ResponseEntity<Tutor> createTutor(@RequestBody Tutor tutor) {
        Tutor novoTutor = tutorService.salvar(tutor);
        return ResponseEntity.ok(novoTutor);
    }

    // CADASTRAR PET AO TUTOR
    @PostMapping("/{id}/pets")
    public ResponseEntity<Tutor> addPetToTutor(@PathVariable Long id, @RequestBody Pet pet) {
        Optional<Tutor> optionalTutor = tutorService.getTutorById(id);
        if (optionalTutor.isPresent()) {
            Tutor tutor = optionalTutor.get();
            pet.setTutor(tutor); // Atribuindo o tutor ao pet
            Pet novoPet = petService.salvar(pet);
            return ResponseEntity.ok(tutor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // LISTAR PETS DE UM TUTOR ESPECÍFICO
    @GetMapping("/{id}/pets")
    public ResponseEntity<List<Pet>> getPetsByTutor(@PathVariable Long id) {
        Optional<Tutor> tutor = tutorService.getTutorById(id);
        return tutor.map(t -> ResponseEntity.ok(t.getPets()))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ATUALIZAR CLIENTE
    @PutMapping("/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable Long id, @RequestBody Tutor tutorAtualizado) {
        try {
            Tutor tutorSalvo = tutorService.atualizar(id, tutorAtualizado);
            return ResponseEntity.ok(tutorSalvo);
        } catch (Exception e) {
            // Retorna 404 se o tutor não for encontrado
            return ResponseEntity.notFound().build();
        }
    }
 
    // EXCLUIR TUTOR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id) {
        Optional<Tutor> tutor = tutorService.getTutorById(id);
        if (tutor.isPresent()) {
            // O JPA irá cuidar da exclusão dos pets associados devido ao orphanRemoval = true
            tutorService.deleteTutor(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
