package id.ac.ui.cs.advprog.eshop.model;

import java.util.Map;

public class Payment {

    String id;
    String method;
    String status;
    Map<String, String> paymentData;

    Payment(String id, String method, Map<String, String> paymentData) {
    }
}
