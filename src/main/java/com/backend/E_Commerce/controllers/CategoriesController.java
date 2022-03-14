package com.backend.E_Commerce.controllers;

import com.backend.E_Commerce.entities.Categories;
import com.backend.E_Commerce.repositories.CategoriesRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    @Autowired
    private CategoriesRepo categoriesRepo;    

    @GetMapping
    List<Categories> getCategories(){
        return categoriesRepo.findAll();
    }

    @GetMapping("/{category_id}")
    Categories getCategoryById(@PathVariable Integer category_id){
        return categoriesRepo.getById(category_id);
    }

    @PostMapping()
    Categories createCategory(@RequestBody Categories category){
        return categoriesRepo.save(category);
    }

    @PutMapping("/{category_id}")
    Categories updCategory(@RequestBody Categories category, @PathVariable Integer category_id){
        Optional<Categories> optionalCategory = categoriesRepo.findById(category_id);
        if(optionalCategory.isPresent()){
            category.setCategoryId(category_id);
            return categoriesRepo.save(category);
        }
        throw new ResponseStatusException(HttpStatus.FOUND, "Requested resource does not exists");
    }

    @DeleteMapping("/{category_id}")
    HttpStatus deleteCategory(@PathVariable Integer category_id){
        Optional<Categories> optionalCategory = categoriesRepo.findById(category_id);
        if(optionalCategory.isPresent()){
            categoriesRepo.deleteById(category_id);
            return HttpStatus.OK;
        }
        throw new ResponseStatusException(HttpStatus.FOUND, "Requested resource does not exists");
    }
}
