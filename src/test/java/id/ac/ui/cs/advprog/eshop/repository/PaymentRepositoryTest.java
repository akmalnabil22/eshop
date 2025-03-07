package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryTest {

    PaymentRepository paymentRepository;
    List<Order> orders;
    List<Payment> payments;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();

        List<Product> products = new ArrayList<>();
        Product product = new Product();
        product.setProductName("product");
        product.setProductQuantity(1);
        products.add(product);

        orders = new ArrayList<>();
        Order order1 = new Order("ORDERID1", products, 1709729613L, "MAL");
        orders.add(order1);
        Order order2 = new Order("ORDERID2", products, 1709729613L, "FEMAL");
        orders.add(order2);
        Order order3 = new Order("ORDERID3", products, 1709729613L, "MUL");

        Map<String, String> paymentData1 = new HashMap<>();
        paymentData1.put("voucherCode", "ESHOP12345678ABC");
        Payment payment1 = new Payment("PAYMENT1", "VOUCHER_CODE", paymentData1);
        payments.add(payment1);
        Map<String, String> paymentData2 = new HashMap<>();
        paymentData2.put("bankName", "BANK KALAN");
        paymentData2.put("referenceCode", "123456789");
        Payment payment2 = new Payment("PAYMENT2", "BANK", paymentData2);
        payments.add(payment2);
    }

    @Test
    void testCreate() {
        Payment payment = payments.get(0);
        Order order = orders.get(0);
        Payment result = paymentRepository.save(payment, order);

        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getPaymentData(), result.getPaymentData());
        assertEquals(payment.getMethod(), result.getMethod());
        assertEquals(payment.getStatus(), result.getStatus());
    }

    @Test
    void testGetPaymentFound() {
        for(int i=0; i<payments.size(); i++) {
            Payment payment = payments.get(i);
            Order order = orders.get(i);
            paymentRepository.save(payment, order);
        }

        Payment payment = paymentRepository.GetPayment(payments.get(1).getId());
        assertEquals(payment.getId(), payments.get(1).getId());
        assertEquals(payment.getPaymentData(), payments.get(1).getPaymentData());
        assertEquals(payment.getMethod(), payments.get(1).getMethod());
        assertEquals(payment.getStatus(), payments.get(1).getStatus());
    }

    @Test
    void testGetPaymentNotFound() {
        for(int i=0; i<payments.size(); i++) {
            Payment payment = payments.get(i);
            Order order = orders.get(i);
            paymentRepository.save(payment, order);
        }

        Payment payment = paymentRepository.GetPayment("INVALID-ID");
        assertNull(payment);
    }

    @Test
    void testGetAllPayments() {
        for(int i=0; i<payments.size(); i++) {
            Payment payment = payments.get(i);
            Order order = orders.get(i);
            paymentRepository.save(payment, order);
        }

        Map<Payment, Order> map =  paymentRepository.getAllPayments();
        assertEquals(map.size(), payments.size());
    }
}
