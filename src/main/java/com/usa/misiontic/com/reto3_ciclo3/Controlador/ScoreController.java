package com.usa.misiontic.com.reto3_ciclo3.Controlador;

import com.usa.misiontic.com.reto3_ciclo3.Modelo.Score;
import com.usa.misiontic.com.reto3_ciclo3.Servicio.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score){
        return scoreService.save(score);
    }

}
