package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import  static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp() {
    }
    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("04651c0a-3304-4ff5-b670-0641ab2f92f3");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> iterator = productRepository.findAll();
        assertTrue(iterator.hasNext());
        Product foundProduct = iterator.next();
        assertEquals(product.getProductId(), foundProduct.getProductId());
        assertEquals(product.getProductName(), foundProduct.getProductName());
        assertEquals(product.getProductQuantity(), foundProduct.getProductQuantity());
    }
    @Test
    void testFindAllEmpty() {
        Iterator<Product> iterator = productRepository.findAll();
        assertFalse(iterator.hasNext());
    }
    @Test
    void testFindAllIfMoreThanOne() {
        Product product1 = new Product();
        product1.setProductId("04651c0a-3304-4ff5-b670-0641ab2f92f3");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("cc66d198-95f2-463e-b355-baf56d04b176");
        product2.setProductName("Sampo Cap Kuda");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> iterator = productRepository.findAll();
        assertTrue(iterator.hasNext());
        Product foundProduct = iterator.next();
        assertEquals(product1.getProductId(), foundProduct.getProductId());
        foundProduct = iterator.next();
        assertEquals(product2.getProductId(), foundProduct.getProductId());
        assertFalse(iterator.hasNext());
    }
    @Test
    void testUpdate(){
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);
        Product product2 = new Product();
        product2.setProductName("Sampo Cap Kuda");
        product2.setProductQuantity(50);
        productRepository.update(product1.getProductId(), product2);
        Iterator<Product> iterator = productRepository.findAll();
        Product foundProduct = iterator.next();
        assertEquals("Sampo Cap Kuda", foundProduct.getProductName());
        assertEquals(50, foundProduct.getProductQuantity());
    }
    @Test
    void testDelete(){
        Product product1 = new Product();
        productRepository.create(product1);
        Iterator<Product> iterator = productRepository.findAll();
        assertTrue(iterator.hasNext());
        productRepository.delete(product1.getProductId());
        assertFalse(iterator.hasNext());
    }
}
