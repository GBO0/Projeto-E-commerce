package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.BaseModel;
import org.example.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service //indica camada de serviço/negócio
public class PessoaService implements IService<BaseModel, Integer> {

    @Autowired //injeção de dependência
    private PessoaRepository pessoaRepository;

    @Override
    @Transactional
    public BaseModel create(BaseModel entity) {
        log.info("Acessando método pessoaService.create");
        log.debug("Valores recebidos: {}", entity);

        return pessoaRepository.save(entity);
    }

    @Override
    public List<BaseModel> read() {
        log.info("Acessando método PessoaResource.read()");

        List<BaseModel> lista = pessoaRepository.findAll();

        log.debug("Resultado da consulta: {} registros", lista.size());

        return lista;
    }

    @Override
    public BaseModel read(Integer id) {
        log.info("Acessando método PessoaResource.read(id)");
        log.debug("Valores recebidos: id = {}", id);
        //Pessoa pessoaEncontrado = PessoaRepository.findById(id);
        log.debug("Resultado da consulta: {} registros", 0);
        return null;
    }

    @Override
    @Transactional
    public BaseModel update(Integer id, BaseModel entity) {
        log.info("Acessando método pessoaService.update");
        log.debug("Valores recebidos - id: {}, entity: {}", id, entity);


        Optional<BaseModel> pessoaEncontrado = pessoaRepository.findById(id);
        if(pessoaEncontrado.isPresent()){
            pessoaRepository.save(entity);
        }

        return null;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        log.info("Acessando método delete");
        log.info("Valor recebido: {id}", id);

    }
}
