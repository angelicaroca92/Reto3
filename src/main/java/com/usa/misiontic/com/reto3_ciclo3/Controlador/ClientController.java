package com.usa.misiontic.com.reto3_ciclo3.Controlador;

import com.usa.misiontic.com.reto3_ciclo3.Modelo.Client;
import com.usa.misiontic.com.reto3_ciclo3.Servicio.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @PostMapping("/save")
    public Client save(@RequestBody Client c){
        return clientService.save(c);
    }
}
