package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IService;
import org.example.model.BaseModel;
import org.example.repository.BaseModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service //indica camada de serviço/negócio
public class BaseModelService implements IService<BaseModel, Integer> {

    @Autowired //injeção de dependência
    private BaseModelRepository baseModelRepository;

    @Override
    @Transactional
    public BaseModel create(BaseModel entity) {
        log.info("Acessando método BaseModelService.create");
        log.debug("Valores recebidos: {}", entity);

        return baseModelRepository.save(entity);
    }

    @Override
    public List<BaseModel> read() {
        log.info("Acessando método BaseModelResource.read()");

        List<BaseModel> lista = baseModelRepository.findAll();

        log.debug("Resultado da consulta: {} registros", lista.size());

        return lista;
    }

    @Override
    public BaseModel read(Integer id) {
        log.info("Acessando método BaseModelResource.read(id)");
        log.debug("Valores recebidos: id = {}", id);
        //BaseModel basemodelEncontrado = basemodelRepository.findById(id);
        log.debug("Resultado da consulta: {} registros", 0);
        return null;
    }

    @Override
    @Transactional
    public BaseModel update(Integer id, BaseModel entity) {
        log.info("Acessando método BaseModelService.update");
        log.debug("Valores recebidos - id: {}, entity: {}", id, entity);


        Optional<BaseModel> baseModelEncontrado = baseModelRepository.findById(id);
        if(baseModelEncontrado.isPresent()){
            baseModelRepository.save(entity);
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
