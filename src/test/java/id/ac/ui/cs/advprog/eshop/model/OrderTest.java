package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    private List<Product> products;
    @BeforeEach
    void setUp() {
        this.products = new ArrayList<Product>();
        Product product1 = new Product();
        product1.setProductId("0aae0f72-0813-4aaa-a735-e7554e98b1db");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        Product product2 = new Product();
        product2.setProductId("7740d220-d024-42a4-a4b3-738e9c42e0ee");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);
        this.products.add(product1);
        this.products.add(product2);
    }
    @Test
    void testCreateOrderEmptyProduct() {
        this.products.clear();

        assertThrows(IllegalArgumentException.class, () -> {
            Order order = new Order("6cd6dfe9-282a-42a0-8921-891c25b66e78",
                    this.products, 1708560000L, "Safira Sudrajat");
        });
    }
    @Test
    void testCreateOrderDefaultStatus() {
        Order order = new Order("6cd6dfe9-282a-42a0-8921-891c25b66e78",
                this.products, 1708560000L, "Safira Sudrajat");

        assertSame(this.products, order.getProducts());
        assertEquals(2, order.getProducts().size());
        assertEquals("Sampo Cap Bambang", order.getProducts().get(0).getProductName());
        assertEquals("Sabun Cap Usep", order.getProducts().get(1).getProductName());

        assertEquals("6cd6dfe9-282a-42a0-8921-891c25b66e78", order.getId());
        assertEquals(1708560000L, order.getOrderTime());
        assertEquals("Safira Sudrajat", order.getAuthor());
        assertEquals("WAITING_PAYMENT", order.getStatus());
    }
    @Test
    void testCreateOrderSuccessStatus() {
        Order order = new Order("6cd6dfe9-282a-42a0-8921-891c25b66e78",
                this.products, 1708560000L, "Safira Sudrajat", "SUCCESS");
        assertEquals("SUCCESS", order.getStatus());
    }
    @Test
    void testCreateOrderInvalidStatus() {
        assertThrows(IllegalArgumentException.class, () -> {
            Order order = new Order("6cd6dfe9-282a-42a0-8921-891c25b66e78",
                    this.products, 1708560000L, "Safira Sudrajat", "MEOW");
        });
    }
    @Test
    void testSetStatusToCancelled() {
        Order order = new Order("6cd6dfe9-282a-42a0-8921-891c25b66e78",
                this.products, 1708560000L, "Safira Sudrajat");
        order.setStatus("CANCELLED");
        assertEquals("CANCELLED", order.getStatus());
    }
    @Test
    void testSetStatusToInvalidStatus() {
        Order order = new Order("6cd6dfe9-282a-42a0-8921-891c25b66e78",
                this.products, 1708560000L, "Safira Sudrajat");
        assertThrows(IllegalArgumentException.class, () -> order.setStatus("MEOW"));
    }
}
