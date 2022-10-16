
package com.Reto.Reto3.Services;

import com.Reto.Reto3.Repository.ClientRepository;
import com.Reto.Reto3.model.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClien(int idClient){
        return clientRepository.getClien(idClient);
    }
    
    public Client save(Client client){
        if (client.getIdClient()== null) {
             return clientRepository.save(client);
           }else{
            Optional<Client>client1= clientRepository.getClien(client.getIdClient());
            if (client1.isEmpty()){
                return client;
            }else{
                return clientRepository.save(client);
            }
        }
    }
    
    public Client update(Client client){
        if (client.getIdClient()!=null) {
            Optional<Client>q=clientRepository.getClien(client.getIdClient());
            if (!q.isEmpty()) {
                if (client.getIdClient()!=null){
                    q.get().setIdClient(client.getIdClient());
                }
                if (client.getName()!=null) {
                    q.get().setName(client.getName());
                }
                if (client.getEmail()!=null) {
                    q.get().setEmail(client.getEmail());
                }
                if (client.getPassword()!=null) {
                    q.get().setPassword(client.getPassword());
                }
                if (client.getAge()!=null) {
                    q.get().setAge(client.getAge());
                }
                clientRepository.save(q.get());
                return q.get();
            }else{
                return client;
            }
            
        }
        return client;
    }
   }
