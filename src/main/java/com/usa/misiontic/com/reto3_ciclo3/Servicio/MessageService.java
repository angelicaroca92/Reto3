package com.usa.misiontic.com.reto3_ciclo3.Servicio;

import com.usa.misiontic.com.reto3_ciclo3.Modelo.Message;
import com.usa.misiontic.com.reto3_ciclo3.Repositorio.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        }else {
            Optional<Message> me = messageRepository.getMessage(m.getIdMessage());
            if (me.isPresent()) {
                return m;
            } else {
                return messageRepository.save(m);
            }
        }
    }

    public Message update(Message m){
        if(m.getIdMessage() !=null){
            Optional<Message> me = messageRepository.getMessage(m.getIdMessage());
            if (me.isPresent()){
                if(m.getClient()!=null){
                    me.get().setClient(m.getClient());
                }
                if(m.getMessageText()!=null){
                    me.get().setMessageText(m.getMessageText());
                }
                messageRepository.save(me.get());
                return me.get();
            }
            else{
                return m;
            }
        }else {
            return m;
        }

    }
}
