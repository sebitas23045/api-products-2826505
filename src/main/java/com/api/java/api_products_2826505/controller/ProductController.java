package com.api.java.api_products_2826505.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.java.api_products_2826505.entities.Product;
import com.api.java.api_products_2826505.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;






@RestController
@RequestMapping("/api/products")
public class ProductController {

    //primer endpoint
    //Traer todos los productos
    //Traer: Peticiones de GET
    @Autowired
    private ProductService servicio;
    @GetMapping("/productos")
    public List<Product> FindAllProducts() {
        //Utilizar el service para traer los productos
        //Necesitamos una instancia del service en el controller
        return servicio.FindAll();

    }

    //Segundo endpoint
    //traer un producto por id
    //Metodo http: GET
    @GetMapping("/productoporid/{id}")
    public Product findProductById(@PathVariable Long id) {
        return servicio.FindById(id);
    }

    //Tercer EndPoint
    //grabar un nuevo producto
    //que llegue por el body de la request(payload)
 
    @PostMapping("/nuevoproducto")
    public Product newProduct(@RequestBody Product p) {
    return servicio.create(p);
    }

    //cuarto endpoint
    //borrar un producto por id
    //Method HTTP: delete
    @DeleteMapping("/borrarporid/{id}")
    public Product deleteProductById(@PathVariable Long id)
    {
        return servicio.deleteProduct(id);
    }

    //quinto endpoint
    //actualizar un producto por id
    @PutMapping("actualizarporid/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product p) {
        return servicio.actualizar(id, p);
    }

}
