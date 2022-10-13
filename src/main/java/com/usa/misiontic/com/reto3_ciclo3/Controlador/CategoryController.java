package com.usa.misiontic.com.reto3_ciclo3.Controlador;

import com.usa.misiontic.com.reto3_ciclo3.Modelo.Category;
import com.usa.misiontic.com.reto3_ciclo3.Servicio.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/save")
    public Category save(@RequestBody Category cat){
        return categoryService.save(cat);
    }

}

