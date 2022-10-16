
package com.Reto.Reto3.Services;

import com.Reto.Reto3.Repository.CategoryRepository;
import com.Reto.Reto3.model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private  CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int idCategory){
        return categoryRepository.getCategory(idCategory);
    }
    
    public Category save(Category category){
        if (category.getIdCategory()== null) {
             return categoryRepository.save(category);
           }else{
            Optional<Category>category1= categoryRepository.getCategory(category.getIdCategory());
            if (category1.isPresent()){
               return category;
            }else{
                 return categoryRepository.save(category);
            }
        }
    }
    
    public Category update(Category category){
        if (category.getIdCategory()!=null) {
            Optional<Category> q = categoryRepository.getCategory(category.getIdCategory());
            if (q.isPresent()) {
                if (category.getIdCategory()!=null){
                    q.get().setIdCategory(category.getIdCategory());
                }
                if (category.getName()!=null) {
                    q.get().setName(category.getName());
                    
                }
                if (category.getDescription()!=null) {
                    q.get().setDescription(category.getDescription());
                }
                categoryRepository.save(q.get());
                return q.get();
            }else{
                return category;
            }
            
        }
        return category;
    }
}
