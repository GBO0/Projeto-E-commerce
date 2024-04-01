package org.example.resource;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Contato;
import org.example.model.Endereco;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j //escrever logging (logar sout)
@RestController //mapeamento para spring webmvc
@RequestMapping(value = "/api/v1/pessoa") //endereco de acesso da api
public class EnderecoResource {


    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE}
    )
    public Endereco listarEndereco(){
        log.info("Método GET");
        return new Endereco();
    }


    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE}, //recebo
            produces = {MediaType.APPLICATION_JSON_VALUE}//devolvo
    )
    public Endereco qualquercoisa(@RequestBody Endereco endereco){
        log.info("Método POST");
        log.debug("Objeto recebido: {}", endereco);

        return endereco;
    }

}
