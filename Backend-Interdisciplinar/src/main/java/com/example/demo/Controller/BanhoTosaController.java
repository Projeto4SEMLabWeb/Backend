package com.example.demo.Controller;

import com.example.demo.Model.BanhoTosa;
import com.example.demo.Repository.BanhoTosaRepository;
import com.example.demo.Service.BanhoTosaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agenda")
public class BanhoTosaController {

    @Autowired
    BanhoTosaService service;

    @GetMapping()
    public List<BanhoTosa> getAll(){
       return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BanhoTosa> getById(@PathVariable Long id){
        BanhoTosa banhoTosa = new BanhoTosa();
        banhoTosa.setId(id);
        return service.findById(banhoTosa);
    }
    @PostMapping()
    public ResponseEntity<BanhoTosa> create(@RequestBody BanhoTosa banhoTosa){
        return service.create(banhoTosa);
    }

    @PutMapping()
    public ResponseEntity<BanhoTosa> update(@RequestBody BanhoTosa banhoTosa){
        return service.update(banhoTosa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BanhoTosa> delete(@PathVariable Long id){
        BanhoTosa banhoTosa = new BanhoTosa();
        banhoTosa.setId(id);
        return service.delete(banhoTosa);
    }

}
