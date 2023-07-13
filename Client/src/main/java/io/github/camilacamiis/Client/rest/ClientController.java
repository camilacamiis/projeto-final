package io.github.camilacamiis.Client.rest;

import io.github.camilacamiis.Client.model.entity.Client;
import io.github.camilacamiis.Client.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")

public class ClientController {

    private final ClientRepository repository;

    @Autowired
    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client salvar( @RequestBody @Valid Client client){
            return repository.save(client);
    }

    @GetMapping("{id}")
    public Optional<Client> acharporId(@PathVariable Integer id ){
        return Optional.ofNullable(repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado")));


    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id ){
        repository
                .findById(id)
                .map(client -> {
                    repository.delete(client);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));

    }
@PutMapping("{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Client updatedclient ){
        repository
                .findById(id)
            .map(client -> {
               updatedclient.setId(client.getId());
               return repository.save(updatedclient);
            })
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente nao encontrado"));

    }
}
