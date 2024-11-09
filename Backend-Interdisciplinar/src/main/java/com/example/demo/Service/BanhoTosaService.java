package com.example.demo.Service;


import com.example.demo.Model.BanhoTosa;
import com.example.demo.Repository.BanhoTosaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BanhoTosaService {
    @Autowired
    BanhoTosaRepository repository;

    public List<BanhoTosa> getAll(){
        return repository.findAll();
    }
    public ResponseEntity<BanhoTosa> create(BanhoTosa banhoTosa){
        return ResponseEntity.ok().body(repository.save(banhoTosa));
    }
    public ResponseEntity<BanhoTosa> update(BanhoTosa banhoTosa){
        if(repository.existsById(banhoTosa.getId())){
            return ResponseEntity.ok().body(repository.save(banhoTosa));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<BanhoTosa> delete (BanhoTosa banhoTosa){
        repository.delete(banhoTosa);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<BanhoTosa> findById(BanhoTosa banhoTosa){
        Optional<BanhoTosa> banhoTosa1 = repository.findById(banhoTosa.getId());
        if(banhoTosa1.isPresent()){
            return ResponseEntity.ok().body(banhoTosa1.get());
        }
        return ResponseEntity.badRequest().build();
    }

}
