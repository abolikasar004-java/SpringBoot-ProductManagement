package com.example.productProject.Service;

import com.example.productProject.Entity.Product;
import com.example.productProject.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product addproduct(Product product) {
        return productRepo.save(product);
    }

    public Product getProductByid(Long id){
        return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }

    public void deleteProduct(long id){
        Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id " + id));
        productRepo.deleteById(id);
    }

    public Product updateProduct(long id, Product product) {

        Product existingProduct = productRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id " + id));

        existingProduct.setProductName(product.getProductName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCost(product.getCost());
        existingProduct.setCategory(product.getCategory());

        return productRepo.save(existingProduct);
    }

}

