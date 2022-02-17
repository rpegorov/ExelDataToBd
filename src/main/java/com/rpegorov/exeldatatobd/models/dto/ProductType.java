package com.rpegorov.exeldatatobd.models.dto;

public enum ProductType {
    QOIL("QOIL"), QLIQ("QLIQ");

    private String productType;

    ProductType(String productType) {
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }
}
