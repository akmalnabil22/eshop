package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import id.ac.ui.cs.advprog.eshop.service.CarService;
import id.ac.ui.cs.advprog.eshop.service.ProductService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.matchesRegex;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mvc;
    @SuppressWarnings("removal")
    @MockBean
    private ProductService productService;

    @SuppressWarnings("removal")
    @MockBean
    private ProductRepository productRepository;
    private static Gson gson;

    @BeforeAll
    static void setUp() {
        gson = new Gson();
    }
    @Test
    void testCreateProduct() throws Exception {
        mvc.perform(get("/product/create"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().string(containsString("<h3>Create New Product</h3>")))
                .andExpect(content().string(matchesRegex("(?s).*?<label.*?>Name</label>.*?(?-s)")))
                .andExpect(content().string(matchesRegex("(?s).*?<input.*?id=\"nameInput\".*?>.*?(?-s)")))
                .andExpect(content().string(matchesRegex("(?s).*?<label.*?>Quantity</label>.*?(?-s)")))
                .andExpect(content().string(matchesRegex("(?s).*?<input.*?id=\"nameInput\".*?>.*?(?-s)")))
                .andExpect(content().string(matchesRegex("(?s).*?<button type=\"submit\".*?>Submit</button>.*?(?-s)")));

        Product product = new Product();
        product.setProductName("Susu Kuda");
        product.setProductQuantity(5);

        Mockito.when(productService.create(product)).thenReturn(product);

        String productJson = gson.toJson(product, Product.class);

        mvc.perform(post("/product/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("list"));

        List<Product> products = new ArrayList<>();
        products.add(product);

        Mockito.when(productService.findAll()).thenReturn(products);
        mvc.perform(get("/product/list"))
                .andExpect(content().string(containsString("Susu Kuda")));
    }
    @Test
    void testEditProduct() throws Exception {
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Susu Kuda");
        product.setProductQuantity(5);

        Mockito.when(productService.findProduct("1")).thenReturn(product);
        mvc.perform(get("/product/edit/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<title>Edit Product</title>")));

        Product editedProduct = new Product();
        editedProduct.setProductId(product.getProductId());
        editedProduct.setProductName("Susu Badag");
        editedProduct.setProductQuantity(10);

        String productJson = gson.toJson(editedProduct, Product.class);
        mvc.perform(post("/product/edit/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(productJson))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/product/list"));

    }
    @Test
    void testDeleteProduct() throws Exception {
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Susu Kuda");
        product.setProductQuantity(5);
        mvc.perform(get("/product/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/product/list"));

    }
}
