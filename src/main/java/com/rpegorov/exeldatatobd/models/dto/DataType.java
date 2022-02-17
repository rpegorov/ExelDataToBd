package com.rpegorov.exeldatatobd.models.dto;

public enum DataType {
    FACT("FACT"), FORECAST("FORECAST");

    private String dataType;

    DataType(String dataType) {
        this.dataType = dataType;
    }

    public String getDataType() {
        return dataType;
    }
}
