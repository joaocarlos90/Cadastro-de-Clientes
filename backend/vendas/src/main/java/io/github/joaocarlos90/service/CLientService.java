package io.github.joaocarlos90.service;

import io.github.joaocarlos90.model.Client;
import io.github.joaocarlos90.repository.clientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CLientService {

    private clientRepository repository;
    @Autowired
    public CLientService(clientRepository repository){
        this.repository = repository;
    }
    public void saveClient(Client client){
        validateClient(client);
       this.repository.persistir(client);
    }
    public void validateClient(Client client){
        //aplica validação
    }

}
