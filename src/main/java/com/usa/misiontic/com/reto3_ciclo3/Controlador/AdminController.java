package com.usa.misiontic.com.reto3_ciclo3.Controlador;


import com.usa.misiontic.com.reto3_ciclo3.Modelo.Admin;
import com.usa.misiontic.com.reto3_ciclo3.Servicio.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

}
