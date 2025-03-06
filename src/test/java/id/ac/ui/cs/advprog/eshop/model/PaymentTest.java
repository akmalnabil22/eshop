package id.ac.ui.cs.advprog.eshop.model;

import static org.junit.jupiter.api.Assertions.*;

import enums.PaymentMethod;
import enums.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class PaymentTest {
    Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        this.paymentData = new HashMap<>();
    }

    @Test
    void testValidVoucher() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("4561efbb-a231-4015-a074-947e55656824",
                PaymentMethod.VOUCHER_CODE.getValue(), paymentData);

        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }
    @Test
    void testInvalidVoucher() {
        paymentData.put("voucherCode", "INVALIDCODE");
        Payment payment = new Payment("4561efbb-a231-4015-a074-947e55656824",
                PaymentMethod.VOUCHER_CODE.getValue(), paymentData);

        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }

    @Test
    void testValidBankTransfer() {
        paymentData.put("bankName", "Bank Kalan");
        paymentData.put("referenceCode", "02092004");
        Payment payment = new Payment("4561efbb-a231-4015-a074-947e55656824",
                PaymentMethod.BANK_TRANSFER.getValue(), paymentData);

        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testInvalidBankTransfer() {
        paymentData.put("bankName", "Bank Kalan");
        paymentData.put("referenceCode", null);
        Payment payment = new Payment("4561efbb-a231-4015-a074-947e55656824",
                PaymentMethod.BANK_TRANSFER.getValue(), paymentData);

        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }
}
