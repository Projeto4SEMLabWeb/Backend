package com.example.demo.Controller;

import com.example.demo.Model.Cliente.Tutor;
import com.example.demo.Model.Cliente.Pet;
import com.example.demo.Service.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tutores")
@RequiredArgsConstructor
public class TutorController {

    private final TutorService tutorService;

    // Endpoint para listar todos os tutores
    @GetMapping
    public List<Tutor> getAllTutores() {
        return tutorService.getAllTutores();
    }

    // Endpoint para obter um tutor específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable Long id) {
        Optional<Tutor> tutor = tutorService.getTutorById(id);
        return tutor.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para criar um novo tutor com pets
    @PostMapping
    public ResponseEntity<Tutor> createTutor(@RequestBody Tutor tutor) {
        Tutor novoTutor = tutorService.salvarTutor(tutor);
        return ResponseEntity.ok(novoTutor);
    }

    // Endpoint para adicionar um pet a um tutor existente
    @PostMapping("/{id}/pets")
    public ResponseEntity<Tutor> addPetToTutor(@PathVariable Long id, @RequestBody Pet pet) {
        Optional<Tutor> updatedTutor = tutorService.addPetToTutor(id, pet);
        return updatedTutor.map(ResponseEntity::ok)
                           .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para obter todos os pets de um tutor específico
    @GetMapping("/{id}/pets")
    public ResponseEntity<List<Pet>> getPetsByTutor(@PathVariable Long id) {
        Optional<Tutor> tutor = tutorService.getTutorById(id);
        return tutor.map(t -> ResponseEntity.ok(t.getPets()))
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para atualizar um tutor existente
    @PutMapping("/{id}")
    public ResponseEntity<Tutor> updateTutor(@PathVariable Long id, @RequestBody Tutor tutorAtualizado) {
        Optional<Tutor> tutorExistente = tutorService.getTutorById(id);
        if (tutorExistente.isPresent()) {
            tutorAtualizado.setId(id); // Garantindo que o ID do tutor seja o mesmo
            Tutor tutorSalvo = tutorService.salvarTutor(tutorAtualizado);
            return ResponseEntity.ok(tutorSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
    // Endpoint para excluir um tutor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTutor(@PathVariable Long id) {
        Optional<Tutor> tutor = tutorService.getTutorById(id);
        if (tutor.isPresent()) {
            tutorService.deleteTutor(id); // Método que você deve implementar no serviço
            return ResponseEntity.noContent().build(); // Retorna 204 No Content
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
