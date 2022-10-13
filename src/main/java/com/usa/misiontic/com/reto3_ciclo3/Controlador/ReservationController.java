package com.usa.misiontic.com.reto3_ciclo3.Controlador;

import com.usa.misiontic.com.reto3_ciclo3.Modelo.Reservation;
import com.usa.misiontic.com.reto3_ciclo3.Servicio.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }
    @PostMapping("/save")
    public Reservation save(@RequestBody Reservation r){
        return reservationService.save(r);
    }
}
