package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import  static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {
    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private ProductRepository productRepository;
    @BeforeEach
    void setUp() {

    }
    @Test
    void testCreate() {
        Product product = new Product();
        Product productCreated = productService.create(product);
        assertEquals(product, productCreated);
    }
    @Test
    void testFindAll() {
        Product product1 = new Product();
        Product product2 = new Product();
        productService.create(product1);
        productService.create(product2);
        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2).iterator());
        List<Product> products = productService.findAll();
        assertEquals(product1, products.get(0));
        assertEquals(product2, products.get(1));
    }
    @Test
    void testFindById() {
        Product product1 = new Product();
        productService.create(product1);
        when(productService.findProduct(product1.getProductId())).thenReturn(product1);
        Product productFound = productService.findProduct(product1.getProductId());
        assertEquals(product1, productFound);
    }
    @Test
    void testUpdate() {
        Product product1 = new Product();
        product1.setProductName("Susu Cap Kuda");
        productService.create(product1);

        when(productRepository.findAll()).thenReturn(Arrays.asList(product1).iterator());
        List<Product> products = productService.findAll();
        assertEquals(product1.getProductName(), products.getFirst().getProductName());

        Product product2 = new Product();
        product2.setProductName("Susu Cap Sapi");
        productService.update(product1.getProductId(), product2);

        when(productRepository.findAll()).thenReturn(Arrays.asList(product2).iterator());
        products = productService.findAll();
        assertEquals(product2.getProductName(), products.getFirst().getProductName());
    }
    @Test
    void testDelete() {
        Product product1 = new Product();
        productService.create(product1);
        when(productRepository.findAll()).thenReturn(Arrays.asList(product1).iterator());
        List<Product> products = productService.findAll();
        assertFalse(products.isEmpty());
        productService.delete(product1.getProductId());
        products = productService.findAll();
        assertTrue(products.isEmpty());
    }
}
