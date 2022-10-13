package com.usa.misiontic.com.reto3_ciclo3.Servicio;

import com.usa.misiontic.com.reto3_ciclo3.Modelo.Category;
import com.usa.misiontic.com.reto3_ciclo3.Repositorio.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }
    public Category save(Category cat) {
        if (cat.getId() == null) {
            return categoryRepository.save(cat);
        } else {
            Optional<Category> cat1 = categoryRepository.getCategory(cat.getId());
            if (cat1.isPresent()) {
                return cat;
            }else{
                return categoryRepository.save(cat);
            }

        }
    }

    public Category update (Category cat) {
        if (cat.getId() != null) {
            Optional<Category> cat1 = categoryRepository.getCategory(cat.getId());
            if (cat1.isPresent()) {
                if (cat.getClouds() != null) {
                    cat1.get().setClouds(cat.getClouds());
                }
                if (cat.getName() != null) {
                    cat1.get().setName(cat.getName());
                }
                if (cat.getDescription() != null) {
                    cat1.get().setDescription(cat.getDescription());
                }

                categoryRepository.save(cat1.get());
                return cat1.get();
            } else {
                return cat;
            }
        } else {
            return cat;
        }
    }
    public boolean delete ( int id){
        boolean flag = false;
        Optional<Category> cat = categoryRepository.getCategory(id);
        if (cat.isPresent()) {
            categoryRepository.delete(cat.get());
            flag = true;
        }
        return flag;
    }

}








