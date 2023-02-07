package com.example.backend;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @PostMapping()
    public Product addProduct(@RequestBody ProductDTO productDTO){
        return productService.addProduct(productDTO);
    }
    @DeleteMapping("/{id}")
    public boolean removeProduct(@PathVariable String id){
        return productService.removeProduct(id);
    }
}
