
package com.Reto.Reto3.Controller;

import com.Reto.Reto3.Services.AdminService;
import com.Reto.Reto3.model.Admin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author puchungos
 */
@RestController
@RequestMapping("api/Admin")
public class AdminControler {
    
    @Autowired
    private AdminService adminService;
    
    
    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
        
                
    }
    @PostMapping("/save")
    public Admin save(@RequestBody Admin admin){
        return adminService.save(admin);
    }
    
    
}
