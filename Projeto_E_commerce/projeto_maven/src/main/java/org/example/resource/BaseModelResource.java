package org.example.resource;

import lombok.extern.slf4j.Slf4j;
import org.example.interfaces.IResource;
import org.example.model.BaseModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //responsável pelo log da classe
@RestController //indica o uso de API
@RequestMapping(value = "api/v1/aluno")
public class BaseModelResource implements IResource<BaseModel, Integer> {

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public BaseModel create(@RequestBody BaseModel entity) {
        log.info("Acessando método BaseModelResource.create");
        log.debug("BaseModelResource | valor recebido: {}", entity);
        return null;
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<BaseModel> read() {
        log.info("Acessando método BaseModelResource.read()");
        log.debug("A consulta retornou {} registros", 0);

        return null;
    }

    /**
     * @GetMapping("/{id}") => @PathVariable
     * GET http://localhost:8081/api/v1/pessoa/{id}
     * @param id
     * @return
     */
    /*@GetMapping(
            name = "/{valor1}/{valor2}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Aluno read(@PathVariable("valor1") Integer id,
                      @PathVariable("valor2") Integer xpto) {
        return null;
    }*/

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public BaseModel read(@PathVariable Integer id) {
        log.info("Acessando método BaseModelResource.get(id)");
        log.debug("Valor de pesquisa: {}", id);
        return null;
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public BaseModel update(@PathVariable Integer id,
                            @RequestBody BaseModel entity) {

        log.info("Acessando método BaseModelResource.update(id,entity)");
        log.debug("Valores recebidos: id - {}, entity: {}", id,entity);

        return null;
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public void delete(@PathVariable Integer id) {
        log.info("Acessando método BaseModelResource.delete");
        log.debug("Valor recebido: id - {}",id);

    }
}
