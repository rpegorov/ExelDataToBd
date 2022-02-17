package com.rpegorov.exeldatatobd.models.dto;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ProductTypeConvert implements AttributeConverter<ProductType, String> {
    @Override
    public String convertToDatabaseColumn(ProductType productType) {
        if (productType == null) {
            return null;
        }
        return productType.getProductType();
    }

    @Override
    public ProductType convertToEntityAttribute(String s) {
        if (s == null) {
            return null;
        }
        return Stream.of(ProductType.values())
                .filter(p -> p.getProductType().equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
