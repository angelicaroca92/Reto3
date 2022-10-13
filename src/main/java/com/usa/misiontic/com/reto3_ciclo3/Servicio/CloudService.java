package com.usa.misiontic.com.reto3_ciclo3.Servicio;


import com.usa.misiontic.com.reto3_ciclo3.Modelo.Cloud;
import com.usa.misiontic.com.reto3_ciclo3.Repositorio.CloudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CloudService {

    @Autowired
    private CloudRepository cloudRepository;

    public List<Cloud> getAll() {
        return cloudRepository.getAll();
    }
    public Optional<Cloud> getCategory(int id) {
        return cloudRepository.getCloud(id);
    }
    public Cloud save(Cloud clo) {
        if (clo.getId() == null) {
            return cloudRepository.save(clo);
        } else {
            Optional<Cloud> clo1 = cloudRepository.getCloud(clo.getId());
            if (clo1.isPresent()) {
                return clo;
            }else{
                return cloudRepository.save(clo);
            }

        }
    }

    public Cloud update (Cloud clo) {
        if (clo.getId() != null) {
            Optional<Cloud> clo1 = cloudRepository.getCloud(clo.getId());
            if (clo1.isPresent()) {
                //}
                //if (clo.getMessages() != null) {
                // clo1.get().setMessages(clo.getMessages());
                //}
                //if (clo.getReservations() != null) {
                // clo1.get().setReservations(clo.getReservations());

                if (clo.getName() != null) {
                    clo1.get().setName(clo.getName());
                }
                if (clo.getBrand() != null) {
                    clo1.get().setBrand(clo.getBrand());
                }
                if (clo.getYear() != null) {
                    clo1.get().setYear(clo.getYear());
                }
                if (clo.getDescription() != null) {
                    clo1.get().setDescription(clo.getDescription());
                }
                if (clo.getCategory() != null) {
                    clo1.get().setCategory(clo.getCategory());

                }
                cloudRepository.save(clo1.get());
                return clo1.get();
            } else {
                return clo;
            }
        } else {
            return clo;
        }
    }

    public boolean delete ( int id){
        boolean flag = false;
        Optional<Cloud> clo = cloudRepository.getCloud(id);
        if (clo.isPresent()) {
            cloudRepository.delete(clo.get());
            flag = true;
        }
        return flag;
    }

}


