package id.ac.ui.cs.advprog.eshop.repository;

import enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderRepositoryTest {
    OrderRepository orderRepository;

    List<Order> orders;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();

        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("d95861aa-4683-4674-a140-59cddd100315");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        orders = new ArrayList<>();
        Order order1 = new Order("5a2928c7-2437-47d9-856b-9c848a417df5",
                products, 1708560000L, "Safira Sudrajat");
        orders.add(order1);
        Order order2 = new Order("1be6c899-af18-467d-9ba5-ea0196e05a21",
                products, 1708560000L, "Safira Sudrajat");
        orders.add(order2);
        Order order3 = new Order("6352f9de-1b2a-47ab-b092-810d8cd61363",
                products, 1708560000L, "Safira Sudrajat");
        orders.add(order3);
    }
    @Test
    void testSaveCreate() {
        Order order = orders.get(1);
        Order result = orderRepository.save(order);

        Order findResult = orderRepository.findById(orders.get(1).getId());
        assertEquals(order.getId(), result.getId());
        assertEquals(order.getId(), findResult.getId());
        assertEquals(order.getOrderTime(), result.getOrderTime());
        assertEquals(order.getAuthor(), result.getAuthor());
        assertEquals(order.getStatus(), result.getStatus());
    }
    @Test
    void testSaveUpdate() {
        Order order = orders.get(1);
        orderRepository.save(order);
        Order newOrder = new Order(order.getId(), order.getProducts(), order.getOrderTime(),
                order.getAuthor(), OrderStatus.SUCCESS.getValue());
        Order result = orderRepository.save(newOrder);

        Order findResult = orderRepository.findById(orders.get(1).getId());
        assertEquals((order.getId(), result.getId()));
        assertEquals(order.getId(), findResult.getId());
        assertEquals(order.getOrderTime(), result.getOrderTime());
        assertEquals(order.getAuthor(), result.getAuthor());
        assertEquals(OrderStatus.SUCCESS.getValue(), result.getStatus());
    }
    @Test
    void testFindByIdIfIdFound() {
        for (Order order : orders) {
            orderRepository.save(order);
        }

        Order findResult = orderRepository.findById(orders.get(1).getId());
        assertEquals(orders.get(1).getId(), findResult.getId());
        assertEquals(orders.get(1).getOrderTime(), findResult.getOrderTime());
        assertEquals(orders.get(1).getAuthor(), findResult.getAuthor());
        assertEquals(orders.get(1).getStatus(), findResult.getStatus());
    }
    @Test
    void testFindByIdIfIdNotFound() {
        for (Order order : orders) {
            orderRepository.save(order);
        }

        Order findResult = orderRepository.findById("zczc");
        assertNull(findResult);
    }
    @Test
    void testFindAllByAuthorIfAuthorCorrect() {
        for (Order order : orders) {
            orderRepository.save(order);
        }

        List<Order> orderList = orderRepository.findAllByAuthor(
                orders.get(1).getAuthor());
        assertEquals(2, orderList.size());
    }
    @Test
    void testFindAllByAuthorIfAllLowecase() {
        orderRepository.save(orders.get(1));

        List<Order> orderList = orderRepository.findAllByAuthor(
                orders.get(1).getAuthor().toLowerCase());
        assertTrue(orderList.isEmpty());
    }
}
