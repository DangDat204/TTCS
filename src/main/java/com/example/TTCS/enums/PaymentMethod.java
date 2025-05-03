package com.example.TTCS.enums;

public enum PaymentMethod {
    COD("cod"),
    CARD("card"),
    WALLET("wallet");

    private final String value;

    PaymentMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static PaymentMethod fromValue(String value) {
        for (PaymentMethod method : values()) {
            if (method.value.equalsIgnoreCase(value)) {
                return method;
            }
        }
        throw new IllegalArgumentException("Invalid PaymentMethod value: " + value);
    }
}
