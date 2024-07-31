package com.api.java.api_products_2826505.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;


import com.api.java.api_products_2826505.entities.Product;
import com.api.java.api_products_2826505.repositories.ProductRepository;

@Service
public class ProductService {

    //dependencia importanto de Autowired
    @Autowired
    private ProductRepository repository;

    //meotods 
    //Read All
     public List<Product> FindAll() 
    {
        return (List<Product>) 
            repository.findAll();
    }


    //read by id 
    public Product FindById(Long id) 
    {
        return repository.findById(id) 
            .get();
    }

    //insertar:
    public Product create(Product productoAGrabar) 
    {
        return repository.save(productoAGrabar);
    }

    //eliminar
    @PostMapping("/borrarporid")
    public Product deleteProduct(@RequestBody Long id)
    {
        //seleccionar el producto por id
        Product pBorrar = this.FindById(id);
        //borrar
        repository.delete(pBorrar);
        return pBorrar;
    }
    
    //actualizar
    public Product actualizar(Long id, Product pUpdate)
    {
        //1.Encontrar el producto actualizar 
        Product p = this.FindById(id);
        //2. Actualizar atributos del payload
        p.setName(pUpdate.getName());
        p.setDescription(pUpdate.getDescription());
        p.setPrice(pUpdate.getPrice());
        //3. grabar cambios 
        return repository.save(p);


    }
 
      
}
