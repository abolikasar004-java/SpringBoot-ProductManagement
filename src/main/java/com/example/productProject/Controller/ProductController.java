package com.example.productProject.Controller;

import com.example.productProject.Entity.Product;
import com.example.productProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/createProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product savedProduct = productService.addproduct(product);
        return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
//        Product fetchedProduct = productService.getproductByid(id);
//        return new ResponseEntity<>(fetchedProduct,HttpStatus.OK);
        return new ResponseEntity<>(productService.getProductByid(id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("product deleted successfully ",HttpStatus.OK);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable long id, @RequestBody Product product) {
        try {
            Product updatedProduct = productService.updateProduct(id, product);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
