package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "banhotosa")
@Entity(name = "banhotosa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BanhoTosa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime data;
    private String cep;
    private String telefone;
    private String porte;
    private String nomeTutor;

}
