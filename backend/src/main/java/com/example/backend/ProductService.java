package com.example.backend;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
private final ProductRepository productRepository;
private final IDGeneratorService idGeneratorService;


    public ProductService(ProductRepository productRepository, IDGeneratorService idGeneratorService) {
        this.productRepository = productRepository;
        this.idGeneratorService = idGeneratorService;
    }
    public Product addProduct(ProductDTO productDTO){
        String id = idGeneratorService.generateID();
        Product newProduct = new Product(id, productDTO.name(),
                productDTO.quantity());
        return productRepository.save(newProduct);
    }

    public boolean removeProduct(String id) {

        for (Product removedProduct:productRepository.findAll()) {
            if(removedProduct.id.equals(id)){
                productRepository.delete(removedProduct);
                return true;
            }
        }
        return false;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}


