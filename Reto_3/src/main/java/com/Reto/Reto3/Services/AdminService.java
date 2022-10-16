
package com.Reto.Reto3.Services;


import com.Reto.Reto3.model.Admin;
import com.Reto.Reto3.Repository.AdminRepository;
import com.Reto.Reto3.Repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    
    public Optional<Admin> getAdmin(int idAdmin){
        return adminRepository.getAdmin(idAdmin);
    }
    
    public Admin save(Admin admin){
        if (admin.getIdAdmin()== null) {
             return adminRepository.save(admin);
           }else{
            Optional<Admin>admin1= adminRepository.getAdmin(admin.getIdAdmin());
            if (admin1.isEmpty()){
               return admin;
            }else{
               return adminRepository.save(admin);
                  
            }
        }
    }

    
    public Admin update(Admin admin){
        if (admin.getIdAdmin()!=null) {
            Optional<Admin>q=adminRepository.getAdmin(admin.getIdAdmin());
            if (q.isPresent()) {
                if (admin.getName()!=null) {
                    q.get().setName(admin.getName());
                }
                if (admin.getPassword()!=null){
                    q.get().setPassword(admin.getPassword());
                }
                if (admin.getEmail()!=null) {
                    q.get().setEmail(admin.getEmail());
                }
                adminRepository.save(q.get());
                return q.get();
            }else{
                return admin;
            }
            
        }
        return admin;
    }
  }
