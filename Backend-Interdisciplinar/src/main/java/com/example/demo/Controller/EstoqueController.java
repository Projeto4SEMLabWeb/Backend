package com.example.demo.Controller;

import com.example.demo.Model.Estoque;
import com.example.demo.Service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estoque")
public class EstoqueController {

    @Autowired
    EstoqueService service;

    @GetMapping()
    public ResponseEntity<List<Estoque>> getAll(){
      return service.getAll();
    }
    @PostMapping()
    public ResponseEntity<Estoque> create(@RequestBody Estoque estoque){

        return service.create(estoque);
    }
    @PutMapping()
    public ResponseEntity<Estoque> update(@RequestBody Estoque estoque){
        return service.update(estoque);
    }
    @DeleteMapping("/{id}")
    public HttpStatusCode delete(@PathVariable Long id){
        Estoque estoque = new Estoque();
        estoque.setId(id);
        return service.delete(estoque).getStatusCode();
    }
}
