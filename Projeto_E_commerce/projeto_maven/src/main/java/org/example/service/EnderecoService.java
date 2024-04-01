package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.BaseModel;
import org.example.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service //indica camada de serviço/negócio
public class EnderecoService implements IService<BaseModel, Integer> {

    @Autowired //injeção de dependência
    private EnderecoRepository enderecoRepository;

    @Override
    @Transactional
    public BaseModel create(BaseModel entity) {
        log.info("Acessando método EnderecoService.create");
        log.debug("Valores recebidos: {}", entity);

        return enderecoRepository.save(entity);
    }

    @Override
    public List<BaseModel> read() {
        log.info("Acessando método EnderecoResource.read()");

        List<BaseModel> lista = enderecoRepository.findAll();

        log.debug("Resultado da consulta: {} registros", lista.size());

        return lista;
    }

    @Override
    public BaseModel read(Integer id) {
        log.info("Acessando método EnderecoResource.read(id)");
        log.debug("Valores recebidos: id = {}", id);
        //Endereco enderecoEncontrado = EnderecoRepository.findById(id);
        log.debug("Resultado da consulta: {} registros", 0);
        return null;
    }

    @Override
    @Transactional
    public BaseModel update(Integer id, BaseModel entity) {
        log.info("Acessando método EnderecoService.update");
        log.debug("Valores recebidos - id: {}, entity: {}", id, entity);


        Optional<BaseModel> enderecoEncontrado = enderecoRepository.findById(id);
        if(enderecoEncontrado.isPresent()){
            enderecoRepository.save(entity);
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
