package com.example.demo.Controller;

import com.example.demo.Model.Cliente.Tutor;
import com.example.demo.Model.Cliente.Pet;
import com.example.demo.Service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    // Endpoint para listar todos os tutores
    @GetMapping
    public List<Tutor> getAllTutores() {
        return tutorService.getAllTutores();
    }

    // Endpoint para obter um tutor específico pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Tutor> getTutorById(@PathVariable int id) {
        Tutor tutor = tutorService.getTutorById(id);
        if (tutor != null) {
            return ResponseEntity.ok(tutor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para criar um novo tutor com pets
    @PostMapping
    public Tutor createTutor(@RequestBody Tutor tutor) {
        return tutorService.createTutor(tutor);
    }

    // Endpoint para adicionar um pet a um tutor existente
    @PostMapping("/{id}/pets")
    public ResponseEntity<Tutor> addPetToTutor(@PathVariable int id, @RequestBody Pet pet) {
        Tutor updatedTutor = tutorService.addPetToTutor(id, pet);
        if (updatedTutor != null) {
            return ResponseEntity.ok(updatedTutor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint para obter todos os pets de um tutor específico
    @GetMapping("/{id}/pets")
    public ResponseEntity<List<Pet>> getPetsByTutor(@PathVariable int id) {
        Tutor tutor = tutorService.getTutorById(id);
        if (tutor != null) {
            return ResponseEntity.ok(tutor.getPets());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
