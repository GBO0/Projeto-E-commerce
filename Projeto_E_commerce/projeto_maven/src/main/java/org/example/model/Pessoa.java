package org.example.model;

import java.time.LocalDateTime;
import java.util.List;

public class Pessoa {
    private Integer id;
    private String nomes;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    public List<Contato> contatos;
}
