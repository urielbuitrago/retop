/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto.Reto3.model;

import com.Reto.Reto3.model.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Category")
public class Category implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private  Integer idCategory;
    private String name;
    private String description;
    
    @OneToMany(mappedBy = "Category", cascade = (CascadeType.PERSIST))
    @JsonIgnoreProperties("Category")
    private List<Motorbike> listmotorbikes;

    public Category(List<Motorbike> listmotorbikes) {
        this.listmotorbikes = listmotorbikes;
    }
    
    
    
    
    public Category() {
    }

    
    

       public Category(Integer idCategory, String name, String description) {
        this.idCategory = idCategory;
        this.name = name;
        this.description = description;
    }
    
   
    

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Motorbike> getListmotorbikes() {
        return listmotorbikes;
    }

    public Integer getIdCategory() {
        return idCategory;
    }



   


    
    
    
}
