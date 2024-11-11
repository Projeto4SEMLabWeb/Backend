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
            return ResponseEntity.ok().body(estoqueRepository.save(estoque));
        }
            return ResponseEntity.notFound().build();
    }
    public ResponseEntity<Estoque> findById(Estoque estoque){
        Optional<Estoque> estoque1 = estoqueRepository.findById(estoque.getId());
        if(estoque1.isPresent()){
            return ResponseEntity.ok().body(estoque1.get());
        }
        return  ResponseEntity.notFound().build();
    }


}
