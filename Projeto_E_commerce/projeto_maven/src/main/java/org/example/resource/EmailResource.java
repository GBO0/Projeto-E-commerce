package org.example.resource;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Contato;
import org.example.model.Email;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j //escrever logging (logar sout)
@RestController //mapeamento para spring webmvc
@RequestMapping(value = "/api/v1/pessoa") //endereco de acesso da api
public class EmailResource {


    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE}
    )
    public Email listarEmail(){
        log.info("Método GET");
        return new Email();
    }


    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE}, //recebo
            produces = {MediaType.APPLICATION_JSON_VALUE}//devolvo
    )
    public Email qualquercoisa(@RequestBody Email email){
        log.info("Método POST");
        log.debug("Objeto recebido: {}", email);

        return email;
    }

}
