package org.example.rest;

import org.example.model.Cliente;
import org.example.model.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController //com essa notation a classe ja sabe que e um controller e não e precisa fazer o body separado
@RequestMapping("/api/clientes") //mapeia a url base dentro da controller
@CrossOrigin("http://localhost:4200")
public class ClienteController {
    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping//mapeia o body com o front post
    @ResponseStatus(HttpStatus.CREATED) //retorna o status da do post
    public Cliente salvar(@RequestBody @Valid Cliente cliente) {
        return repository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente getByIdCliente(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //retorna o status da do post
    public void deleteCliente(@PathVariable @Valid Integer id) {
        repository
                .findById(id)
                .map(cliente -> {
                    repository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
        //ou pode usar repository.deleteById(id);
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable @Valid Integer id, @RequestBody Cliente clienteAtualizado){
        repository
                .findById(id)
                .map(Cliente -> {
                    Cliente.setNome(clienteAtualizado.getNome());
                    Cliente.setCpf(clienteAtualizado.getCpf());
                    return repository.save(clienteAtualizado);//se retornar null cai no throw
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }
}
