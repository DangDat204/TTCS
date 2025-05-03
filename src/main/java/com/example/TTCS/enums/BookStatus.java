package com.example.TTCS.enums;

public enum BookStatus {
    AVAILABLE("available"),
    OUT_OF_STOCK("out_of_stock"),
    HIDDEN("hidden");

    private final String value;

    BookStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BookStatus fromValue(String value) {
        for (BookStatus status : values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid BookStatus value: " + value);
    }
}
