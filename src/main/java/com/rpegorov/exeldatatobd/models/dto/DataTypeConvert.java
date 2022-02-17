package com.rpegorov.exeldatatobd.models.dto;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class DataTypeConvert implements AttributeConverter<DataType, String> {

    @Override
    public String convertToDatabaseColumn(DataType dataType) {
        if (dataType == null) {
            return null;
        }
        return dataType.getDataType();
    }

    @Override
    public DataType convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return Stream.of(DataType.values())
                .filter(d -> d.getDataType().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
