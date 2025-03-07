package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryTest {

    PaymentRepository paymentRepository;
    List<Payment> payments = new ArrayList<>();

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();

        Map<String, String> paymentData1 = new HashMap<>();
        paymentData1.put("voucherCode", "ESHOP12345678ABC");
        Payment payment1 = new Payment("PAYMENT1", "VOUCHER_CODE", paymentData1);
        payments.add(payment1);
        Map<String, String> paymentData2 = new HashMap<>();
        paymentData2.put("bankName", "BANK KALAN");
        paymentData2.put("referenceCode", "123456789");
        Payment payment2 = new Payment("PAYMENT2", "BANK_TRANSFER", paymentData2);
        payments.add(payment2);
    }

    @Test
    void testCreate() {
        Payment payment = payments.get(0);
        Payment result = paymentRepository.save(payment);

        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getPaymentData(), result.getPaymentData());
        assertEquals(payment.getMethod(), result.getMethod());
        assertEquals(payment.getStatus(), result.getStatus());
    }

    @Test
    void testGetPaymentFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment payment = paymentRepository.getPayment(payments.get(1).getId());
        assertEquals(payment.getId(), payments.get(1).getId());
        assertEquals(payment.getPaymentData(), payments.get(1).getPaymentData());
        assertEquals(payment.getMethod(), payments.get(1).getMethod());
        assertEquals(payment.getStatus(), payments.get(1).getStatus());
    }

    @Test
    void testGetPaymentNotFound() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        Payment payment = paymentRepository.getPayment("INVALID-ID");
        assertNull(payment);
    }

    @Test
    void testGetAllPayments() {
        for (Payment payment : payments) {
            paymentRepository.save(payment);
        }

        List<Payment> result = paymentRepository.getAllPayments();
        assertEquals(payments.size(), result.size());
    }
}
