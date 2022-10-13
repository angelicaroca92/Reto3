package com.usa.misiontic.com.reto3_ciclo3.Servicio;

import com.usa.misiontic.com.reto3_ciclo3.Modelo.Admin;
import com.usa.misiontic.com.reto3_ciclo3.Repositorio.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> admin1 = adminRepository.getAdmin(admin.getIdAdmin());
            if (admin1.isPresent()) {
                return admin;
            } else {
                return adminRepository.save(admin);
            }

        }

    }
    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null) {
            Optional<Admin> admin1= adminRepository.getAdmin(admin.getIdAdmin());
            if (admin1.isPresent()){
                if (admin.getPassword()!=null){
                    admin1.get().setPassword(admin.getPassword());
                }
                if (admin.getName()!=null){
                    admin1.get().setName(admin.getName());
                }
                return adminRepository.save(admin1.get());
            }
        }
        return admin;
    }
    public boolean delete (int id){
        boolean flag=false;
        Optional<Admin> admin = adminRepository.getAdmin(id);
        if(admin.isPresent()){
            adminRepository.delete(admin.get());
            flag=true;
        }
        return flag;
    }


}



