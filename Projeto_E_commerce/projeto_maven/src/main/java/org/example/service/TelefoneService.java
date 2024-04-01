package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.BaseModel;
import org.example.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service //indica camada de serviço/negócio
public class TelefoneService implements IService<BaseModel, Integer> {

    @Autowired //injeção de dependência
    private TelefoneRepository telefoneRepository;

    @Override
    @Transactional
    public BaseModel create(BaseModel entity) {
        log.info("Acessando método TelefoneService.create");
        log.debug("Valores recebidos: {}", entity);

        return telefoneRepository.save(entity);
    }

    @Override
    public List<BaseModel> read() {
        log.info("Acessando método TelefoneResource.read()");

        List<BaseModel> lista = telefoneRepository.findAll();

        log.debug("Resultado da consulta: {} registros", lista.size());

        return lista;
    }

    @Override
    public BaseModel read(Integer id) {
        log.info("Acessando método TelefoneResource.read(id)");
        log.debug("Valores recebidos: id = {}", id);
        //Telefone telefoneEncontrado = TelefoneRepository.findById(id);
        log.debug("Resultado da consulta: {} registros", 0);
        return null;
    }

    @Override
    @Transactional
    public BaseModel update(Integer id, BaseModel entity) {
        log.info("Acessando método TelefoneService.update");
        log.debug("Valores recebidos - id: {}, entity: {}", id, entity);


        Optional<BaseModel> telefoneEncontrado = telefoneRepository.findById(id);
        if(telefoneEncontrado.isPresent()){
            telefoneRepository.save(entity);
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
