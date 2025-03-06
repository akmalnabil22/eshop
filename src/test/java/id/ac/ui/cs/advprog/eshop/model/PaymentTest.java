package id.ac.ui.cs.advprog.eshop.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class PaymentTest {
    HashMap<String, String> paymentData;

    @BeforeEach
    void setUp() {
        this.paymentData = new HashMap<>();
    }

    @Test
    void testValidVoucher() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("4561efbb-a231-4015-a074-947e55656824",
                "VOUCHER_CODE", paymentData);

        assertEquals("SUCCESS", payment.getStatus());
    }
    @Test
    void testInvalidVoucher() {
        paymentData.put("voucherCode", "INVALIDCODE");
        Payment payment = new Payment("4561efbb-a231-4015-a074-947e55656824",
                "VOUCHER_CODE", paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }

    @Test
    void testValidBankTransfer() {
        paymentData.put("bankName", "Bank Kalan");
        paymentData.put("referenceCode", "02092004");
        Payment payment = new Payment("4561efbb-a231-4015-a074-947e55656824",
                "BANK_TRANSFER", paymentData);

        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testInvalidBankTransfer() {
        paymentData.put("bankName", "Bank Kalan");
        paymentData.put("referenceCode", null);
        Payment payment = new Payment("4561efbb-a231-4015-a074-947e55656824",
                "BANK_TRANSFER", paymentData);

        assertEquals("REJECTED", payment.getStatus());
    }
}
