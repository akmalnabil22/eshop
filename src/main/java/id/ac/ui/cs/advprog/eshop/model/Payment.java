package id.ac.ui.cs.advprog.eshop.model;

import java.util.Map;
import lombok.Setter;
import lombok.Getter;

@Getter
public class Payment {

    String id;
    String method;
    @Setter
    String status;
    Map<String, String> paymentData;

    Payment(String id, String method, Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        this.paymentData = paymentData;

        if (method.equals("VOUCHER_CODE")) {
            if (isVoucherValid(paymentData.get("voucherCode"))) {
                this.status = "SUCCESS";
            } else {
                this.status = "REJECTED";
            }
        }

        if (method.equals("BANK_TRANSFER")) {
            if (isBankTransferValid(paymentData)) {
                this.status = "SUCCESS";
            } else {
                this.status = "REJECTED";
            }
        }
    }

    private boolean isBankTransferValid(Map<String, String> paymentData) {
        if (paymentData.get("bankName") == null || paymentData.get("referenceCode") == null) {
            return false;
        }

        if (paymentData.get("bankName").isEmpty()) {
            return false;
        }

        if (paymentData.get("referenceCode").isEmpty()) {
            return false;
        }

        return true;
    }

    private boolean isVoucherValid (String code) {
        if (code.length() != 16) return false;
        if (!code.startsWith("ESHOP")) return false;

        code = code.substring(5);
        int numCount = 0;
        for (char c : code.toCharArray()) {
            if (Character.isDigit(c)) numCount++;
        }
        if (numCount != 8) return false;

        return true;
    }
}
