package com.usa.misiontic.com.reto3_ciclo3.Controlador;

import com.usa.misiontic.com.reto3_ciclo3.Modelo.Message;
import com.usa.misiontic.com.reto3_ciclo3.Repositorio.MessageRepository;
import com.usa.misiontic.com.reto3_ciclo3.Servicio.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }

    @PostMapping("/save")
    public Message save(@RequestBody Message m){
        return messageService.save(m);
    }

}
