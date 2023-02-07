package com.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    IDGeneratorService idGeneratorService;

    @Test
    @DirtiesContext
    void addProduct() throws Exception {
        mockMvc.perform(post("/api/products/").contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name": "Sofa Steffanie",
                                "quantity": 5
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {"name": "Sofa Steffanie",
                        "quantity": 5
                        }
                        """));

    }
    @Test
    @DirtiesContext
    void deleteProduct() throws Exception {
        Product newProduct = new Product("10", "name", 5);
        productRepository.save(newProduct);
        mockMvc.perform(delete("/api/products/10").contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"name": "Sofa Steffanie",
                                "quantity": 5
                                }
                                """))
                .andExpect(status().isOk());


    }
    @Test
    @DirtiesContext
    void getAllProducts() throws Exception {
        Product newProduct1 = new Product("10", "name2", 5);
        Product newProduct2 = new Product("13", "name3", 10);
        productRepository.save(newProduct1);
        productRepository.save(newProduct2);
        mockMvc.perform(get("/api/products/"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        [{"name": "name2",
                        "quantity": 5
                        }, {"name": "name3",
                        "quantity": 10
                        }]
                        """));

    }
}