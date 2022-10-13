package com.usa.misiontic.com.reto3_ciclo3.Repositorio;

import com.usa.misiontic.com.reto3_ciclo3.CrudRepository.CloudCrudRepository;
import com.usa.misiontic.com.reto3_ciclo3.Modelo.Cloud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CloudRepository {

    @Autowired
    private CloudCrudRepository cloudCrudRepository;
    public List<Cloud> getAll(){

        return (List<Cloud>) cloudCrudRepository.findAll();
    }

    public Optional<Cloud> getCloud(int id){
        return cloudCrudRepository.findById(id);

    }

    public Cloud save(Cloud clo){
        return cloudCrudRepository.save(clo);

    }

    public void delete(Cloud clo){
        cloudCrudRepository.delete(clo);
    }
}

