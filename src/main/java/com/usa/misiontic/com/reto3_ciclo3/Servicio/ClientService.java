package com.usa.misiontic.com.reto3_ciclo3.Servicio;


import com.usa.misiontic.com.reto3_ciclo3.Modelo.Client;
import com.usa.misiontic.com.reto3_ciclo3.Repositorio.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client c){
        if(c.getIdClient() == null){
            return clientRepository.save(c);
        }else{
            Optional<Client> cl = clientRepository.getClient(c.getIdClient());
            if(cl.isPresent()){
                return c;
            }else{
                return clientRepository.save(c);
            }
        }
    }

    public Client Update(Client c) {
        if (c.getIdClient() != null) {
            Optional<Client> cl = clientRepository.getClient(c.getIdClient());
            if (cl.isPresent()){
                if (c.getName()!=null){
                    cl.get().setName(c.getName());
                }
                if(c.getAge()!=null){
                    cl.get().setAge(c.getAge());
                }
                if(c.getEmail()!=null){
                    cl.get().setEmail(c.getEmail());
                }
                if(c.getPassword()!=null){
                    cl.get().setPassword(c.getPassword());
                }
                clientRepository.save(cl.get());
                return cl.get();
            }else{
                return c;
            }
        } else {
            return c;
        }

    }

    public boolean delete (int id){
        boolean flag=false;
        Optional<Client> c = clientRepository.getClient(id);
        if(c.isPresent()){
            clientRepository.delete(c.get());
            flag=true;
        }
        return flag;
    }
}
