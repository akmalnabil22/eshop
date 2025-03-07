package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PaymentRepository {
    Map<Payment, Order> payments = new HashMap<>();

    public Payment save(Payment payment, Order order) {
        return null;
    }

    public Payment getPayment(String id) {
        return null;
    }

    public Map<Payment, Order> getAllPayments() {
        return null;
    }

}
