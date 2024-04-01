package org.example.model;

import java.time.LocalDateTime;
import java.util.List;

public class Contato {

    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private Pessoa pessoa;
    private List<Email> emails;
    private List<Endereco> enderecos;
    private List<Telefone> telefones;
}
