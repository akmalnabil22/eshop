package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    List<Payment> payments = new ArrayList<>();

    public Payment save(Payment payment) {
        int i = 0;
        for (Payment p : payments) {
            if (p.getId().equals(payment.getId())) {
                payments.remove(i);
                payments.add(i, payment);
                return payment;
            }
        }
        payments.add(i, payment);
        return payment;
    }

    public Payment getPayment(String id) {
        for (Payment p : payments) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public List<Payment> getAllPayments() {
        List<Payment> result = new ArrayList<>();
        for (Payment p : payments) {
            result.add(p);
        }
        return result;
    }

}
