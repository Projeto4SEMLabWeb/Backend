package com.example.demo.Service;

import com.example.demo.Model.Estoque;

import com.example.demo.Repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;

    public ResponseEntity<Estoque> create(Estoque estoque){
        return ResponseEntity.ok().body(estoqueRepository.save(estoque));
    }
    public ResponseEntity<List<Estoque>> getAll(){
        return ResponseEntity.ok().body(estoqueRepository.findAll());
    }
    public ResponseEntity<Estoque> delete(Estoque estoque){
        estoqueRepository.deleteById(estoque.getId());
        return ResponseEntity.ok().build();
    }
    public ResponseEntity<Estoque> update(Estoque estoque){
        Optional<Estoque> optionalEstoque = estoqueRepository.findById(estoque.getId());
        if(optionalEstoque.isPresent()){
            estoqueRepository.save(estoque);
            return ResponseEntity.ok().build();
        }
            return ResponseEntity.notFound().build();
    }


}
