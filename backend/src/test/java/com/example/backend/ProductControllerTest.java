package com.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
}