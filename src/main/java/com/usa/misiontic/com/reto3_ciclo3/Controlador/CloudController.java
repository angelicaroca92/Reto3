package com.usa.misiontic.com.reto3_ciclo3.Controlador;


import com.usa.misiontic.com.reto3_ciclo3.Modelo.Cloud;
import com.usa.misiontic.com.reto3_ciclo3.Servicio.CloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cloud")
public class CloudController {

    @Autowired
    private CloudService cloudService;

    @GetMapping("/all")
    public List<Cloud>getAll(){
        return cloudService.getAll();
    }

    @PostMapping("/save")
    public Cloud save(@RequestBody Cloud clo){
        return cloudService.save(clo);
    }


}

