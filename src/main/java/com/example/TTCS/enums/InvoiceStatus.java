package com.example.TTCS.enums;

public enum InvoiceStatus {
    ISSUED("issued"),
    PAID("paid"),
    CANCELLED("cancelled");

    private final String value;

    InvoiceStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static InvoiceStatus fromValue(String value) {
        for (InvoiceStatus status : values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid InvoiceStatus value: " + value);
    }
}
